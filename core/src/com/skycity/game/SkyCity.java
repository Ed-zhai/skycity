package com.skycity.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.skycity.game.core.Title;
import com.skycity.game.demo.DemoState;
import com.skycity.game.screens.StartState;

import java.util.ResourceBundle;

public class SkyCity extends Game {

	/**
	 * 设置版本号
	 */
	public static final com.skycity.game.core.Version version = new com.skycity.game.core.Version(0, 0.03);


	@Override
	public void create () {
        // 设置游戏标题
		Gdx.graphics.setTitle(Title.getRandomWindowTitle()+"-"+version.getVersion());
        ResourceBundle bundle = ResourceBundle.getBundle("config");
        if(bundle.getString("model").equals("test")){
            setScreen(new DemoState(this));
        }else {
            setScreen(new StartState(this));
        }
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
