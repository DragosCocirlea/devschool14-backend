package com.ing.tech.cvService.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PersonalProjectData {
    private String name;
    private List<String> about;
    private String startDate;
    private String endDate;
}
