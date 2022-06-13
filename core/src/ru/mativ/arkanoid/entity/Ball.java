package ru.mativ.arkanoid.entity;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Ball extends Entity {
    private Vector2 velosity;
    private Vector2 lastPositin = new Vector2();

    public Ball(Sprite sprite, String name) {
        super(EntityType.BALL, name);
        this.setSprite(sprite);
        velosity = new Vector2();
    }

    public void setVelosity(float x, float y) {
        velosity.set(x, y);
    }

    public void flipVelosityX() {
        velosity.set(-velosity.x, velosity.y);
    }

    public void flipVelosityY() {
        velosity.set(velosity.x, -velosity.y);
    }

    public void update(float delta) {
        lastPositin.x = this.sprite.getX();
        lastPositin.y = this.sprite.getY();
        sprite.translate(velosity.x * delta, velosity.y * delta);
    }

    public void stepBack() {
        sprite.setPosition(lastPositin.x, lastPositin.y);
    }

    public Circle getCircle() {
        Rectangle rect = getRectangle();
        float r = rect.width / 2;
        return new Circle(rect.x + r, rect.y + r, r);
    }
}
