package com.jamesmowenes.fourtytwo;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.jamesmowenes.fourtytwo.scenes.GameScene;
import com.jamesmowenes.fourtytwo.scenes.SceneManager;
import com.jamesmowenes.fourtytwo.scenes.TitleScene;

public class Main extends ApplicationAdapter {
	SpriteBatch batch;

	@Override
	public void create () {
		batch = new SpriteBatch();
		Gdx.gl.glClearColor(1, 0, 0, 1);
        SceneManager.getInstance().push(new TitleScene());

	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        SceneManager manager = SceneManager.getInstance();
        manager.update(Gdx.graphics.getDeltaTime());
        manager.render(batch);
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
