package com.skycity.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.skycity.game.core.Title;
import com.skycity.game.ui.chat.componets.UiChat;

public class SkyCity extends Game {

	/**
	 * 设置版本号
	 */
	public static final com.skycity.game.core.Version version = new com.skycity.game.core.Version(0, 0.01);

    /**
     * 设置全局只有一个batch
     */
	public SpriteBatch batch;
	public Texture img;
    public BitmapFont font;
	@Override
	public void create () {

        // 设置游戏标题
		Gdx.graphics.setTitle(Title.getRandomWindowTitle()+"-"+version.getVersion());

		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
        font = new  BitmapFont();

        setScreen(new UiChat(this));
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
//		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
//
		batch.draw(img,0,0);
//		// mouse /tocuch
//        // 获取 鼠标的 位置
//        int mouseX = Gdx.input.getX();
//        int mouseY = Gdx.input.getY();
//
//        boolean leftPressed = Gdx.input.isButtonPressed(Input.Buttons.LEFT);//鼠标左键
//        boolean rightPressed = Gdx.input.isButtonPressed(Input.Buttons.RIGHT);//鼠标右键
//
//
//        font.draw(batch, "Mouse/Touch: x=" + mouseX + "  y=" + mouseY, 20.0f,
//                 20.0f);
//        font.draw(batch, leftPressed ? "Mouse left button pressed"
//                : "Mouse left button not pressed", 20.0f, 50.0f);
//        font.draw(batch, rightPressed ? "Mouse right button pressed"
//                : "Mouse right button not pressed", 20.0f,  80.0f);
//
//
//        // 按回车键 调用对话框

        if(Gdx.input.isKeyJustPressed(Input.Keys.ENTER)){
            Gdx.app.log("input","enter pressed");
            setScreen(new UiChat(this));
            getScreen().show();
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)){
            Gdx.app.log("input","esc pressed");
            getScreen().hide();
        }
//
//		//batch.draw(img, 10, 20);
		batch.end();
	}




    @Override
    public void dispose() {
        super.dispose();
    }
}
