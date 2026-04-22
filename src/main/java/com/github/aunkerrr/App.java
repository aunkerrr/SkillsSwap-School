package com.github.aunkerrr;

import Service.StudentService;
import Service.StudentServiceImpl;
import Storage.SkillSwapState;
import Storage.SkillSwapStateImpl;

import java.util.Scanner;

public class App {
    public static void main( String[] args ) {
        SkillSwapState state = new SkillSwapStateImpl();
        StudentService studentService = new StudentServiceImpl(state);
        Scanner scanner = new Scanner(System.in);
        boolean isAppRunning = true;

        System.out.println("--- Welcome to SkillSwapSchool system! ---");

        while (isAppRunning) {
            System.out.println("\n    === Main menu === ");
            System.out.println("1) Register new student");
            System.out.println("2) Show all present Students");
            System.out.println("Choose action");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":

            }
        }
    }
}
