package com.jamesmowenes.fourtytwo.ground;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.jamesmowenes.fourtytwo.entities.Entity;

public class BasicGroundTile extends Entity {
    private Rectangle bounds;
    private Texture texture;

    public BasicGroundTile(int x, int y){
        super(x, y);
        texture = new Texture("groundtile.png");
        bounds = new Rectangle(x, y, texture.getWidth(), texture.getHeight());
    }


    @Override
    public Rectangle getBounds() {
        return bounds;
    }

    @Override
    public void update(float deltaTime) {
        return;
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.draw(texture, getBounds().x, getBounds().y);
    }

    @Override
    public void dispose() {
        texture.dispose();
    }
}
