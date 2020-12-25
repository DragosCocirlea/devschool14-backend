package com.ing.tech;

import com.ing.tech.atm.ATM;
import com.ing.tech.atm.Screen;
import com.ing.tech.bean.PersonService;
import com.ing.tech.config.ProjectConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);

//        PersonService personService = context.getBean(PersonService.class);
//        personService.printName();
//        personService.printName();
//        personService.printName();
//        personService.printName();
//        personService.printName();
//
//        Screen screen = context.getBean(Screen.class);
//        screen.displayMessage("ana are mere");

        ATM atm = context.getBean(ATM.class);
        atm.run();
    }
}
