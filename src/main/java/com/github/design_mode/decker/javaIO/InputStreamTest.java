package com.github.design_mode.decker.javaIO;

import java.io.*;

public class InputStreamTest {

    public static void main(String[] args) {
        int c;
        try {
            InputStream in = new LowerCaseInputStream(
                    new BufferedInputStream(
                            new FileInputStream("E:\\test.txt")));
            while ((c = in.read()) >= 0){
                System.out.println((char)c);
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
