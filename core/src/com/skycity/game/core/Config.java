package com.skycity.game.core;

import com.badlogic.gdx.Input;

/**
 * 配置文件类
 */
public class Config {
    /**
     * 游戏窗口宽
     */
    public static final int SCREEN_WIDTH = 600;
    /**
     * 游戏窗口高
     */
    public static final int SCREEN_HEIGHT = 600;

    /**
     * 按键管理
     */
    public static class Keys {
        /**
         * 打开对话框架
         */
        public static int OPEN_CHAT = Input.Keys.ENTER;
        /**
         * 关闭各种游戏窗口
         */
        public static int CLOSE_WIN = Input.Keys.ESCAPE;
        /**
         * 游戏角色左移动
         */
        public static int MOVE_LEFT = Input.Keys.LEFT;
        /**
         * 游戏角色右移动
         */
        public static int MOVE_RIGHT = Input.Keys.RIGHT;
        /**
         * 游戏角色跳跃
         */
        public static int JUMP = Input.Keys.SPACE;
    }

}
