package com.ing.tech.work3.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ing.tech.work3.data.CurriculumVitae;
import com.ing.tech.work3.exceptions.CVNotFoundException;
import com.ing.tech.work3.exceptions.EmailAlreadyExistsException;
import com.ing.tech.work3.exceptions.FileAccessException;
import com.ing.tech.work3.exceptions.InvalidOptionSelectedException;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CVDatabase {

    private static Map<String, CurriculumVitae> cvs = new HashMap<>();
    private final String fileName = "cv_backup.json";
    private File filePath;
    ObjectMapper mapper;

    public CVDatabase() {
        filePath = new File(getClass().getClassLoader().getResource(fileName).getFile());
        mapper = new ObjectMapper();
        initCVs();
    }

    private void initCVs() throws FileAccessException {
        try {
            List<CurriculumVitae> cvsList = Arrays.asList(mapper.readValue(filePath, CurriculumVitae[].class));
            cvsList.forEach(cv -> cvs.put(cv.getEmail(), cv));
        } catch (Exception e) {
            e.printStackTrace();
            throw new FileAccessException("Couldn't read CVs from 'cv_backup.json'");
        }
    }

    public String insertCV(CurriculumVitae cv) throws EmailAlreadyExistsException, FileAccessException {
        if (cvs.containsKey(cv.getEmail())) {
            throw new EmailAlreadyExistsException("The following email already exists in the system: " + cv.getEmail());
        }

        cvs.put(cv.getEmail(), cv);

        return cv.getEmail();
    }

    public String getCVJSON(String email) throws CVNotFoundException {
        CurriculumVitae cv = cvs.get(email);

        if (cv == null) {
            throw new CVNotFoundException("There is no CV related to this email");
        }

        String cvJSON = null;
        try {
            cvJSON = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(cv);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        
        return cvJSON;
    }

    public Set<String> getAvailableCVs() {
        return cvs.keySet();
    }


    public void backupDB() {
        List<CurriculumVitae> cvList = new ArrayList<>();
        for (Map.Entry<String, CurriculumVitae> entry : cvs.entrySet()) {
            cvList.add(entry.getValue());
        }

        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(filePath, cvList);
        } catch (IOException e) {
            throw new FileAccessException("Couldn't write CV to 'cv_backup.json'");
        }
    }

    public static List<Map.Entry<String, CurriculumVitae>> query(int filterChoice, InputService inputService, OutputService outputService) {
        Predicate<Map.Entry<String, CurriculumVitae>> predicate;

        switch (filterChoice) {
            case 1:
                predicate = entry -> (entry.getValue().isStudent());
                break;
            case 2:
                predicate = entry -> (entry.getValue().isEmployed());
                break;
            case 3:
                predicate = entry -> (entry.getValue().hasGraduated());
                break;
            case 4:
                predicate = entry -> (entry.getValue().hasGraduatedInTheLastYear());
                break;
            case 5:
                predicate = entry -> (entry.getValue().hasGitLink());
                break;
            case 6:
                outputService.displayInputMessage("How many months of experience are required?");
                int requiredExperience = inputService.getIntegerInput();
                predicate = entry -> entry.getValue().hasWorkExperience(requiredExperience);
                break;
            case 7:
                outputService.displayInputMessage("What skill is required?");
                String requiredSkill = inputService.getStringInput();
                predicate = entry -> entry.getValue().hasSkill(requiredSkill);
                break;
            case 8:
                outputService.displayInputMessage("What hobby is required?");
                String requiredHobby = inputService.getStringInput();
                predicate = entry -> entry.getValue().hasHobby(requiredHobby);
                break;
            default:
                throw new InvalidOptionSelectedException("Please select one of the presented options.");
        }

        return cvs.entrySet().stream().filter(predicate).collect(Collectors.toList());
    }


}
