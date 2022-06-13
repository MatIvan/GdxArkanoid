package ru.mativ.arkanoid.entity;

import com.badlogic.gdx.graphics.g2d.Sprite;

public class Block1 extends Block {

    public Block1(Sprite sprite, String name) {
        super(EntityType.BLOCK1, name);
        this.setSprite(sprite);
    }

}
