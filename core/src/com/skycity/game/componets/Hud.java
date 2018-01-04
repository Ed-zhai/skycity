package com.skycity.game.componets;


import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.skycity.game.core.Assets;
import com.skycity.game.core.Config;

/**
 * 显示血条，解饿值
 */
public class Hud {

    private Stage stage;
    private Label labelHP;
    private Label labelVP;
    private Viewport viewport;
    private Table table;

    public Hud(SpriteBatch batch){
        viewport = new FillViewport(Config.SCREEN_WIDTH,Config.SCREEN_HEIGHT,new OrthographicCamera());
        stage = new Stage(viewport,batch);
        labelHP = new Label("HP: 100/100", Assets.getInstance().getSkin());
        labelVP = new Label("VP: 100/100",Assets.getInstance().getSkin());

        table = new Table();
        table.setFillParent(true);
        table.top().right().padTop(20).padRight(20).setDebug(false);
        table.add(labelHP);
        table.row();
        table.add(labelVP);
        stage.addActor(table);
    }

    public void render(){
        stage.act();
        stage.draw();
    }

}
