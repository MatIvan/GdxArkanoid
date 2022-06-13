package ru.mativ.arkanoid.entity;

import com.badlogic.gdx.math.Rectangle;

public class Text extends Entity {

    public Text(Rectangle rect, String name) {
        super(EntityType.TEXT, name);
        this.setRectangle(rect);
    }

}
