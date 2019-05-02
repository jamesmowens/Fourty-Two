package com.jamesmowenes.fourtytwo.scenes;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.jamesmowenes.fourtytwo.Drawable;

public abstract class Scene implements Drawable {
    private OrthographicCamera camera;

    public Scene() {
        this.camera = new OrthographicCamera();
    }

    /**
     * Gets the camera for the scene
     * @return the camera
     */
    public OrthographicCamera getCamera() {
        return camera;
    }

    /**
     * Handle input from the player
     */
    public abstract void handleInput();
}
