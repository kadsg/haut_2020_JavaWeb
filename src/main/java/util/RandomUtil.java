package util;

import java.util.Random;

/**
 * 随机数
 */
public class RandomUtil {
    /**
     * 获取6位随机数
     * @return
     */
    public static String getRandom() {
        int len = 6;
        Random random = new Random();
        String random_number = "";
        for (int i = 1; i <= 6; ++i) {
           random_number += String.valueOf(random.nextInt(9));
        }
        return random_number;
    }
}
