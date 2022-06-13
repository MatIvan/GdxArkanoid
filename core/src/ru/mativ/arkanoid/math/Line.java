package ru.mativ.arkanoid.math;

import com.badlogic.gdx.math.Vector2;

public class Line {
    private Vector2 start;
    private Vector2 end;

    public Line() {
        super();
    }

    public Line(Vector2 start, Vector2 end) {
        super();
        this.start = start;
        this.end = end;
    }

    public Vector2 getStart() {
        return start;
    }

    public void setStart(Vector2 start) {
        this.start = start;
    }

    public Vector2 getEnd() {
        return end;
    }

    public void setEnd(Vector2 end) {
        this.end = end;
    }

}
