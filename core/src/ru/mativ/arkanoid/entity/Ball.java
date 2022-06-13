package ru.mativ.arkanoid.entity;

import com.badlogic.gdx.graphics.g2d.Sprite;

public class Ball extends Entity {

    public Ball(Sprite sprite, String name) {
        super(EntityType.BALL, name);
        this.setSprite(sprite);
    }

}
