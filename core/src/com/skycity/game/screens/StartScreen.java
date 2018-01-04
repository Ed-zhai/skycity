package com.skycity.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.skycity.game.SkyCity;
import com.skycity.game.core.Config;


/**
 * 游戏开始画面
 */
public class StartScreen extends BaseScreen {
    private Texture logoTexture; //欢迎界面


    public StartScreen(SkyCity skyCity) {
        super(skyCity);
        logoTexture = new Texture(Gdx.files.internal("start.png"));
        skyCity.batch = new SpriteBatch();
        skyCity.batch.getProjectionMatrix().setToOrtho2D(0, 0, Config.SCREEN_WIDTH, Config.SCREEN_HEIGHT);
    }

    @Override
    public void show() {
        super.show();
    }

    private float deltaSum; // 当前界面展示的总时间
    private float alpha = 0; //屏幕的透明度 0-1之间。0表示全部透明
    private final float REMAIN = 5f; //屏幕停留时间

    @Override
    public void render(float delta) {
        cleanScreen();
        skyCity.batch.begin();
        skyCity.batch.setColor(1, 1, 1, alpha);
        skyCity.batch.draw(logoTexture, Config.SCREEN_WIDTH / 2 - logoTexture.getWidth() / 2, Config.SCREEN_HEIGHT / 2 - logoTexture.getHeight() / 2);
        skyCity.batch.end();

        deltaSum += delta;
        if (deltaSum > REMAIN) {
            skyCity.setScreen(new GameScreen(skyCity));
        } else {
            alpha = gradientAlpha(deltaSum);
        }

        if (Gdx.input.isKeyPressed(Input.Keys.ANY_KEY) && deltaSum >1) {
            skyCity.setScreen(new GameScreen(skyCity));
        }

    }

    /**
     * 根据时间值，返回屏幕的透明度
     *
     * @param x
     * @return
     */
    private float gradientAlpha(float x) {
        final int param = 2; //渐变时间
        float y;
        if (x < param && x >= 0) {
            y = (float) (Math.sin(x * Math.PI / param + 3 * Math.PI / 2) + 1) / 2;
        } else if (x >= param && x < (REMAIN - param)) {
            y = 1;
        } else {
            x = (REMAIN - x);
            y = (float) (Math.sin(x * Math.PI / param + 3 * Math.PI / 2) + 1) / 2;
        }
        return y;
    }


    @Override
    public void hide() {
        Gdx.app.debug("skycity", "dispose startscreen ");
        logoTexture.dispose();
    }
}
