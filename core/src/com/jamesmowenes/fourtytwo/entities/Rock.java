package com.jamesmowenes.fourtytwo.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.jamesmowenes.fourtytwo.Constants;

public class Rock extends CollideableEntity {
    Texture texture;
    Rectangle bounds;


    public Rock(int x){
        super();
        texture = new Texture("rock.png");
        int y  = Constants.GROUND_Y + (texture.getHeight() * 2) - Constants.ENTITY_OVERLAP;
        getPosition().set(x, y);
        bounds = new Rectangle(x, y, texture.getWidth(), texture.getHeight());
    }

    @Override
    public void onPlayerCollide(Player player) {
        player.onHitObsticle();
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
