package com.skycity.game.ui.chat.Screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class StartScreen extends BaseScreen {
    private Texture logoTexture; //欢迎界面
    private float deltaSum; // 当前界面展示的总时间
    private SpriteBatch batch;

    public StartScreen(Game game){
        super(game);
    }

    @Override
    public void show() {
        logoTexture = new Texture(Gdx.files.internal("city.jpeg"));
        batch = new SpriteBatch();
        batch.getProjectionMatrix().setToOrtho2D(0,0,600,600);
    }

    @Override
    public void render(float delta) {
        cleanScreen();
        batch.begin();
        batch.draw(logoTexture,0,0);
        batch.end();

        deltaSum += delta;
        if (deltaSum > 3){
            game.setScreen(new GameScreen(game));
        }

    }


    @Override
    public void hide() {
        Gdx.app.debug("skycity","dispose startscreen ");
        logoTexture.dispose();
        batch.dispose();
    }
}
