package com.skycity.game.Screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.skycity.game.core.Assets;

import static com.skycity.game.core.Config.*;


/**
 * 游戏主屏
 */
public class GameScreen extends BaseScreen {
    private Texture texture;
    private SpriteBatch batch;
    private Label label;
    private Assets assets = Assets.getInstance();

    GameScreen(Game game) {
        super(game);
    }


    /**
     * 初始化label
     */
    private void initLabel() {
        //TODO 使用Rectangle类做ui的管理
        Label.LabelStyle style = new Label.LabelStyle();
        style.font = assets.getBitmapFont();
        style.fontColor = new Color(Color.YELLOW);
        label = new Label("hello", style);
        label.setPosition(500, 500);

    }

    @Override
    public void show() {
        texture = new Texture(Gdx.files.internal("badlogic.jpg"));

        initLabel();

        batch = new SpriteBatch();
        batch.getProjectionMatrix().setToOrtho2D(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        cleanScreen();
        if(Gdx.input.isKeyJustPressed(Keys.OPEN_CHAT)){
            label.setVisible(true);
            Gdx.app.log("skycity","open_chat");
        }
        if(Gdx.input.isKeyJustPressed(Keys.CLOSE_WIN)){
            label.setVisible(false);
            Gdx.app.log("skycity","close_chat");
        }

        batch.begin();
        batch.draw(texture, 0, 0);
        label.draw(batch, 1);
        batch.end();
    }

    @Override
    public void hide() {
        super.hide();
        Gdx.app.debug("skycity", "game screen hide and dispose");
        texture.dispose();
        batch.dispose();
    }

    @Override
    public void dispose() {
        super.dispose();
        texture.dispose();
        batch.dispose();
    }
}
