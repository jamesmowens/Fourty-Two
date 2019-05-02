package com.jamesmowenes.fourtytwo.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.jamesmowenes.fourtytwo.Animation;
import com.jamesmowenes.fourtytwo.Constants;
import com.jamesmowenes.fourtytwo.scenes.SceneManager;

public class Player extends Entity {
    private static final String[] NAMES = {"run1.png", "run2.png", "run3.png", "run4.png", "run5.png", "run6.png", "run7.png", "run8.png"};
    private Vector2 velocity;
    private Rectangle bounds;
    private Animation animation;
    private final int BASE_Y;
    private boolean jumping;

    public Player(int x, int y){
        super(x,y);
        velocity = new Vector2(Constants.SPEED,0);
        animation = new Animation(NAMES, 1f);
        Texture firstFrame = animation.getCurrentFrame();
        bounds = new Rectangle(x, y, firstFrame.getWidth(), firstFrame.getHeight());
        BASE_Y = Constants.GROUND_Y + firstFrame.getHeight();
    }

    @Override
    public void update(float deltaTime){
        if(!jumping) {
            animation.update(deltaTime);
        }
        if(getPosition().y > BASE_Y) {
            velocity.add(0, Constants.GRAVITY);
        }
        velocity.scl(deltaTime);
        getPosition().add(velocity.x, velocity.y);
        if(getPosition().y < BASE_Y){
            getPosition().y = BASE_Y;
            jumping = false;
        }
        velocity.scl(1/deltaTime);
        bounds.setPosition(getPosition().x, getPosition().y);

    }

    @Override
    public Rectangle getBounds() {
        return bounds;
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.draw(animation.getCurrentFrame(), getPosition().x, getPosition().y);
    }

    @Override
    public void dispose() {
        animation.dispose();

    }

    public void jump() {
        if(!jumping) {
            velocity.y = 250;
            jumping = true;
        }
    }

    public void onHitObsticle(){
        SceneManager.getInstance().gameOver();
    }

}
