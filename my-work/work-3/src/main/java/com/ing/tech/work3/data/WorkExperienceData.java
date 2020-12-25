package com.ing.tech.work3.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class WorkExperienceData {
    private String position;
    private String workplace;
    private List<String> achievements;
    private String startDate;
    private String endDate;

}
