package ru.mativ.arkanoid;

import java.util.List;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;

import ru.mativ.arkanoid.entity.Entity;

public class Arkanoid extends ApplicationAdapter {
    private static final boolean DEBUG = true;
    private static final String LEVEL_1_LAYER = "lvl1";
    private static final String GAME_LAYER = "game";
    private static final String ASSETS_NAME = "arkanoid";
    OrthographicCamera camera;
    SpriteBatch batch;
    ShapeRenderer shapeRenderer;
    Loader loader;

    Texture background;

    List<Entity> entityList;
    List<Entity> lvl1;

    @Override
    public void create() {
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 600);
        batch = new SpriteBatch();
        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setAutoShapeType(true);
        shapeRenderer.setColor(Color.BLUE);

        loader = new Loader(ASSETS_NAME);
        entityList = loader.createFromLayer(GAME_LAYER);
        lvl1 = loader.createFromLayer(LEVEL_1_LAYER);

        background = new Texture(Gdx.files.internal("background-game.png"));
    }

    @Override
    public void render() {
        ScreenUtils.clear(0.8f, 0.8f, 0.8f, 1);
        camera.update();
        batch.setProjectionMatrix(camera.combined);

        batch.begin();
        batch.draw(background, 0, 0);
        for (Entity e : entityList) {
            e.draw(batch);
        }
        for (Entity e : lvl1) {
            e.draw(batch);
        }
        batch.end();

        if (DEBUG) {
            debugDraw();
        }
    }

    private void debugDraw() {
        shapeRenderer.setProjectionMatrix(camera.combined);
        shapeRenderer.begin();
        for (Entity e : entityList) {
            e.debugDraw(shapeRenderer);
        }
        for (Entity e : lvl1) {
            e.debugDraw(shapeRenderer);
        }
        shapeRenderer.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        loader.dispose();
    }
}
