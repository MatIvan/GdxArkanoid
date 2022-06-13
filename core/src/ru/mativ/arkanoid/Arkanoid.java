package ru.mativ.arkanoid;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

import ru.mativ.arkanoid.entity.Ball;
import ru.mativ.arkanoid.entity.Entity;
import ru.mativ.arkanoid.math.Collision;
import ru.mativ.arkanoid.math.GeomUtils;

public class Arkanoid extends ApplicationAdapter {
    private static final String BACKGROUND = "background-game.png";
    private static final boolean DEBUG = true;
    private static final String LEVEL_LAYER = "lvl";
    private static final String GAME_LAYER = "game";
    private static final String ASSETS_NAME = "arkanoid";

    private DrawTool drawTool;
    private Loader loader;

    private List<Entity> entityList;
    private List<Entity> blocks;

    private List<Ball> balls;

    @Override
    public void create() {
        Texture background = new Texture(Gdx.files.internal(BACKGROUND));
        drawTool = new DrawTool(background);
        loader = new Loader(ASSETS_NAME);
        entityList = loader.createFromLayer(GAME_LAYER);
        loadLevel(1);

        init();
    }

    private void init() {
        balls = new ArrayList<Ball>();
        for (Entity entity : entityList) {
            switch (entity.getType()) {
                case BALL:
                    Ball ball = (Ball) entity;
                    ball.setVelosity(100, 100);
                    balls.add(ball);
                    break;
            }
        }
    }

    private void loadLevel(int level) {
        blocks = loader.createFromLayer(LEVEL_LAYER + String.valueOf(level));
    }

    @Override
    public void render() {
        final float delta = Gdx.graphics.getDeltaTime();

        for (Ball ball : balls) {
            ball.update(delta);
            updateCollisions(ball, entityList);
            updateCollisions(ball, blocks);
        }

        drawTool.begin();
        drawTool.draw(entityList);
        drawTool.draw(blocks);
        drawTool.end();
        if (DEBUG) {
            drawTool.debugBegin();
            drawTool.debugDraw(entityList);
            drawTool.debugDraw(blocks);
            drawTool.debugEnd();
        }
    }

    private void updateCollisions(Ball ball, List<Entity> entityList) {
        List<Collision> collisionList = GeomUtils.getCollisions(ball, entityList);
        for (Collision collision : collisionList) {
            ball.stepBack();
            if (collision.isTop() || collision.isBottom()) {
                ball.flipVelosityY();
            }else
            if (collision.isLeft() || collision.isRight()) {
                ball.flipVelosityX();
            }
        }
    }

    @Override
    public void dispose() {
        drawTool.dispose();
        loader.dispose();
    }
}
