package ru.mativ.arkanoid.math;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import ru.mativ.arkanoid.entity.Ball;
import ru.mativ.arkanoid.entity.Entity;

public class GeomUtils {

    public GeomUtils() {
        super();
    }

    public static List<Collision> getCollisions(Ball ball, List<Entity> list) {
        List<Collision> collisionList = new ArrayList<>();
        for (Entity entity : list) {
            Collision collision = checkCollision(ball, entity);
            if (collision != null) {
                collisionList.add(collision);
                Gdx.app.log("collision", collision.toString());
            }
        }
        return collisionList;
    }

    private static Collision checkCollision(Ball ball, Entity entity) {
        if (ball.equals(entity)) {
            return null;
        }
        final Rectangle ballRect = ball.getRectangle();
        final Rectangle entityRect = entity.getRectangle();

        if (!ballRect.overlaps(entityRect)) {
            return null;
        }

        Circle circle = ball.getCircle();
        if (!Intersector.overlaps(circle, entityRect)) {
            return null;
        }

        Collision сollision = new Collision(ball, entity);

        Line lineTop = getLineTop(entityRect);
        Line lineBottom = getLineBottom(entityRect);
        Line lineLeft = getLineLeft(entityRect);
        Line lineRight = getLineRight(entityRect);

        сollision.setTop(checkLine(lineTop, circle));
        сollision.setBottom(checkLine(lineBottom, circle));
        сollision.setLeft(checkLine(lineLeft, circle));
        сollision.setRight(checkLine(lineRight, circle));

        return сollision;
    }

    public static Line getLineTop(Rectangle rect) {
        Vector2 start = new Vector2(rect.x, rect.y + rect.height);
        Vector2 end = new Vector2(rect.x + rect.width, rect.y + rect.height);
        return new Line(start, end);
    }

    public static Line getLineBottom(Rectangle rect) {
        Vector2 start = new Vector2(rect.x, rect.y);
        Vector2 end = new Vector2(rect.x + rect.width, rect.y);
        return new Line(start, end);
    }

    public static Line getLineLeft(Rectangle rect) {
        Vector2 start = new Vector2(rect.x, rect.y);
        Vector2 end = new Vector2(rect.x, rect.y + rect.height);
        return new Line(start, end);
    }

    public static Line getLineRight(Rectangle rect) {
        Vector2 start = new Vector2(rect.x + rect.width, rect.y);
        Vector2 end = new Vector2(rect.x + rect.width, rect.y + rect.height);
        return new Line(start, end);
    }

    public static boolean checkLine(Line line, Circle circle) {
        return Intersector.intersectSegmentCircle(line.getStart(), line.getEnd(), circle, null);
    }
}
