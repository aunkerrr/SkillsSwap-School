package com.github.aunkerrr;

import Service.StudentService;
import Service.StudentServiceImpl;
import Storage.SkillSwapState;
import Storage.SkillSwapStateImpl;
import Util.*;
import com.sun.org.apache.bcel.internal.generic.BREAKPOINT;

import java.util.Scanner;
import java.util.UUID;

public class App {
    public static void main(String[] args) {
        EmailValidator emailValidator = new EmailValidatorImpl();
        PhoneValidator phoneValidator = new PhoneValidatorImpl();
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
                    registerStudentMenu(scanner, studentService, phoneValidator, emailValidator);
                    break;
                case "2":
                    studentService.printAllStudent();
                    break;
                case "0":
                    System.out.println("Exiting from the system... Bye!");
                    isAppRunning = false;
                    break;
                default:
                    System.out.println("Error: Invalid menu item. Please try again");
            }
        }
        scanner.close();
    }

    public static void registerStudentMenu(Scanner scanner,
                                           StudentService studentService,
                                           PhoneValidator phoneValidator,
                                           EmailValidator emailValidator) {
        System.out.println("\n   ---Student Registration---   ");

        String uuid = IdGeneratorImpl.generateUuid();

        System.out.println("Enter the Name: ");
        String name = scanner.nextLine();

        System.out.println("Enter the Surname: ");
        String surname = scanner.nextLine();

        String validEmail = "";
        while (true) {
            System.out.println("Enter the Email (example, student@gmail.com): ");
            String rawEmail = scanner.nextLine();

            if (emailValidator.isValid(rawEmail)) {
                validEmail = rawEmail;
                break;
            } else {
                System.out.println("Error: Invalid email format! Check the '@' and domain.");
            }
        }


        String formattedPhone = "";
        while (true) {
            System.out.println("Enter your phone number (e.g. +39 320 123 4567 or no code): ");
            String rawPhone = scanner.nextLine();
            if (phoneValidator.isValid(rawPhone)) {
                formattedPhone = phoneValidator.numberFormatter(rawPhone);
                break;
            } else {
                System.out.println("Error: Invalid phone format! Check for the length and correctness.");
            }
        }

        int classNum = 0;
        while (true) {
            try {
                System.out.print("Insert number of class(only number): ");
                classNum = Integer.parseInt(scanner.nextLine());
                if (classNum > 0 && classNum < 20) {
                    break;
                } else {
                    System.out.println("Error: Class number must be between 1 and 20.");
                }
            } catch (NumberFormatException exception) {
                System.out.println("Error: You entered letters! Please use only numbers");
            }
        }

        System.out.println("Enter the class lettter: (example, B, C, CT, AIT)");
        String section = scanner.nextLine();

        studentService.registerStudent(uuid, name, surname, validEmail, formattedPhone, classNum, section);
    }
}

