package com.skycity.game.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;

import static com.skycity.game.core.Config.*;


/**
 * 游戏主屏
 */
public class GameScreen extends BaseScreen {
    private SpriteBatch batch;
    private TextField textField;
    Stage stage;


    GameScreen(Game game) {
        super(game);
    }



    @Override
    public void show() {
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);
        textField = new TextField("",new Skin(Gdx.files.internal("clean-crispy-ui.json")));
        textField.setPosition(300,300);
        textField.setSize(textField.getPrefWidth(),textField.getPrefHeight());
        stage.addActor(textField);

        batch = new SpriteBatch();
        batch.getProjectionMatrix().setToOrtho2D(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);

    }

    @Override
    public void render(float delta) {
        super.render(delta);
        cleanScreen();

        if(Gdx.input.isKeyJustPressed(Keys.OPEN_CHAT)){
            System.out.printf("isVisible:" + textField.isVisible());
            Gdx.app.log("skycity" +
                    "","open_chat");
        }
        if(Gdx.input.isKeyJustPressed(Keys.CLOSE_WIN)){
            textField.setVisible(false);
            Gdx.app.log("skycity","close_chat");
        }

        batch.begin();
        stage.act();
        stage.draw();
        batch.end();
    }

    @Override
    public void hide() {
        super.hide();
        Gdx.app.debug("skycity", "game screen hide and dispose");
        batch.dispose();
    }

    @Override
    public void dispose() {
        super.dispose();
        batch.dispose();
    }
}
