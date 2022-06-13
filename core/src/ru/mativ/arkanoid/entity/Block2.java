package ru.mativ.arkanoid.entity;

import com.badlogic.gdx.graphics.g2d.Sprite;

public class Block2 extends Block {

    public Block2(Sprite sprite, String name) {
        super(EntityType.BLOCK2, name);
        this.setSprite(sprite);
    }

}
