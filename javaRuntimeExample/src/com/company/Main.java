package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class Main {

    public static void main(String[] args) {
        try {
            Process p = Runtime.getRuntime().exec("javac sam2.java");
            Process p2 = Runtime.getRuntime().exec("java sam2");
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(p2.getInputStream()));

            OutputStream out = p.getOutputStream();
            String line = null;
            line = in.readLine();
            System.out.println(line);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
