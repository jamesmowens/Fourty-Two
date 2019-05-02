package com.jamesmowenes.fourtytwo.entities;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.jamesmowenes.fourtytwo.Drawable;

public abstract class Entity implements Drawable {
    private Vector2 position;

    public Entity(){
        this(0,0 );
    }

    public Entity(int x, int y){

        position = new Vector2(x, y);
    }

    /**
     * Gets the entity's current position
     * @return
     */
    public Vector2 getPosition(){
        return position;
    }

    /**
     * Get the entity's bounds (hitbox)
     * @return the hitbox
     */
    public abstract Rectangle getBounds();
}
