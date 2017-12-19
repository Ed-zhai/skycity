package com.skycity.game.core;

import com.badlogic.gdx.Input;

/**
 * 配置文件类
 */
public class Config {
    /**
     * 窗口宽
     */
    public static final int SCREEN_WIDTH = 600;
    /**
     * 窗口高
     */
    public static final int SCREEN_HEIGHT = 600;

    public static class Keys {
        public static int OPEN_CHAT = Input.Keys.ENTER;
        public static int CLOSE_CHAT = Input.Keys.ESCAPE;
        public static int MOVE_LEFT = Input.Keys.LEFT;
        public static int MOVE_RIGHT = Input.Keys.RIGHT;

    }

}
