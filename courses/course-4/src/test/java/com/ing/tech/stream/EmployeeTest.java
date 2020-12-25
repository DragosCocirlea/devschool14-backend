package com.ing.tech.stream;

import com.ing.tech.optional.User;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.beans.HasPropertyWithValue.hasProperty;
import static org.junit.Assert.assertEquals;

public class EmployeeTest {

    private static Employee[] arrayOfEmps;
    private static List<Employee> empList;
    private static EmployeeRepository employeeRepository;

    @Before
    public void init() {
        arrayOfEmps = new Employee[]{
                new Employee(1, "Elon Musk", 100000.0),
                new Employee(2, "Bill Gates", 200000.0),
                new Employee(3, "Mark Zuckerberg", 300000.0)};
        empList = Arrays.asList(arrayOfEmps);
        employeeRepository = new EmployeeRepository(empList);
    }

    @Test
    public void whenCollectStreamToList_thenGetList() {
        /*
         * TODO Convert empList to stream and collect it to list
         *
         */
        List<Employee> employees = null;

        assertEquals(empList, employees);
    }

    @Test
    public void whenStreamToArray_thenGetArray() {
        Employee[] employees = null;
        /*
         * TODO Convert arrayOfEmps to stream then get array from stream
         *
         */
        assertThat(arrayOfEmps, equalTo(employees));
    }

    @Test
    public void whenIncrementSalaryForEachEmployee_thenApplyNewSalary() {

        List<Employee> newEmpList = null;

        /*
         * TODO use stream operations to increment salary by 10 % using salaryIncrement from Employee class
         *      Can you use map here?
         */

        assertThat(newEmpList, contains(
                hasProperty("salary", equalTo(110000.0)),
                hasProperty("salary", equalTo(220000.0)),
                hasProperty("salary", equalTo(330000.0))
        ));
    }

    @Test
    public void whenIncrementSalaryUsingPeek_thenApplyNewSalary() {

        List<Employee> newEmpList = null;

        /*
         * TODO Same as previous but using peek
         * https://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html#peek-java.util.function.Consumer-
         * What is the difference between map, peek and forEach?
         */


        assertThat(newEmpList, contains(
                hasProperty("salary", equalTo(110000.0)),
                hasProperty("salary", equalTo(220000.0)),
                hasProperty("salary", equalTo(330000.0))
        ));
    }

    @Test
    public void whenMapIdToEmployees_thenGetEmployeeStream() {
        Integer[] empIds = { 1, 2, 3 };

        /*
         * TODO Using empIds array convert it to stream
         *  and using employeeRepository map ids to employee
         */
        List<Employee> employees = null;

        assertEquals(employees.size(), empIds.length);
    }

    @Test
    public void whenFlatMapEmployeeNames_thenGetNameStream() {
        List<List<String>> namesNested = Arrays.asList(
                Arrays.asList("Elon", "Musk"),
                Arrays.asList("Bill", "Gates"),
                Arrays.asList("Mark", "Zuckerberg"));

        /*
         * TODO Transform the nested list into a flat list using flatMap
         *  flatMap() is the combination of a map and a flat operation i.e, it applies a
         *  function to elements as well as flatten them.
         */
        List<String> namesFlatStream = null;

        assertEquals(namesFlatStream.size(), namesNested.size() * 2);
    }

    @Test
    public void whenFilterEmployees_thenGetFilteredStream() {
        Integer[] empIds = { 1, 2, 3, 4 };

        /*
         * TODO Using empIds array find employee by id from EmployeeRepository
         *  then keep only the employees with salary > 200000
         */

        List<Employee> employees = null;

        assertEquals(Arrays.asList(arrayOfEmps[2]), employees);
    }

    @Test
    public void whenFindFirst_thenGetFirstEmployeeInStream() {
        Integer[] empIds = { 2, 1, 5, 3 };

        /*
         * TODO Using empIds array find employee by id from EmployeeRepository
         *  then return first employee using stream operation not list indexing
         */
        Employee employee = null;

        assertEquals(employee.getSalary(), new Double(200000));
    }

    @Test
    public void whenStreamCount_thenGetElementCount() {
        Long empCount = new Long(0);

        /*
         * TODO Count how many employees have salary bigger than 200000
         *
         */
        assertEquals(empCount, new Long(1));
    }

    @Test
    public void whenLimitInfiniteStream_thenGetFiniteElements() {
        Stream<Integer> infiniteStream = Stream.iterate(2, i -> i * 2);

        List<Integer> collect = null;

        /*
         * TODO You have an infiniteStream of powers of 2
         *  Retrieve 5 elements
         *  PS : Take a look on the assertion and find out if you have to skip some elements
         *
         */

        assertEquals(collect, Arrays.asList(16, 32, 64, 128, 256));
    }

    @Test
    public void whenSortStream_thenGetSortedStream() {

        /*
         * TODO Sort the employees by name
         *
         */

        List<Employee> employees = null;

        assertEquals(employees.get(0).getName(), "Bill Gates");
        assertEquals(employees.get(1).getName(), "Elon Musk");
        assertEquals(employees.get(2).getName(), "Mark Zuckerberg");
    }

    @Test
    public void whenFindMin_thenGetMinElementFromStream() {
        /*
         * TODO find the employee with the minimum salary
         */
        Employee emp = null;


        assertEquals(emp.getId(), new Integer(1));
    }

    @Test
    public void whenFindMax_thenGetMaxElementFromStream() {
        /*
         * TODO find the employee with the maximum salary
         */
        Employee emp = null;

        assertEquals(emp.getSalary(), new Double(300000.0));
    }

    @Test
    public void whenApplyMatch_thenReturnBoolean() {
        List<Integer> intList = Arrays.asList(2, 4, 5, 6, 8);

        /*
         * TODO Implement the lambda functions
         */
        boolean allEven = intList.stream().allMatch(i -> true);
        boolean oneEven = intList.stream().anyMatch(i -> true);
        boolean noneMultipleOfThree = intList.stream().noneMatch(i -> true);

        assertEquals(allEven, false);
        assertEquals(oneEven, true);
        assertEquals(noneMultipleOfThree, false);
    }

    @Test
    public void whenApplySumOnIntStream_thenGetSum() {
        Double avgSal = 0.00;

        // TODO compute the salary average of all employees

        assertEquals(avgSal, new Double(200000));
    }

    @Test
    public void whenApplyReduceOnStream_thenGetValue() {
        // TODO compute the sum of salary of all employees
        //  Hint : use reduce
        Double sumSal = 0.00;

        assertEquals(sumSal, new Double(600000));
    }

    @Test
    public void whenStreamGroupingBy_thenGetMap() {
        // TODO Use Collectors.groupingBy to group employees by name first letter
        Map<Character, List<Employee>> groupByAlphabet = null;

        assertEquals(groupByAlphabet.get('B').get(0).getName(), "Bill Gates");
        assertEquals(groupByAlphabet.get('E').get(0).getName(), "Elon Musk");
        assertEquals(groupByAlphabet.get('M').get(0).getName(), "Mark Zuckerberg");
    }

    @Test
    public void whenStream_thenOk() {
        Stream<User> users = new ArrayList<User>().stream();

        // TODO get first element of the stream, if null create a default user
        User user = null;

        assertEquals(user.getEmail(), "default");
    }

    @Test
    public void whenMapIdToEmployees_thenGetEmployeeStream_optional() {
        Integer[] empIds = { 1, 2, 3 };

        /*
         * TODO check findEmployeeById method from EmployeeRepository
         *  Use this instead of findById
         *
         */
        List<Employee> employees = Stream.of(empIds)
                .map(employeeRepository::findById)
                .collect(Collectors.toList());

        assertEquals(employees.size(), empIds.length);
    }

    @Test
    public void whenFilterEmployees_thenGetFilteredStream_optional() {
        Integer[] empIds = { 1, 2, 3, 4 };

        /*
         * TODO check findEmployeeById method from EmployeeRepository
         *  Use this instead of findById
         *
         */

        List<Employee> employees = Stream.of(empIds)
                .map(employeeRepository::findById)
                .filter(e-> e != null && e.getSalary() > 200000)
                .collect(Collectors.toList());

        assertEquals(Arrays.asList(arrayOfEmps[2]), employees);
    }

    @Test
    public void whenFindFirst_thenGetFirstEmployeeInStream_optional() {
        Integer[] empIds = { 2, 1, 5, 3 };

        /*
         * TODO check findEmployeeById method from EmployeeRepository
         *  Use this instead of findById
         *
         */
        Employee employee = Stream.of(empIds)
                .map(employeeRepository::findById)
                .filter(e-> e != null)
                .findFirst()
                .orElse(null);

        assertEquals(employee.getSalary(), new Double(200000));
    }

}
