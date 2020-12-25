package com.ing.tech.course1.data;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public class PersonLombok {
    private String lastname;
    private String firstname;

    private int age;

    @Setter
    private String job;

}
