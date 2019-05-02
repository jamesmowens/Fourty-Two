package com.jamesmowenes.fourtytwo.scenes;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.jamesmowenes.fourtytwo.Drawable;

import java.util.ArrayList;

public class SceneManager implements Drawable {
    private static final SceneManager ourInstance = new SceneManager();

    public static SceneManager getInstance() {
        return ourInstance;
    }

    ArrayList<Scene> sceneStack;

    private SceneManager() {
        this.sceneStack = new ArrayList<Scene>();
    }

    public Rectangle getViewportBounds(){
        OrthographicCamera currentCamera = this.peak().getCamera();
        float leftSide = currentCamera.position.x - (currentCamera.viewportWidth / 2);

        return new Rectangle(leftSide, currentCamera.viewportHeight, currentCamera.viewportWidth, currentCamera.viewportHeight);
    }

    /**
     * Push a scene onto the stack
     * @param scene the scene to push
     */
    public void push(Scene scene) {
        sceneStack.add(scene);
    }

    /**
     * Disposes the top scene
     */
    public void pop(){
        if(sceneStack.size() == 0){
            return;
        }
        this.peak().dispose();
    }

    /**
     * Replaces the top scene with a given scene
     * @param scene Scene the new scene
     */
    public void set(Scene scene){
        this.pop();
        this.push(scene);
    }

    /**
     * Gets the top (current) scene
     * @return
     */
    public Scene peak() {
        if(sceneStack.size() == 0){
            return null;
        }
        return sceneStack.get(sceneStack.size() -1);
    }

    @Override
    public void update(float deltaTime) {
        this.peak().update(deltaTime);
    }

    @Override
    public void render(SpriteBatch batch){
        this.peak().render(batch);
    }

    @Override
    public void dispose(){
        for (Scene scene : sceneStack){
            scene.dispose();
        }
    }

    /**
     * Go back to the title screen
     */
    public void gameOver() {
        this.set(new TitleScene());
    }

}
