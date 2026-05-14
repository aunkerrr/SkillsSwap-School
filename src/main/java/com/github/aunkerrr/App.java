package com.github.aunkerrr;

import Components.ListAllStudentMenu;
import Components.RegisterStudentMenu;
import Service.Student.StudentService;
import Service.Student.StudentServiceImpl;
import Storage.CsvLoader.CsvDataLoader;
import Storage.CsvLoader.CsvDataLoaderImpl;
import Storage.SkillSwapState;
import Storage.SkillSwapStateImpl;
import Util.*;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        RegisterStudentMenu registerStudentMenu = new RegisterStudentMenu();
        LetterValidator letterValidator = new LetterValidatorImpl();
        NameValidator nameValidator = new NameValidatorImpl();
        EmailValidator emailValidator = new EmailValidatorImpl();
        PhoneValidator phoneValidator = new PhoneValidatorImpl();
        SkillSwapState state = new SkillSwapStateImpl();
        StudentService studentService = new StudentServiceImpl(state);
        ListAllStudentMenu listAllStudentMenu = new ListAllStudentMenu();
        CsvDataLoader csvDataLoader = new CsvDataLoaderImpl();
        Scanner scanner = new Scanner(System.in);
        boolean isAppRunning = true;

        csvDataLoader.loadStudents("data/Students.csv", state);

        System.out.println("--- Welcome to SkillSwapSchool system! ---\n");

        while (isAppRunning) {
            System.out.println("    === Main menu === ");
            System.out.println("1) Register new student");
            System.out.println("2) Show all present Students");
            System.out.println("Choose action");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    registerStudentMenu.registerStudent(scanner,
                            studentService,
                            phoneValidator,
                            emailValidator,
                            nameValidator,
                            letterValidator);
                    break;
                case "2":
                    listAllStudentMenu.printStudentsMenu(studentService);
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
}

