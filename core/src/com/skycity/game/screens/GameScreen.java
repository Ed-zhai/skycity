package com.skycity.game.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import static com.skycity.game.core.Config.*;


/**
 * 游戏主屏
 */
public class GameScreen extends BaseScreen {
    private SpriteBatch batch;
    private Stage stage;
    private TextField chat;
    private Skin skin;
    private Viewport viewport;
    private Camera camera;


    GameScreen(Game game) {
        super(game);
        batch = new SpriteBatch();
        batch.getProjectionMatrix().setToOrtho2D(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
        camera = new OrthographicCamera();

        // TODO 改成画面不随窗口大小改变
        viewport = new ScreenViewport();
        stage = new Stage(viewport, batch);

        skin = new Skin(Gdx.files.internal("clean-crispy-ui.json"));
        chat = new TextField("", skin);
        chat.setSize(SCREEN_WIDTH - 40, 22);
        chat.setPosition(20, 20);
        chat.setVisible(false);

        stage = new Stage();
        stage.addActor(chat);
        Gdx.input.setInputProcessor(stage);

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

        // TODO 当chat界面不可见后 还会监听按键。 有内存分配错误的bug
        if (Gdx.input.isKeyJustPressed(Keys.CHAT)) {
            if (chat.isVisible()) {
                if (chat.getText().equals("")) {
                    chat.setVisible(false);
                }else{
                    System.out.println(chat.getText());
                    chat.setText("");
                }
            }else {
                chat.setVisible(true);
            }
        }
        if (Gdx.input.isKeyJustPressed(Keys.CLOSE_WIN)) {
            chat.setVisible(false);
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
    }

    @Override
    public void dispose() {
        super.dispose();
        batch.dispose();
        stage.dispose();
        skin.dispose();
    }
}
