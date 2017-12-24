package com.skycity.game.core;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreetypeFontLoader;

/**
 * 图片，音乐，字体资源管理列
 */
public class Assets {
    private static Assets instance;

    /**
     * 游戏统一格式字体
     */
    private BitmapFont f18, f22, f24;

    private Assets() {
        initFont();
    }

    /**
     * 加载资源
     */
    public static void loadAssets() {
        instance = new Assets();
    }

    public static Assets getInstance() {
        if (instance == null) {
            instance = new Assets();
        }
        return instance;
    }

    /**
     * 初始游戏字体
     */
    private void initFont() {
        FreetypeFontLoader.FreeTypeFontLoaderParameter fontConfig = new FreetypeFontLoader.FreeTypeFontLoaderParameter();
        fontConfig.fontFileName = "font.ttf";
        fontConfig.fontParameters.size = 22;

        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("font.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameters = new FreeTypeFontGenerator.FreeTypeFontParameter();

        parameters.size = 18;
        f18 = generator.generateFont(parameters);
        parameters.size = 22;
        f22 = generator.generateFont(parameters);
        parameters.size = 24;
        f24 = generator.generateFont(parameters);

        generator.dispose();
    }

    public BitmapFont getF18() {
        return f18;
    }

    public BitmapFont getF22() {
        return f22;
    }

    public BitmapFont getF24() {
        return f24;
    }
}
