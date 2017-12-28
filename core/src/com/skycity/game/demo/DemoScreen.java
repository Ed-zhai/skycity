package com.skycity.game.demo;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.skycity.game.SkyCity;
import com.skycity.game.core.Config;
import com.skycity.game.screens.BaseScreen;

public class DemoScreen extends BaseScreen {

    Rectangle rec;
    Texture back;
    SpriteBatch batch;
    boolean hide=true;

    public DemoScreen(SkyCity skyCity) {
        super(skyCity);
    }


    @Override
    public void show() {
        batch = new SpriteBatch();
        back = new Texture(Gdx.files.internal("ui/chat_backgroud.png"));
        System.out.println(back.getWidth());
        rec = new Rectangle(0,0, back.getWidth(),back.getHeight());
    }

    @Override
    public void render(float delta) {
        if(Gdx.input.isKeyJustPressed(Config.Keys.CHAT)){
            hide=false;
        }
        if(Gdx.input.isKeyJustPressed(Config.Keys.CLOSE_WIN)){
            hide=true;
        }

        cleanScreen();
        batch.begin();
        if(hide){

        }else {
            batch.draw(back,20,20);
        }
        batch.end();
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
        dispose();
    }

    @Override
    public void dispose() {
        batch.dispose();
        back.dispose();
    }
}
