package io.github.mateiaru.android.madrun;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.*;
import java.util.Random;
import com.badlogic.gdx.graphics.glutils.*;

public class MainGDX implements ApplicationListener {
	
	SpriteBatch batch;
	BitmapFont font;
	BitmapFont title;
	BitmapFont button;
	ShapeRenderer lr;
	ShapeRenderer fr;
	Random r;
	boolean hasLoaded = false;

	@Override
	public void create() {
		// Initialize stuff
		r = new Random();
		batch = new SpriteBatch();
		// Font for loading text
		font = new BitmapFont();
		font.scale(2f);
		font.setColor(new Color(r.nextFloat(), r.nextFloat(), r.nextFloat(), 1.0f).clamp());
		font.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
		// Font for title
		title = new BitmapFont();
		title.scale(3f);
		title.setColor(new Color(1f, 1f, 0f, 1f));
		title.getRegion().getTexture().setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);
		// Font for buttons
		button = new BitmapFont();
		button.scale(2f);
		button.setColor(new Color(0.8f, 0.2f, 0.7f, 1.0f));
		button.getRegion().getTexture().setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);
		// The shape renderers for the buttons
		lr = new ShapeRenderer();
		lr.setColor(0.15f, 0.95f, 0.15f, 1.00f);
		fr = new ShapeRenderer();
		fr.setColor(0f, 0f, 1f, 1f);
		t.start();
		// Load the starting logo
		MadRunFiles.LOGO = new Texture(Gdx.files.internal("logo.png"));
	}

	@Override
	public void render() {
		if (!hasLoaded) {
		    Gdx.gl.glClearColor(1f, 1f, 1f, 1f);
		    Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
			batch.begin();
			font.draw(batch, "Loading...", 10, 50);
			batch.draw(MadRunFiles.LOGO, Gdx.graphics.getWidth() / 4, Gdx.graphics.getHeight() - (Gdx.graphics.getWidth() / 2), 
					   Gdx.graphics.getWidth() / 2, Gdx.graphics.getWidth() / 2);
			batch.end();
		} else {
			Gdx.gl.glClearColor(1.0f, 0.2f, 0.2f, 1.0f);
			Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
			////////////////////////////
			
			lr.begin(ShapeRenderer.ShapeType.Line);
			// First button
			for (int i = 0; i < 10; i++) {
				lr.rect(15 + i, Gdx.graphics.getHeight() - (200 - i), Gdx.graphics.getWidth() - (30 + 2*i), 80 - 2*i);
			}
			// Second button
			for (int i = 0; i < 10; i++) {
				lr.rect(15 + i, Gdx.graphics.getHeight() - (300 - i), Gdx.graphics.getWidth() - (30 + 2*i), 80 - 2*i);
			}
			// Third button
			for (int i = 0; i < 10; i++) {
				lr.rect(15 + i, Gdx.graphics.getHeight() - (400 - i), Gdx.graphics.getWidth() - (30 + 2*i), 80 - 2*i);
			}
			lr.end();
			fr.begin(ShapeRenderer.ShapeType.Filled);
			fr.rect(25, Gdx.graphics.getHeight() - 191, Gdx.graphics.getWidth() - 49, 61); // First button
			fr.rect(25, Gdx.graphics.getHeight() - 291, Gdx.graphics.getWidth() - 49, 61); // Second button
			fr.rect(25, Gdx.graphics.getHeight() - 391, Gdx.graphics.getWidth() - 49, 61);
			fr.end();
			
			////////////////////////////
			batch.begin();
			title.draw(batch, "Mad Run", 20, Gdx.graphics.getHeight() - 20);
			// Text for the buttons
			// First button
			BitmapFont.TextBounds playB = button.getBounds("Play!");
			int playW = (int) (Gdx.graphics.getWidth() / 2 - (playB.width / 2));
			button.draw(batch, "Play!", playW, Gdx.graphics.getHeight() - 140);
			// Second button
			BitmapFont.TextBounds optsB = button.getBounds("Settings");
			int optsW = (int) (Gdx.graphics.getWidth() / 2 - (optsB.width / 2));
			button.draw(batch, "Settings", optsW, Gdx.graphics.getHeight() - 240);
			// Third button
			BitmapFont.TextBounds exitB = button.getBounds("Exit App");
			int exitW = (int) (Gdx.graphics.getWidth() / 2 - (exitB.width / 2));
			button.draw(batch, "Exit App", exitW, Gdx.graphics.getHeight() - 340);
			batch.end();
		}
	}

	@Override
	public void dispose() {
		batch.dispose();
	}

	@Override
	public void resize(int width, int height) {
		
	}

	@Override
	public void pause() {
		
	}

	@Override
	public void resume() {
		
	}
	
	// Thread to load files
	Thread t = new Thread() {
		public void run() {
			// TODO: Load the files
			
			try {
				sleep(2000);
			} catch (InterruptedException e) {e.printStackTrace();}
			hasLoaded = true;
		}
	};
	
	static class MadRunFiles {
		public static Texture LOGO;
	}
	
}
