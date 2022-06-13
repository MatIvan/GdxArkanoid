package ru.mativ.arkanoid;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;

import ru.mativ.arkanoid.entity.Entity;
import ru.mativ.arkanoid.entity.EntityFactory;

public class Loader {
    private static final String ATLAS = ".atlas";
    private static final String TMX = ".tmx";

    private EntityFactory factory;
    private TiledMap map;
    private TextureAtlas atlas;

    public Loader(String name) {
        super();
        map = new TmxMapLoader().load(name + TMX);
        atlas = new TextureAtlas(name + ATLAS);
        factory = new EntityFactory(atlas);
    }

    public List<Entity> createFromLayer(String name) {
        List<Entity> entityList = new ArrayList<>();
        MapLayer lay = map.getLayers().get(name);
        for (MapObject obj : lay.getObjects()) {
            Entity entity = factory.create(obj);
            if (entity != null) {
                entityList.add(entity);
            }
        }
        return entityList;
    }

    public void dispose() {
        map.dispose();
        atlas.dispose();
    }
}
