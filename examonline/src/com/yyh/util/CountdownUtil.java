package com.yyh.util;


/**
 * @Description: com.yyh.util
 * @version: 1.0
 */
public class CountdownUtil {
    public static boolean countdown(int time) throws InterruptedException{
        for (int j = 1; j <=time; j++) {

            for (int i = 0; i <= 59; i++) {
                new Thread().sleep(1000);
                int sec = 59 - i;
                if (sec < 10) {

                    System.out.println((time - j) + ":" + ("0" + sec));
                }
                else
                    System.out.println((time - j) + ":" + (sec));
            }
        }
        return false;
    }

    public static void main(String[] args) {
        try {
            countdown(120);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
