package ru.mativ.arkanoid.entity;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;

public abstract class Entity {
    protected String name;
    protected EntityType type;
    protected Sprite sprite;
    protected Rectangle rectangle;

    public Entity(EntityType type, String name) {
        super();
        this.type = type;
        this.name = name;
    }

    public EntityType getType() {
        return type;
    }

    public void setType(EntityType type) {
        this.type = type;
    }

    public Sprite getSprite() {
        return sprite;
    }

    public void setSprite(Sprite sprite) {
        this.sprite = sprite;
    }

    public Rectangle getRectangle() {
        if (type.hasSprite()) {
            return sprite.getBoundingRectangle();
        }
        return rectangle;
    }

    public void setRectangle(Rectangle rectangle) {
        this.rectangle = rectangle;
    }

    public String getName() {
        return name;
    }

    public void draw(SpriteBatch bath) {
        if (type.hasSprite()) {
            sprite.draw(bath);
        }
    }

    public void debugDraw(ShapeRenderer sr) {
        if (type.hasSprite()) {
            sr.rect(sprite.getX(), sprite.getY(), sprite.getWidth(), sprite.getHeight());
            return;
        }
        sr.rect(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
    }
}
