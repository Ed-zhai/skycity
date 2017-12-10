package com.skycity.game.ui.chat.Screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.skycity.game.core.Config;

public class GameScreen extends BaseScreen{
    private Texture texture;
    private SpriteBatch batch;

    GameScreen(Game game) {
        super(game);
    }

    @Override
    public void show() {
        texture = new Texture(Gdx.files.internal("badlogic.jpg"));
        batch = new SpriteBatch();
        batch.getProjectionMatrix().setToOrtho2D(0,0, Config.SCREEN_WIDTH,Config.SCREEN_HEIGHT);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        cleanScreen();
        batch.begin();
        batch.draw(texture,0,0);
        batch.end();
    }

    @Override
    public void hide() {
        super.hide();
        texture.dispose();
        batch.dispose();
    }
}
