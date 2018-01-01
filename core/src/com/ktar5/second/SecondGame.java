package com.ktar5.second;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

public class SecondGame extends ApplicationAdapter {
    private SpriteBatch batch;
    private Texture img;
    private SecondManager manager;
    private BitmapFont font;
    private OrthographicCamera camera;
    private GlyphLayout layout;

    @Override
    public void create() {
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("HELR45W.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 100;
        font = generator.generateFont(parameter);

        batch = new SpriteBatch();
        manager = new SecondManager();

        layout = new GlyphLayout(font, "Begin!");

        camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        Gdx.input.setInputProcessor(new MouseListener(manager, camera));
    }


    @Override
    public void render() {
        batch.setProjectionMatrix(camera.combined);
        camera.update();
        Gdx.gl.glClearColor(manager.getScreenColor().r, manager.getScreenColor().g,
                manager.getScreenColor().b, manager.getScreenColor().a);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        layout.setText(font, String.valueOf(manager.getLatestDifference()));
        batch.begin();
        font.draw(batch, layout, camera.position.x - layout.width / 2, camera.position.y + layout.height / 2);
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        manager.dispose();
        font.dispose();
    }
}
