package com.skycity.game.ui.chat.Screen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import javafx.stage.Stage;

public class StartScreen implements Screen{
    private Game game;
    private Texture logoTexture; //欢迎界面
    private float deltaSum; // 当前界面展示的总时间


    public StartScreen(Game game){
        this.game = game;
        logoTexture = new Texture(Gdx.files.internal("city.jpeg"));
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

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

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
