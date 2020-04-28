package com.ballot.rigging.util;

import java.io.UnsupportedEncodingException;
import java.util.Random;

/**
 * @Auther: wkd
 * @Date: 2020/4/23 14:14
 * @Description:
 */
public class RandomZHUtils {
    /**
     *
     * @return 随机汉字
     */
    private static String getRandomChar() {
        String str = null;
        int hightPos;
        int lowPos;

        Random random = new Random();

        hightPos = (176 + Math.abs(random.nextInt(39)));
        lowPos = (161 + Math.abs(random.nextInt(93)));

        byte[] b = new byte[2];
        b[0] = (Integer.valueOf(hightPos)).byteValue();
        b[1] = (Integer.valueOf(lowPos)).byteValue();

        try {
            str = new String(b, "GB2312");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return str;
    }

    /**
     *
     * @param number
     * @return number个随机汉字
     */
    public static String characterNumber(int number) {

        String words = "";
        for (int i = 0; i < number; i++) {
            words = words + getRandomChar();
        }
        return words;
    }
}
