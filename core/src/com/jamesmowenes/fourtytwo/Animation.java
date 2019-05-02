package com.jamesmowenes.fourtytwo;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Array;

public class Animation {
    private Array<Texture> frames;
    private float totalFrameTime;
    private float currentFrameTime;
    private int numFrames;
    private int currentIndex;


    public Animation(String[] names, float cycleTime){
        frames = new Array<Texture>();
        numFrames = names.length;
        totalFrameTime = cycleTime / numFrames;
        currentIndex = 0;

        for(String file: names){
            Texture frame = new Texture(file);
            frames.add(frame);
        }

    }

    public void update(float dt) {
        currentFrameTime += dt;
        if(currentFrameTime > totalFrameTime){
            if(currentIndex == numFrames - 1){
                currentIndex = 0;
            } else {
                currentIndex += 1;
            }
            currentFrameTime = 0;
        }
    }


    public Texture getCurrentFrame() {
        return frames.get(currentIndex);
    }

    public void dispose(){
        for (Texture frame:frames){
            frame.dispose();
        }
    }
}
