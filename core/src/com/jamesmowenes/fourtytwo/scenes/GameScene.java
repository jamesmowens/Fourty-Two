package com.jamesmowenes.fourtytwo.scenes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.jamesmowenes.fourtytwo.Constants;
import com.jamesmowenes.fourtytwo.entities.EntitySpawner;
import com.jamesmowenes.fourtytwo.entities.Player;
import com.jamesmowenes.fourtytwo.ground.Ground;

public class GameScene extends Scene {
    private  static final String BACKGROUND_FILE = "background.png";
    private Player player;
    private Texture background;
    private Ground ground;
    private EntitySpawner spawner;


    public GameScene(){
        super();
        player = new Player(0, 50);
        background = new Texture(BACKGROUND_FILE);
        getCamera().setToOrtho(false, Constants.WIDTH / 2, Constants.HEIGHT  /2);
        ground = new Ground(getCamera().viewportWidth);
        spawner = new EntitySpawner(player);
    }

    @Override
    public void handleInput() {
        if(Gdx.input.justTouched()){
            player.jump();
        }

    }

    @Override
    public void update(float deltaTime) {
        handleInput();
        getCamera().position.x = player.getPosition().x + Constants.CAM_OFFSET;
        getCamera().update();
        player.update(deltaTime);
        ground.update(deltaTime);
        spawner.update(deltaTime);

    }

    @Override
    public void render(SpriteBatch batch) {
        batch.setProjectionMatrix(getCamera().combined);
        batch.begin();
        batch.draw(background, getCamera().position.x - getCamera().viewportWidth / 2, 0);
        player.render(batch);
        spawner.render(batch);
        ground.render(batch);
        batch.end();
    }

    @Override
    public void dispose() {
        player.dispose();
    }
}
