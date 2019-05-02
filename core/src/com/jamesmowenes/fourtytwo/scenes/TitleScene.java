package com.jamesmowenes.fourtytwo.scenes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.jamesmowenes.fourtytwo.Constants;

public class TitleScene extends Scene {
    Texture background;

    public TitleScene(){
        background = new Texture("title.png");
        getCamera().setToOrtho(false, Constants.WIDTH / 2, Constants.HEIGHT  /2);

    }


    @Override
    public void handleInput() {
        if(Gdx.input.justTouched()){
            System.out.println("Starting game");
            SceneManager.getInstance().set(new GameScene());
        }

    }

    @Override
    public void update(float deltaTime) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.setProjectionMatrix(getCamera().combined);
        batch.begin();
        batch.draw(background, getCamera().position.x - getCamera().viewportWidth / 2, 0);
        batch.end();
    }

    @Override
    public void dispose() {
        background.dispose();

    }
}
