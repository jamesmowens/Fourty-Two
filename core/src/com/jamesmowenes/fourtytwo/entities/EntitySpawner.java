package com.jamesmowenes.fourtytwo.entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.jamesmowenes.fourtytwo.Constants;
import com.jamesmowenes.fourtytwo.Drawable;
import com.jamesmowenes.fourtytwo.scenes.SceneManager;
import java.util.LinkedList;
import java.util.Random;

public class EntitySpawner implements Drawable {
    LinkedList<CollideableEntity> entities;
    Player player;
    Random random;

    public EntitySpawner(Player player){
        entities = new LinkedList<CollideableEntity>();
        this.player = player;
        this.random = new Random();
    }

    private void spawn(int x) {
        int value = random.nextInt(Constants.ENTITY_CHANCE);
        if(value == 0){
            entities.add(new Rock(x));
        }
    }

    private boolean canSpawn(Rectangle viewPort) {
        if(entities.size() == 0) {
            return true;
        }
        return (viewPort.x + viewPort.width - entities.getLast().getBounds().x) > Constants.ENTITY_SPACING;
    }


    @Override
    public void update(float deltaTime) {
        LinkedList<CollideableEntity> newEntities = new LinkedList<CollideableEntity>();
        Rectangle viewPort = SceneManager.getInstance().getViewportBounds();
        for(CollideableEntity entity: entities) {
            if (player.getBounds().overlaps(entity.getBounds())) {
                entity.onPlayerCollide(player);
            }
            if (entity.getBounds().x + entity.getBounds().width >= viewPort.x) {
                newEntities.add(entity);
                entity.update(deltaTime);
            }
        }
        entities = newEntities;
        if(canSpawn(viewPort)){
            spawn((int)(viewPort.x + viewPort.getWidth()));
        }
    }

    @Override
    public void render(SpriteBatch batch) {
        for(Entity entity : entities){
            entity.render(batch);
        }
    }

    @Override
    public void dispose() {
        for(Entity entity: entities){
            entity.dispose();
        }

    }
}
