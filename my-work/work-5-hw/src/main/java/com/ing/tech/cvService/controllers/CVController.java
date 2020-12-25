package com.ing.tech.cvService.controllers;

import com.ing.tech.cvService.data.CurriculumVitae;
import com.ing.tech.cvService.exceptions.InvalidOptionSelectedException;
import com.ing.tech.cvService.repositories.CVDatabase;
import com.ing.tech.cvService.services.CVCreationService;
import com.ing.tech.cvService.services.InputService;
import com.ing.tech.cvService.services.OutputService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Controller
@NoArgsConstructor
public class CVController {

    InputService inputService;
    OutputService outputService;
    CVDatabase cvDatabase;
    CVCreationService cvCreationService;

    @Autowired
    public CVController(InputService inputService, OutputService outputService, CVDatabase cvDatabase, CVCreationService cvCreationService) {
        this.inputService = inputService;
        this.outputService = outputService;
        this.cvDatabase = cvDatabase;
        this.cvCreationService = cvCreationService;
    }

    public void run() {
        outputService.displayMessage("Welcome to the Curriculum Vitae centralization service!");

        while (true) {
            try {
                outputService.displayMenu();

                int actionChosen = inputService.getIntegerInput();
                if (!executeAction(actionChosen)) {
                    break;
                }

            } catch (RuntimeException e) {
                outputService.displayMessage(e.toString());
            }
        }

    }

    private boolean executeAction(int actionChosen) throws RuntimeException {
        outputService.displayMessage("\n");
        switch (actionChosen) {
            case 1:
                outputService.displayMessage("How would you like to insert the CV?");
                outputService.displayMessage("1. From the keyboard (limited control)");
                outputService.displayInputMessage("2. From the 'cv_input.json' file (full control)");

                int insertChoice = inputService.getIntegerInput();
                String id = cvDatabase.insertCV(cvCreationService.createCV(insertChoice));
                outputService.displayMessage(id + " has been added to the CV database.");
                break;
            case 2:
                outputService.displayInputMessage("Enter the email of the CV.");
                String email = inputService.getStringInput();
                String cvJSON = cvDatabase.getCVJSON(email);
                outputService.displayMessage(cvJSON);
                break;
            case 3:
                Set<String> availableCVs = cvDatabase.getAvailableCVs();
                outputService.displayMessage("These are the available CVs:");
                for (String emailCV : availableCVs) {
                    outputService.displayMessage("\t- " + emailCV);
                }
                break;
            case 4:
                outputService.displayMessage("What would you like to filter by?");
                outputService.displayMessage("1. Is still student");
                outputService.displayMessage("2. Is employed");
                outputService.displayMessage("3. Has graduated");
                outputService.displayMessage("4. Has git repository link");
                outputService.displayMessage("5. Has work experience");
                outputService.displayMessage("6. Has skill");
                outputService.displayInputMessage("7. Has hobby");
                int filterChoice = inputService.getIntegerInput();

                List<Map.Entry<String, CurriculumVitae>> queryResult = CVDatabase.query(filterChoice, inputService, outputService);

                if (queryResult.size() == 0) {
                    outputService.displayMessage("No CV satisfies the search query.");
                    break;
                }

                outputService.displayMessage("These CVs satisfy the search query:");
                for (Map.Entry<String, CurriculumVitae> cv : queryResult) {
                    outputService.displayMessage("\t- " + cv.getKey());
                }

                break;
            case 5:
                cvDatabase.backupDB();
                return false;
            default:
                throw new InvalidOptionSelectedException("Please select one of the presented options.");
        }

        return true;
    }

}
