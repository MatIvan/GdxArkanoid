package ru.mativ.arkanoid.math;

import ru.mativ.arkanoid.entity.Ball;
import ru.mativ.arkanoid.entity.Entity;

public class Collision {
    private Ball ball;
    private Entity entity;

    private boolean top;
    private boolean bottom;
    private boolean left;
    private boolean right;

    public Collision(Ball ball, Entity entity) {
        this.ball = ball;
        this.entity = entity;
    }

    public Ball getBall() {
        return ball;
    }

    public void setBall(Ball ball) {
        this.ball = ball;
    }

    public Entity getEntity() {
        return entity;
    }

    public void setEntity(Entity entity) {
        this.entity = entity;
    }

    public boolean isTop() {
        return top;
    }

    public void setTop(boolean top) {
        this.top = top;
    }

    public boolean isBottom() {
        return bottom;
    }

    public void setBottom(boolean bottom) {
        this.bottom = bottom;
    }

    public boolean isLeft() {
        return left;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public boolean isRight() {
        return right;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "Collision [top=" + top + ", bottom=" + bottom + ", left=" + left + ", right=" + right + "]";
    }

}
