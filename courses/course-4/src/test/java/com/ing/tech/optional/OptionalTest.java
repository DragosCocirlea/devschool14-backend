package com.ing.tech.optional;

import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;

public class OptionalTest {

    @Test
    public void whenCreateEmptyOptional_then_Exception1() {
        User user = null;

        // TODO fix this test without modifying the 2 following lines of code

        Optional<User> emptyOpt = Optional.empty();
        emptyOpt.get();
    }

    @Test
    public void whenCreateOfEmptyOptional_then_Exception2() {
        User user = null;

        // TODO fix this test without modifying the following line of code

        Optional<User> opt = Optional.of(user);
    }

    @Test
    public void whenCreateOfNullableOptional_thenOk() {
        String name = "John";
        Optional<String> opt = Optional.ofNullable(name);

        // TODO write the assertion by retrieving the string value from the optional container
        assertEquals("John", null);
    }

    @Test
    public void whenCheckIsPresent_thenOk() {
        User user = new User("john@gmail.com", "1234");
        Optional<User> opt = Optional.ofNullable(user);

        // TODO check if the optional contains a value
        assertTrue(false);

        /* TODO assert if the email of the user is the same as the one of
         *  the user in the optional container
         */
        assertEquals(user.getEmail(), null);
    }

    @Test
    public void whenSettingNewPassword_thenOk() {
        User user = new User("john@gmail.com", "1234");
        Optional<User> opt = Optional.ofNullable(user);

        /*
         * TODO change the user's password
         *      Hint: You can apply map or ifPresent on opt object
         */

        assertEquals(opt.get().getPassword(), "12345");

    }

    @Test
    public void whenEmptyValue_thenReturnDefault() {
        User user1 = null;
        User user2 = new User("anna@gmail.com", "1234");

        // TODO using Optional return the non null user
        User result = null;

        assertEquals("anna@gmail.com", result.getEmail());
    }

    @Test
    public void givenPresentValue_whenCompare_thenOk() {
        User user = new User("john@gmail.com", "1234");

        /*
         * TODO Using Optional check if the previous user is null
         *      If null create a new user
         *      Write the assertion too
         */
        User result = null;
    }


    @Test
    public void givenEmptyValue_whenCompare_thenOk() {
        User user = null;
        /*
         * TODO Using Optional check if the previous user is null
         *      If null create a new user
         *      Write the assertion too
         */
        User result = null;
    }

    @Test
    public void whenThrowException_thenOk() {
        User user = null;
        // TODO Fix the test without modifying the next line of code
        User result = Optional.ofNullable(user).orElseThrow(() -> new IllegalArgumentException());
    }

    @Test
    public void whenMap_thenOk() {
        User user = new User("anna@gmail.com", "1234");
        Optional<User> optUser = Optional.ofNullable(user);
        // TODO get the email of the user
        String email = null;
        assertEquals(email, user.getEmail());

    }

    @Test
    public void whenGetPosition_thenOk() {
        User user = new User("anna@gmail.com", "1234");
        user.setPosition("Developer");

        /*
         * TODO get user's position
         *  What higher order function is best for this case map or flatMap
         *  Test both and choose the best approach
         *  Why this is different from the previous test?
         */

        String position = null;

        assertEquals(position, user.getPosition().get());

    }

    @Test
    public void whenFilter_thenOk() {
        User user = new User("anna", "1234");

        // TODO check if the email of the user is a valid one return empty Optional otherwise
        Optional<User> result = Optional.ofNullable(user);

        assertFalse(result.isPresent());
    }

    @Test
    public void whenChaining_thenOk() {
        User user = new User("anna@gmail.com", "1234");

        /*
         * TODO obtain countryCode of the country from user's address
         *  If null return "default" string
         *  Use lambda functions
         */

        String result = null;
        assertEquals(result, "default");
    }

    @Test
    public void whenChainingWithMethodReferences_thenOk() {
        Country country = new Country("New Zealand", "NZ");
        Address address = new Address(null, null, country);
        User user = new User("Ross", "98700987");
        user.setAddress(address);

        /*
         * TODO obtain countryCode of the country from user's address
         *  If null return "default" string
         *  Use methodReference
         */
        String result = null;
        assertEquals(result, "default");
    }
}