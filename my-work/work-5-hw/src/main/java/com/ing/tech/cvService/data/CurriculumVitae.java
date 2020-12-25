package com.ing.tech.cvService.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CurriculumVitae {
    private String firstName;
    private String lastName;

    private String email;
    private String phoneNumber;
    private String gitRepo;
    private String linkedIn;

    private List<EducationData> education;
    private List<WorkExperienceData> workExperience;
    private List<PersonalProjectData> personalProjects;
    private List<String> skills;
    private List<String> hobbies;

    @JsonIgnore
    public boolean isStudent() {
        for (EducationData e : education) {
            LocalDate startDate = LocalDate.parse(e.getStartDate());
            LocalDate endDate = LocalDate.parse(e.getEndDate());

            if (LocalDate.now().isAfter(startDate) && LocalDate.now().isBefore(endDate)) {
                return true;
            }
        }

        return false;
    }

    public  boolean hasGraduated() {
        for (EducationData e : education) {
            LocalDate endDate = LocalDate.parse(e.getEndDate());

            if (LocalDate.now().isAfter(endDate)) {
                return true;
            }
        }

        return false;
    }

    public boolean hasGraduatedInTheLastYear() {
        for (EducationData e : education) {
            LocalDate endDate = LocalDate.parse(e.getEndDate());

            if (LocalDate.now().minusYears(1).isBefore(endDate)) {
                return true;
            }
        }

        return false;
    }

    @JsonIgnore
    public boolean isEmployed() {
        for (WorkExperienceData w : workExperience) {
            LocalDate startDate = LocalDate.parse(w.getStartDate());
            LocalDate endDate = LocalDate.parse(w.getEndDate());

            if (LocalDate.now().isAfter(startDate) && LocalDate.now().isBefore(endDate)) {
                return true;
            }
        }

        return false;
    }

    public boolean hasWorkExperience(int requiredExperience) {
        int experience = 0;
        for (WorkExperienceData w : workExperience) {
            LocalDate startDate = LocalDate.parse(w.getStartDate());
            LocalDate endDate = LocalDate.parse(w.getEndDate());

            // if the individual hasn't started working here yet, skip
            if (LocalDate.now().isBefore(startDate)) {
                continue;
            }

            // set end limit (now or work end date)
            if (LocalDate.now().isBefore(endDate)) {
                endDate = LocalDate.now();
            }

            experience += (int) ChronoUnit.MONTHS.between(startDate, endDate);
        }

        return experience >= requiredExperience;
    }

    public boolean hasSkill(String requiredSkill) {
        for (String userSkill : skills) {
            if (userSkill.equals(requiredSkill)) {
                return true;
            }
        }

        return false;
    }

    public boolean hasHobby(String requiredHobby) {
        for (String userHobby : hobbies) {
            if (userHobby.equals(requiredHobby)) {
                return true;
            }
        }

        return false;
    }

    public boolean hasGitLink() {
        return gitRepo != null && !gitRepo.isEmpty();
    }


}
