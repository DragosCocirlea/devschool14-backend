package com.ing.tech.bean;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Repository
public class PersonRepository {

    List<String> people = new ArrayList<String>();


    PersonRepository() {
        people.add("David");
        people.add("Alex");
        people.add("Dragos");
        people.add("Hefaistos");
    }

    public String getPerson() {
         int index = new Random().nextInt(people.size());

         return people.get(index);
    }
}
