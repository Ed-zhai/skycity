package com.skycity.game.core;

import com.badlogic.gdx.Input;

/**
 * 配置文件类
 */
public class Config {
    /**
     * 游戏窗口宽
     */
    public static final int SCREEN_WIDTH = 830;
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
        public static final int CHAT = Input.Keys.ENTER;
        /**
         * 关闭各种游戏窗口
         */
        public static final int CLOSE_WIN = Input.Keys.ESCAPE;
        /**
         * 游戏角色左移动
         */
        public static final int MOVE_LEFT = Input.Keys.LEFT;
        public static final int MOVE_UP = Input.Keys.UP;
        public static final int MOVE_DOWN = Input.Keys.DOWN;
        /**
         * 游戏角色右移动
         */
        public static  final int MOVE_RIGHT = Input.Keys.RIGHT;
        /**
         * 游戏角色跳跃
         */
        public static final int JUMP = Input.Keys.SPACE;
    }

}
