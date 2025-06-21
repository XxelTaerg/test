package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.ImageReader;
import com.javarush.task.task16.task1631.common.ImageTypes;

import static com.javarush.task.task16.task1631.ImageReaderFactory.getImageReader;

/* 
Factory method pattern
*/

public class Solution {
    public static void main(String[] args) {
        ImageReader reader = getImageReader(null);

            System.out.println("Поехали " + reader);


    }
}
