package com.skycity.game.Screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreetypeFontLoader;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.skycity.game.core.Config;

public class GameScreen extends BaseScreen {
    private Texture texture;
    private SpriteBatch batch;
    private Label label;
    private BitmapFont bitmapFont;

    GameScreen(Game game) {
        super(game);
    }

    /**
     * 生成字体
     */
    private void initFont() {
        //TODO 需要把字体单独做成资源
        FreetypeFontLoader.FreeTypeFontLoaderParameter fontConfig = new FreetypeFontLoader.FreeTypeFontLoaderParameter();
        fontConfig.fontFileName = "font.ttf";
        fontConfig.fontParameters.size = 22;
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("font.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameters = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameters.size = 22;
        bitmapFont = generator.generateFont(parameters);
        generator.dispose();
    }

    /**
     * 初始化label
     */
    private void initLabel() {
        //TODO 使用Rectangle类做ui的管理
        Label.LabelStyle style = new Label.LabelStyle();
        style.font = bitmapFont;
        style.fontColor = new Color(Color.YELLOW);
        label = new Label("hello", style);
        label.setPosition(500, 500);

    }

    @Override
    public void show() {
        texture = new Texture(Gdx.files.internal("badlogic.jpg"));

        initFont();
        initLabel();

        batch = new SpriteBatch();
        batch.getProjectionMatrix().setToOrtho2D(0, 0, Config.SCREEN_WIDTH, Config.SCREEN_HEIGHT);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        cleanScreen();
        if(Gdx.input.isKeyJustPressed(Config.Keys.OPEN_CHAT)){
            label.setVisible(true);
            Gdx.app.log("skycity","open_chat");
        }
        if(Gdx.input.isKeyJustPressed(Config.Keys.CLOSE_CHAT)){
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
