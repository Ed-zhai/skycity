package com.skycity.game.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;

import static com.skycity.game.core.Config.Keys.CHAT;
import static com.skycity.game.core.Config.Keys.JUMP;
import static com.skycity.game.core.Config.SCREEN_HEIGHT;
import static com.skycity.game.core.Config.SCREEN_WIDTH;


/**
 * 游戏主屏
 */
public class GameState extends BaseState {
    private SpriteBatch batch;
    private Stage stage;
    private TextField chat;
    private Label health;
    private Skin skin;


    GameState(Game game) {
        super(game);
        batch = new SpriteBatch();
        batch.getProjectionMatrix().setToOrtho2D(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);

        stage = new Stage();
        skin = new Skin(Gdx.files.internal("clean-crispy-ui.json"));
        chat = new TextField("", skin);
        chat.setSize(SCREEN_WIDTH - 40, 25);
        chat.setPosition(20, 20);
        chat.setVisible(false);
        chat.addListener(new ChatListener());

        health = new Label("health: 100/100",skin);
        health.setColor(Color.WHITE);
        health.setSize(40,40);
        health.setPosition(SCREEN_WIDTH-120,SCREEN_HEIGHT-60);

        stage.addActor(chat);
        stage.addActor(health);
        Gdx.input.setInputProcessor(stage);
        stage.addListener(new StageListener());

    }

    class ChatListener extends InputListener{
        @Override
        public boolean keyDown(InputEvent event, int keycode) {

            if(!chat.isVisible()){
                chat.setDisabled(true);
                return false;
            }

            switch (keycode) {
                case CHAT:
                    System.out.println("chat: enter");
                    break;
                default:
                    System.out.println("chat:default");
            }

            return super.keyDown(event, keycode);
        }
    }

    class StageListener extends InputListener {
        @Override
        public boolean keyDown(InputEvent event, int keycode) {
            switch (keycode) {
                case JUMP:
                    System.out.println("jump");
                    break;
                case CHAT:
                    toggleChat();
                    break;
                default:
                    System.out.println("default");

            }
            return super.keyDown(event, keycode);
        }



        private void toggleChat() {
            if(chat.isVisible()){
                String text = chat.getText();
                if(text.equals("")){
                    chat.setVisible(false);
                }else{
                    System.out.println(text);
                    chat.setText("");
                }
            }else{
                chat.setVisible(true);
                chat.setDisabled(false);
                stage.setKeyboardFocus(chat);
            }
        }
    }


    @Override
    public void show() {

    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        cleanScreen();

        batch.begin();
        stage.act();
        stage.draw();
        batch.end();
    }


    @Override
    public void hide() {
        super.hide();
        Gdx.app.debug("skycity", "game screen hide and dispose");
    }

    @Override
    public void dispose() {
        super.dispose();
        batch.dispose();
        stage.dispose();
        skin.dispose();
    }
}
