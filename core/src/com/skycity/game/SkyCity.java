package com.skycity.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.skycity.game.core.Title;
import com.skycity.game.screens.StartState;


public class SkyCity extends Game {

	/**
	 * 设置版本号
	 */
	private static final com.skycity.game.core.Version version = new com.skycity.game.core.Version(0, 0.03);


	public SpriteBatch batch;

	@Override
	public void create () {
        // 设置游戏标题
		Gdx.graphics.setTitle(Title.getRandomWindowTitle()+"-"+version.getVersion());

		batch = new SpriteBatch();

        setScreen(new StartState(this));

	}

    @Override
    public void render() {
        super.render();
    }

    @Override
    public void dispose() {
        super.dispose();
    }
}
