package com.skycity.game.core;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 游戏窗口标题。
 * 在不同日期里显示不同标语
 */
public class Title {

    /**
     * 在特殊的日子中显示 祝福标语
     *
     * @return
     */
    public static String getRandomWindowTitle() {

        Integer key = Integer.parseInt(new SimpleDateFormat("MMdd").format(new Date()));

        String value;
        switch (key) {
            case 719:
                value = "生日快乐!";
                break;
            case 1010:
                value = "Skycity，Happy Birthday!";
                break;
            case 1224:
                value = "圣诞节快乐!";
                break;
            case 0101:
                value = "元旦快乐!";
                break;
            default:
                //TODO 随机出现祝福语
                value = "你好啦";
        }

        return value;
    }

}
