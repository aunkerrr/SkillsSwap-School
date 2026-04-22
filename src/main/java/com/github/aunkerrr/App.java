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

        System.out.println("--- Welcome to SkillSwapSchool system! ---\n");

        while (isAppRunning) {
            System.out.println("\n    === Main menu === ");
            System.out.println("1) Register new student");
            System.out.println("2) Show all present Students");
            System.out.println("Choose action");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    registerStudentMenu(scanner, studentService);
                    break;
                case "2":
                    studentService.printAllStudent();
                    break;
                case "0":
                    System.out.println("Exiting from the system... Bye!");
                    isAppRunning = false;
                default:
                    System.out.println("Error: Invalid menu item. Please try again");
            }
        }
        scanner.close();
    }

    public static void registerStudentMenu(Scanner scanner, StudentService studentService) {
        System.out.println("\n   ---Student Registration---   ");

        int classNum = 0;
        while (true) {
            try {
                System.out.println("Enter the Name: ");
                String name = scanner.nextLine();

                System.out.println("Enter the Surname: ");
                String surname = scanner.nextLine();

                System.out.println("Enter the Email: ");
                String email = scanner.nextLine();

                System.out.println("Enter the phone number: ");
                String phone = scanner.nextLine();



                if (phone.matches("^\\+?[0-9]{10,13}$")) {
                    break; // The phone number is correct, exit the loop!
                } else {
                    System.out.println("Error: Invalid phone number format! Use only numbers (10 to 13 characters), possibly with a leading '+'.");
                }

                System.out.print("Введите номер класса (только цифра): ");
                classNum = Integer.parseInt(scanner.nextLine());
                break; // If everything is ok, we break out of the infinite loop
            } catch (NumberFormatException e) {
                // We gently scold the user and the cycle starts over again
                System.out.println("Error: You entered letters! Please use only numbers");
            }
        }
    }
}
