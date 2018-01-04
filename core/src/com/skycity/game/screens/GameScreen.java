package com.skycity.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.skycity.game.SkyCity;
import com.skycity.game.componets.Chat;
import com.skycity.game.componets.Hud;
import com.skycity.game.core.Assets;
import com.skycity.game.core.Config;
import com.skycity.game.core.InputState;

import static com.skycity.game.core.Config.Keys.CHAT;
import static com.skycity.game.core.Config.SCREEN_HEIGHT;
import static com.skycity.game.core.Config.SCREEN_WIDTH;


/**
 * 游戏主屏
 */
public class GameScreen extends BaseScreen {
    /**
     * 游戏的输入状态
     */
    public InputState state;

    private Hud hud;
    private Chat chat;

    private OrthographicCamera mapCamera;
    private OrthogonalTiledMapRenderer renderer;
    private Viewport gamePort;


    public GameScreen(SkyCity skyCity) {
        super(skyCity);
        state = InputState.GAME;
        hud = new Hud(skyCity.batch);
        chat = new Chat(skyCity.batch);

        mapCamera = new OrthographicCamera(SCREEN_WIDTH, SCREEN_HEIGHT);
        gamePort = new FitViewport(SCREEN_WIDTH, SCREEN_HEIGHT, mapCamera);

        renderer = new OrthogonalTiledMapRenderer(Assets.getInstance().getTiledMap(), skyCity.batch);

        mapCamera.position.set(SCREEN_WIDTH / 2, SCREEN_HEIGHT / 2, 0);
        renderer.setView(mapCamera);

    }

    /**
     * 更新屏幕摄像机
     *
     * @param delta
     */
    void update(float delta) {
        handleInput(delta);
        mapCamera.update();
    }

    // TODO 处理按键输入
    private void handleInput(float delta) {
        if (Gdx.input.isKeyJustPressed(CHAT)) {
            chat.toggleChat();
            if (chat.isVisible()) {
                state = InputState.CHAT;
                Gdx.input.setInputProcessor(chat.getInputProcessor());
            } else {
                state = InputState.GAME;
            }
        } else if (Gdx.input.isKeyPressed(Config.Keys.MOVE_RIGHT) && state == InputState.GAME) {
            mapCamera.position.x += delta * 20;
        } else if (Gdx.input.isKeyPressed(Config.Keys.MOVE_LEFT) && state == InputState.GAME) {
            mapCamera.position.x -= delta * 20;
        } else if (Gdx.input.isKeyPressed(Config.Keys.MOVE_UP) && state == InputState.GAME) {
            mapCamera.position.y += delta * 20;
        } else if (Gdx.input.isKeyPressed(Config.Keys.MOVE_DOWN) && state == InputState.GAME) {
            mapCamera.position.y -= delta * 20;
        }
    }


    @Override
    public void show() {

    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
        gamePort.setScreenSize(width, height);
    }

    @Override
    public void render(float delta) {
        update(delta);
        cleanScreen();
        skyCity.batch.setProjectionMatrix(mapCamera.combined);
        renderer.render();
        hud.render();
        chat.render();
    }


    @Override
    public void hide() {
        super.hide();
    }

    @Override
    public void dispose() {
        super.dispose();
    }
}
