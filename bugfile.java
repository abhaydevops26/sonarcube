package com.example;

import java.util.*;
import java.io.*;

public class BadCodeExample {

    // Hardcoded credentials (SECURITY ISSUE)
    private static final String PASSWORD = "admin123";

    public static void main(String[] args) {

        // Null pointer risk
        String data = null;
        System.out.println(data.length());  // BUG

        // Infinite loop (LOGIC ISSUE)
        while (true) {
            break;
        }

        // Duplicate code
        int a = 10;
        int b = 20;
        if (a == b) {
            System.out.println("Equal");
        }

        int c = 10;
        int d = 20;
        if (c == d) {
            System.out.println("Equal");
        }

        // Resource leak (not closing stream)
        try {
            FileInputStream fis = new FileInputStream("test.txt");
            byte[] buffer = new byte[1024];
            fis.read(buffer);
        } catch (Exception e) {
            e.printStackTrace(); // Bad practice
        }

        // SQL Injection vulnerability
        String userInput = "admin";
        String query = "SELECT * FROM users WHERE name = '" + userInput + "'";
        System.out.println(query);

        // Empty catch block
        try {
            int x = 10 / 0;
        } catch (Exception e) {
        }

        // Magic numbers
        int result = calculate(5, 10);

        // Unused variable
        int unused = 100;

        // Poor naming convention
        int X = 5;

        // Deep nesting (code smell)
        if (true) {
            if (true) {
                if (true) {
                    if (true) {
                        System.out.println("Too deep");
                    }
                }
            }
        }

        // System.out instead of logger
        System.out.println("Debug log");

        // String concatenation in loop (performance issue)
        String s = "";
        for (int i = 0; i < 100; i++) {
            s += i;
        }

        // Equals check wrong way
        String str = "test";
        if (str.equals(null)) {
            System.out.println("Null");
        }
    }

    // No access modifier (default)
    static int calculate(int a, int b) {
        return a + b;
    }
}
