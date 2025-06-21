package com.javarush.task.task15.task1514;

import java.util.HashMap;
import java.util.Map;

/* 
Статики-1
*/

public class Solution {


    public static Map<Double, String> labels = new HashMap<Double, String>();
    static {
        labels.put(13.1, "sdf1");
        labels.put(13.244, "sdf2");
        labels.put(13.34, "sdf3");
        labels.put(13.434, "sdf4");
        labels.put(13.54, "sd25");
    }
    public static void main(String[] args) {
        System.out.println(labels);
    }
}
