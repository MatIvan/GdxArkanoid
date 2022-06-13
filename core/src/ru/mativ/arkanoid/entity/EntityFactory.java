package ru.mativ.arkanoid.entity;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;

public class EntityFactory {
    private static final String PROP_HEIGHT = "height";
    private static final String PROP_WIDTH = "width";
    private static final String PROP_Y = "y";
    private static final String PROP_X = "x";
    private static final String PROP_TYPE = "type";
    private static final String[] BITA_NAMES = { "bita", "bita-1", "bita-2", "bita-3" };
    private TextureAtlas atlas;

    public EntityFactory(TextureAtlas atlas) {
        this.atlas = atlas;
    }

    public Entity create(MapObject obj) {
        MapProperties prop = obj.getProperties();
        String name = obj.getName();
        EntityType type = EntityType.get(getString(prop, PROP_TYPE));
        Rectangle rect = createRectangle(prop);
        Sprite sprite;

        switch (type) {
            case BALL:
                sprite = createSprite(type.getName(), rect);
                return new Ball(sprite, name);
            case BITA:
                sprite = getRandomBita(rect);
                return new Bita(sprite, name);
            case BLOCK1:
                sprite = getRandomFlippedBlock(type.getName(), rect);
                return new Block1(sprite, name);
            case BLOCK2:
                sprite = getRandomFlippedBlock(type.getName(), rect);
                return new Block2(sprite, name);
            case WALL:
                return new Wall(rect, name);
            case TEXT:
                return new Text(rect, name);
        }
        return null;
    }

    private Sprite getRandomFlippedBlock(String name, Rectangle rect) {
        Sprite sprite = createSprite(name, rect);
        sprite.flip(MathUtils.randomBoolean(), MathUtils.randomBoolean());
        return sprite;
    }

    private Sprite getRandomBita(Rectangle rect) {
        String name = BITA_NAMES[MathUtils.random(BITA_NAMES.length - 1)];
        return createSprite(name, rect);
    }

    private Sprite createSprite(String name, Rectangle rect) {
        Sprite sprite = atlas.createSprite(name);
        sprite.setPosition(rect.x, rect.y);
        return sprite;
    }

    private Rectangle createRectangle(MapProperties prop) {
        float x = getFloat(prop, PROP_X);
        float y = getFloat(prop, PROP_Y);
        float width = getFloat(prop, PROP_WIDTH);
        float height = getFloat(prop, PROP_HEIGHT);
        return new Rectangle(x, y, width, height);
    }

    private float getFloat(MapProperties prop, String key) {
        return prop.get(key, Float.class);
    }

    private String getString(MapProperties prop, String key) {
        return prop.get(key, String.class);
    }

}
