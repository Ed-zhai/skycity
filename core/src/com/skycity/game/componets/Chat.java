package com.skycity.game.componets;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.skycity.game.core.Assets;
import com.skycity.game.core.Config;

public class Chat{
    private Stage stage;
    private TextField field;
    private Table table;

    public Chat(SpriteBatch batch){
        field = new TextField("", Assets.getInstance().getSkin());
        field.setVisible(false);

        table = new Table();
        table.bottom().padLeft(20).padRight(20).padBottom(10).setFillParent(true);
        table.setDebug(false);
        table.add(field).width(Config.SCREEN_WIDTH-40);
        stage = new Stage(new FillViewport(Config.SCREEN_WIDTH,Config.SCREEN_HEIGHT,new OrthographicCamera()),batch);
        stage.addActor(table);
        stage.setKeyboardFocus(field);
    }

    public void render(){
        stage.act();
        stage.draw();
    }

    private void handleText(){
        // TODO 处理输入框中的文字
        System.out.println(field.getText());
        field.setText("");
    }

    /**
     * 当按回车键的时候,chat不可见时，变为可见，可见时，如果有内容输出内容，没内容让chat变为不可见
     */
    public void toggleChat(){
        if(field.isVisible()){
            if(field.getText().equals("")){
                field.setVisible(false);
                field.setDisabled(true);
            }else{
                handleText();
            }
        }else{
            field.setVisible(true);
            field.setDisabled(false);
        }
    }

    public boolean isVisible(){
        return field.isVisible();
    }

    public InputProcessor getInputProcessor(){
        return stage;
    }

}
