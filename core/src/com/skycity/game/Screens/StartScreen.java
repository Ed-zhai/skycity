package com.skycity.game.Screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.skycity.game.core.Config;

public class StartScreen extends BaseScreen {
    private Texture logoTexture; //欢迎界面
    private SpriteBatch batch;

    public StartScreen(Game game){
        super(game);
    }

    @Override
    public void show() {
        logoTexture = new Texture(Gdx.files.internal("start.png"));
        batch = new SpriteBatch();
        batch.getProjectionMatrix().setToOrtho2D(0,0,Config.SCREEN_WIDTH,Config.SCREEN_HEIGHT);
    }

    private float deltaSum; // 当前界面展示的总时间
    private float alpha=0; //屏幕的透明度 0-1之间。0表示全部透明
    private final float REMAIN=5f; //屏幕停留时间
    @Override
    public void render(float delta) {
        cleanScreen();
        batch.begin();
        batch.setColor(1,1,1,alpha);
        batch.draw(logoTexture, Config.SCREEN_WIDTH/2-logoTexture.getWidth()/2,Config.SCREEN_HEIGHT/2-logoTexture.getHeight()/2);
        batch.end();

        deltaSum += delta;

        if (deltaSum > REMAIN){
            game.setScreen(new GameScreen(game));
        }else {
            alpha = gradientAlpha(deltaSum);
        }

    }

    /**
     * 根据时间值，返回屏幕的透明度
     * @param x
     * @return
     */
    private float gradientAlpha(float x){
        final int param=2;
        float y;
        if (x<param && x>=0){
            y = (float) (Math.sin(x*Math.PI/param+3*Math.PI/2)+1)/2;
        }else if (x>=param && x<(REMAIN-param)){
            y=1;
        }else {
            x=(REMAIN-x);
            y = (float) (Math.sin(x*Math.PI/param+3*Math.PI/2)+1)/2;
        }
        return y;
    }


    @Override
    public void hide() {
        Gdx.app.debug("skycity","dispose startscreen ");
        logoTexture.dispose();
        batch.dispose();
    }
}
