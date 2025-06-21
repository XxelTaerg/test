package com.javarush.task.task16.task1630;

import java.io.*;

/* 
Последовательный вывод файлов
*/

public class Solution {
    public static String firstFileName;
    public static String secondFileName;

    //напишите тут ваш код
    static{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            firstFileName = bufferedReader.readLine();
            secondFileName = bufferedReader.readLine();
        } catch (Exception e) {

        }
    }

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

    //напишите тут ваш код
    public static class ReadFileThread implements Runnable, ReadFileInterface {
        FileInputStream fileInputStream ;
        @Override
        public void setFileName(String fullFileName) {
            try {
                fileInputStream = new FileInputStream(fullFileName);
            } catch (Exception e) {
                
            }

        }

        @Override
        public String getFileContent() {
            return "";
        }

        @Override
        public void join() throws InterruptedException {

        }

        @Override
        public void start() {

        }

        @Override
        public void run() {

        }
    }
}
