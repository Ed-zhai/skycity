package com.skycity.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.skycity.game.SkyCity;
import com.skycity.game.core.Assets;

import static com.skycity.game.core.Config.Keys.*;
import static com.skycity.game.core.Config.SCREEN_HEIGHT;
import static com.skycity.game.core.Config.SCREEN_WIDTH;


/**
 * 游戏主屏
 */
public class GameState extends BaseState {
    private Stage stage;
    private TextField chat;
    private Label HPLabel;
    private Label VPLabel;

    private OrthographicCamera mapCamera;
    private OrthogonalTiledMapRenderer renderer;
    private Viewport gamePort;



    public GameState(SkyCity skyCity) {
        super(skyCity);

        gamePort =new FitViewport(SCREEN_WIDTH,SCREEN_HEIGHT);

        stage = new Stage(gamePort,skyCity.batch);
        stage.addListener(new StageListener());
        Gdx.input.setInputProcessor(stage);

        // chat
        chat = new TextField("", Assets.getInstance().getSkin());
        chat.setSize(SCREEN_WIDTH - 40, 25);
        chat.setPosition(20, 20);
        chat.setVisible(false);
        chat.addListener(new ChatListener());
        stage.addActor(chat);

        // HP
        HPLabel = new Label("HP: 100/100",  Assets.getInstance().getSkin());
        HPLabel.setColor(Color.WHITE);
        HPLabel.setSize(40, 40);
        HPLabel.setPosition(SCREEN_WIDTH - 120, SCREEN_HEIGHT - 60);
        stage.addActor(HPLabel);

        // VP
        VPLabel = new Label("VP: 100/100",  Assets.getInstance().getSkin());
        VPLabel.setColor(Color.WHITE);
        VPLabel.setSize(40, 40);
        VPLabel.setPosition(SCREEN_WIDTH - 120, SCREEN_HEIGHT - 90);
        stage.addActor(VPLabel);

        mapCamera = new OrthographicCamera(SCREEN_WIDTH,SCREEN_HEIGHT);
        renderer = new OrthogonalTiledMapRenderer(Assets.getInstance().getTiledMap(),skyCity.batch);
        renderer.setView(mapCamera);


    }

    class ChatListener extends InputListener {
        @Override
        public boolean keyDown(InputEvent event, int keycode) {

            if (!chat.isVisible()) {
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
                case MOVE_LEFT:
                    mapCamera.position.x--;
                    mapCamera.update();
                    break;
                case MOVE_RIGHT:
                    mapCamera.position.x++;
                    mapCamera.update();
                    break;
                case MOVE_UP:
                    mapCamera.position.y++;
                    mapCamera.update();
                    break;
                case MOVE_DOWN:
                    mapCamera.position.y--;
                    mapCamera.update();
                    break;
                default:
                    System.out.println("default");

            }
            return super.keyDown(event, keycode);
        }


        private void toggleChat() {
            if (chat.isVisible()) {
                String text = chat.getText();
                if (text.equals("")) {
                    chat.setVisible(false);
                } else {
                    System.out.println(text);
                    chat.setText("");
                }
            } else {
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
        skyCity.batch.setProjectionMatrix(mapCamera.combined);
        mapCamera.update();
        renderer.render();
        stage.act();
        stage.draw();
    }


    @Override
    public void hide() {
        super.hide();
        Gdx.app.debug("skycity", "game screen hide and dispose");
    }

    @Override
    public void dispose() {
        super.dispose();
        Assets.getInstance().dispose();
    }
}
