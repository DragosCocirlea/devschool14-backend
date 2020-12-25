package com.ing.tech.cvService.services;

import org.springframework.stereotype.Service;

@Service
public class OutputService {

    public void displayMessage(String message) {
        System.out.println(message);
    }

    public void displayInputMessage(String message) {
        System.out.println(message);
        System.out.print("\t> ");
    }



    public void displayMenu() {
        System.out.println("\n======================================\n");
        System.out.println("Welcome to the Curriculum Vitae Centralization Service");
        System.out.println("Choose one of the following actions:");
        System.out.println("1. Insert a CV into the database");
        System.out.println("2. Read a CV from the database.");
        System.out.println("3. Get list of all CVs.");
        System.out.println("4. Filter through the list of CVs.");
        System.out.println("5. Exit the application");
        System.out.print("\t> ");
    }

}
