package com.github.originalblackhole.common.util;

import java.util.Random;

public class StrUtils {

    /**
     *  生成指定范围随机数
     * @param max 最大值
     * @param min 最小值
     * @return
     */
    public static int createRandom(int max, int min){
        return new Random().nextInt(Math.abs(max-min))+min;
    }
}
