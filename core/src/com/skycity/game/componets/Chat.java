package com.skycity.game.componets;

import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.skycity.game.core.Assets;
import com.skycity.game.core.Config;


public class Chat extends InputAdapter{
    private Stage stage;
    private TextField field;
    private Table table;


    public Chat(SpriteBatch batch){
        field = new TextField("", Assets.getInstance().getSkin());

        table = new Table();
        table.bottom().padLeft(20).padRight(20).padBottom(10).setFillParent(true);
        table.setDebug(false);
        table.add(field).width(Config.SCREEN_WIDTH-40);
        stage = new Stage(new FillViewport(Config.SCREEN_WIDTH,Config.SCREEN_HEIGHT,new OrthographicCamera()),batch);
        stage.addActor(table);
    }

    public void render(){
        stage.act();
        stage.draw();
    }

    @Override
    public boolean keyDown(int keycode) {

        return super.keyDown(keycode);
    }
}
