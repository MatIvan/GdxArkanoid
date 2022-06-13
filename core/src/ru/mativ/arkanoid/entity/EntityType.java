package ru.mativ.arkanoid.entity;

public enum EntityType {
    BALL("ball", true),
    BITA("bita", true),
    TEXT("text", false),
    WALL("wall", false),
    BLOCK1("block-1", true),
    BLOCK2("block-2", true);

    private String name;
    private boolean hasSprite;

    EntityType(String name, boolean isSensor) {
        this.name = name;
        this.hasSprite = isSensor;
    }

    public String getName() {
        return name;
    }

    public boolean hasSprite() {
        return hasSprite;
    }

    public static EntityType get(String name) {
        for (EntityType type : EntityType.values()) {
            if (type.getName().equals(name)) {
                return type;
            }
        }
        return null;
    }
}
