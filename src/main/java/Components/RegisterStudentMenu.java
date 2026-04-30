package Components;

import Service.Student.StudentService;
import Util.*;

import java.util.Scanner;

public class RegisterStudentMenu {
    public void registerStudent(Scanner scanner,
                                StudentService studentService,
                                PhoneValidator phoneValidator,
                                EmailValidator emailValidator,
                                NameValidator nameValidator,
                                LetterValidator letterValidator) {
        System.out.println("\n   ---Student Registration---   ");

        String validName;
        while (true) {
            System.out.println("Enter the Name (e.g. Alex, Max): ");
            String rawName = scanner.nextLine();

            if (nameValidator.isValid(rawName)) {
                validName = rawName;
                break;
            } else {
                System.out.println("Error: Enter the valid name. (Check if there is not numbers present in)");
            }
        }

        String validSurname;
        while (true) {
            System.out.println("Enter the Surname (e.g. Ricci, Matteo): ");
            String rawSurname = scanner.nextLine();

            if (nameValidator.isValid(rawSurname)) {
                validSurname = rawSurname;
                break;
            } else {
                System.out.println("Error: Enter the valid surname. (Check if there is not numbers present in)");
            }
        }


        String validEmail;
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


        String formattedPhone;
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

        int validClassNum;
        while (true) {
            try {
                System.out.print("Insert number of class (only number): ");
                validClassNum = Integer.parseInt(scanner.nextLine());
                if (validClassNum > 0 && validClassNum < 20) {
                    break;
                } else {
                    System.out.println("Error: Class number must be between 1 and 20.");
                }
            } catch (NumberFormatException exception) {
                System.out.println("Error: You entered letters! Please use only numbers");
            }
        }

        String validSection;
        while (true ) {
            System.out.println("Enter the class letter: (example, B, C, CT, AIT)");
            String rawSection = scanner.nextLine();

            if (letterValidator.isValid(rawSection)) {
                validSection = rawSection;
                break;
            }

            System.out.println("Error: Invalid section name. " +
                    "Check if there is not bigger letter quantity of letters than 5");
        }

        studentService.registerStudent(validName, validSurname, validEmail, formattedPhone, validClassNum, validSection);
    }
}
