package com.skycity.game.core;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Title {

    /**
     * 在特殊的日子中显示 祝福标语
     * @return
     */
    public static String getRandomWindowTitle() {

        Integer key = Integer.parseInt(new SimpleDateFormat("MMdd").format(new Date()));
        String value = null;

        switch (key){
            case 719:
                value = "生日快乐!";
                break;
            case 1010:
                value = "Skycity，Happy Birthday!";
                break;
            default:
                //TODO 随机出现祝福语
                value = "你好啦";
        }

       return value;
    }

}
