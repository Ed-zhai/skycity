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
    private BitmapFont bitmapFont;

    private Assets(){
        initFont();
    }

    /**
     * 加载资源
     */
    public static void loadAssets(){
        instance = new Assets();
    }

    public static Assets getInstance(){
        if(instance==null){
            instance = new Assets();
        }
        return instance;
    }

    /**
     * 初始游戏字体
     */
    private void initFont(){
        FreetypeFontLoader.FreeTypeFontLoaderParameter fontConfig = new FreetypeFontLoader.FreeTypeFontLoaderParameter();
        fontConfig.fontFileName = "font.ttf";
        fontConfig.fontParameters.size = 22;
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("font.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameters = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameters.size = 22;
        bitmapFont = generator.generateFont(parameters);
        generator.dispose();
    }

    public BitmapFont getBitmapFont() {
        return bitmapFont;
    }
}
