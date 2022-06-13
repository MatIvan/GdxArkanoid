package ru.mativ.arkanoid;

import java.util.List;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;

import ru.mativ.arkanoid.entity.Entity;

public class DrawTool {
    private OrthographicCamera camera;
    private SpriteBatch batch;
    private ShapeRenderer shapeRenderer;
    private Texture background;

    public DrawTool(Texture background) {
        this.background = background;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 600);
        batch = new SpriteBatch();
        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setAutoShapeType(true);
    }

    public void begin() {
        ScreenUtils.clear(0.8f, 0.8f, 0.8f, 1);
        camera.update();
        batch.setProjectionMatrix(camera.combined);

        batch.begin();
        batch.draw(background, 0, 0);
    }

    public void draw(List<Entity> entityList) {
        for (Entity e : entityList) {
            e.draw(batch);
        }
    }

    public void end() {
        batch.end();
    }

    public void debugBegin() {
        shapeRenderer.setProjectionMatrix(camera.combined);
        shapeRenderer.begin();
    }

    public void debugDraw(List<Entity> entityList) {
        shapeRenderer.setColor(Color.BLUE);
        for (Entity e : entityList) {
            e.debugDraw(shapeRenderer);
        }
    }

    public void debugEnd() {
        shapeRenderer.end();
    }

    public void dispose() {
        batch.dispose();
        shapeRenderer.dispose();
        background.dispose();
    }
}
