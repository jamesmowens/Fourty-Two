package com.jamesmowenes.fourtytwo;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public interface Drawable {
     /**
      * Update the view
      * @param deltaTime time since last frame
      */
     void update(float deltaTime);

     /**
      * Draw the view
      * @param batch the current open batch
      */
     void render(SpriteBatch batch);

     /**
      * Remove all resources
      */
     void dispose();
}
