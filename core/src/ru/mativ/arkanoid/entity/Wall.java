package ru.mativ.arkanoid.entity;

import com.badlogic.gdx.math.Rectangle;

public class Wall extends Entity {

    public Wall(Rectangle rect, String name) {
        super(EntityType.WALL, name);
        this.setRectangle(rect);
    }

}
