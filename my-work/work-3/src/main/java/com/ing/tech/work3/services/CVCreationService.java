package com.ing.tech.work3.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ing.tech.work3.data.CurriculumVitae;
import com.ing.tech.work3.data.EducationData;
import com.ing.tech.work3.data.PersonalProjectData;
import com.ing.tech.work3.data.WorkExperienceData;
import com.ing.tech.work3.exceptions.FileAccessException;
import com.ing.tech.work3.exceptions.InvalidOptionSelectedException;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CVCreationService {

    ObjectMapper mapper;
    InputService inputService;
    OutputService outputService;

    public CVCreationService(InputService inputService, OutputService outputService) {
        mapper = new ObjectMapper();
        this.inputService = inputService;
        this.outputService = outputService;
    }

    public CurriculumVitae createCV(int choice) {
        if (choice == 1) {
            return createRandomCV();
        } else if (choice == 2) {
            return  readCVFromFile();
        } else {
            throw new InvalidOptionSelectedException("Please select one of the presented options.");
        }
    }

    public CurriculumVitae readCVFromFile() throws FileAccessException {
        try {
            File inputFile = new File("./my-work/work-3/cv_input.json");
            return mapper.readValue(inputFile, CurriculumVitae.class);
        } catch (Exception e) {
            throw new FileAccessException("Couldn't read new CV from 'cv_input.json'");
        }
    }

    public CurriculumVitae createRandomCV() {
        String firstName, lastName, email;

        outputService.displayInputMessage("Insert first name");
        firstName = inputService.getStringInput();

        outputService.displayInputMessage("Insert last name");
        lastName = inputService.getStringInput();

        outputService.displayInputMessage("Insert email (it has to be unique)");
        email = inputService.getStringInput();

        // random school dates
        Random random = new Random();
        int offset = random.nextInt(48) + 12;
        String startDateSchool = LocalDate.now().minusMonths(offset).toString();
        String endDateSchool = LocalDate.now().minusMonths(offset + 48).toString();

        // random work experience dates
        offset = random.nextInt(12);
        String startDateWork = LocalDate.now().minusMonths(offset).toString();
        String endDateWork = LocalDate.now().minusMonths(offset + 6).toString();

        // random project dates
        offset = random.nextInt(36);
        String startDateProject = LocalDate.now().minusMonths(offset).toString();
        String endDateProject = LocalDate.now().minusMonths(offset + 6).toString();

        // education
        EducationData educationData = new EducationData("CTI", "UPB", startDateSchool, endDateSchool);
        List<EducationData> education = new ArrayList<>();
        education.add(educationData);

        // work experience
        List<String> ach = new ArrayList<>();
        ach.add("Am invatat multe");
        WorkExperienceData workExperienceData = new WorkExperienceData("Programator", "Ixia", ach, startDateWork, endDateWork);
        List<WorkExperienceData> work = new ArrayList<>();
        work.add(workExperienceData);

        // personal projects
        List<String> about = new ArrayList<>();
        about.add("Am facut aia");
        about.add("Am facut si aialalta");
        PersonalProjectData personalProject = new PersonalProjectData("C-magine", about, startDateProject, endDateProject);
        List<PersonalProjectData> projects = new ArrayList<>();
        projects.add(personalProject);

        // skills
        List<String> skills = new ArrayList<>();
        skills.add("C");
        skills.add("Java");
        skills.add("Kotlin");

        // hobbies
        List<String> hobbies = new ArrayList<>();
        hobbies.add("Skiing");
        hobbies.add("Bouldering");
        hobbies.add("Football");

        return new CurriculumVitae(firstName, lastName, email, "07xx xxx xxx", "git", "linkedin", education, work, projects, skills, hobbies);
    }


}
