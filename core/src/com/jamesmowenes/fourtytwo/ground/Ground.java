package com.jamesmowenes.fourtytwo.ground;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.jamesmowenes.fourtytwo.Constants;
import com.jamesmowenes.fourtytwo.Drawable;
import com.jamesmowenes.fourtytwo.entities.Entity;
import com.jamesmowenes.fourtytwo.scenes.SceneManager;

import java.util.LinkedList;


public class Ground implements Drawable {
    LinkedList<Entity> tiles;

    public Ground(float width) {
        tiles = new LinkedList<Entity>();
       int currentPoint = (int) (-3 * width);
       while(currentPoint < width * 2){
           Entity tile = new BasicGroundTile(currentPoint, Constants.GROUND_Y);
           tiles.add(tile);
           currentPoint = currentPoint + (int) tile.getBounds().width;

       }
    }

    /**
     * Removes tiles that have gone off the left side of the screen
     */
    public void filterTiles(){
        Rectangle viewport= SceneManager.getInstance().getViewportBounds();
        LinkedList<Entity> filtered = new LinkedList<Entity>();
        for(Entity tile : tiles){
            if(tile.getBounds().x + tile.getBounds().width < viewport.x){
                tile.dispose();
            } else {
                filtered.add(tile);
            }
        }
        tiles = filtered;
    }

    /**
     * Add more tiles before the viewport gets to the end of the set of tiles
     */
    public void addTiles(){
        Entity lastTile = tiles.getLast();
        Rectangle viewPort = SceneManager.getInstance().getViewportBounds();
        if(lastTile.getBounds().x < viewPort.getX() + viewPort.getWidth()){
            tiles.add(new BasicGroundTile( (int) (lastTile.getBounds().x + lastTile.getBounds().width), Constants.GROUND_Y));
        }
    }

    @Override
    public void update(float deltaTime) {
        filterTiles();
        addTiles();

    }

    @Override
    public void render(SpriteBatch batch) {
        for(Entity tile : tiles){
            tile.render(batch);
        }
    }

    @Override
    public void dispose() {
        for(Entity tile : tiles){
            tile.dispose();
        }
    }
}
