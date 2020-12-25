package com.ing.tech.work3.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EducationData {
    private String studyProgram;
    private String institution;
    private String startDate;
    private String endDate;
}
