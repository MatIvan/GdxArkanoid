package ru.mativ.arkanoid.entity;

import com.badlogic.gdx.graphics.g2d.Sprite;

public class Bita extends Entity {

    public Bita(Sprite sprite, String name) {
        super(EntityType.BITA, name);
        this.setSprite(sprite);
    }

}
