package com.bstu.epam.util;

/**
 * Created by Holger on 12.4.16.
 */
public class StringUtils {
    public static boolean entry(String main, String secondary) {
        String temp = main.substring(0, secondary.length());
        return temp.equals(secondary);
    }
}
