package com.ing.tech.stream;

import com.ing.tech.optional.User;
import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;
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
        List<Employee> employees = null;

        /*
         * TODO Convert empList to stream and collect it to list
         *
         */
        employees = empList.stream().collect(Collectors.toList());

        assertEquals(empList, employees);
    }

    @Test
    public void whenStreamToArray_thenGetArray() {
        Employee[] employees = null;

        /*
         * TODO Convert arrayOfEmps to stream then get array from stream
         *
         */
        employees = empList.stream().toArray(Employee[]::new);
        assertThat(arrayOfEmps, equalTo(employees));
    }

    @Test
    public void whenIncrementSalaryForEachEmployee_thenApplyNewSalary() {

        List<Employee> newEmpList = null;

        /*
         * TODO use stream operations to increment salary by 10 % using salaryIncrement from Employee class
         *      Can you use map here?
         */

        newEmpList = empList.stream().map(s -> s.salaryIncrement(10.0)).collect(Collectors.toList());

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

        newEmpList = empList.stream().peek(emp -> emp.salaryIncrement(10.0)).collect(Collectors.toList());

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
        List<Employee> employees = Arrays.stream(empIds)
                                            .map(empId -> employeeRepository.findById(empId))
                                            .collect(Collectors.toList());;

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
        List<String> namesFlatStream = namesNested.stream()
                                                .flatMap(Collection::stream)
                                                .collect(Collectors.toList());

        assertEquals(namesFlatStream.size(), namesNested.size() * 2);
    }

    @Test
    public void whenFilterEmployees_thenGetFilteredStream() {
        Integer[] empIds = { 1, 2, 3, 4 };

        /*
         * TODO Using empIds array find employee by id from EmployeeRepository
         *  then keep only the employees with salary > 200000
         */

        List<Employee> employees = Arrays.stream(empIds)
                                        .map(empId -> employeeRepository.findEmployeeById(empId))
                                        .filter(Optional::isPresent)
                                        .filter(emp -> emp.get().getSalary() > 200000)
                                        .map(Optional::get)
                                        .collect(Collectors.toList());

        assertEquals(Arrays.asList(arrayOfEmps[2]), employees);
    }

    @Test
    public void whenFindFirst_thenGetFirstEmployeeInStream() {
        Integer[] empIds = { 2, 1, 5, 3 };

        /*
         * TODO Using empIds array find employee by id from EmployeeRepository
         *  then return first employee using stream operation not list indexing
         */
        Employee employee = Arrays.stream(empIds)
                                .map(empId -> employeeRepository.findEmployeeById(empId))
                                .filter(Optional::isPresent)
                                .findFirst()
                                .get()
                                .get();

        assertEquals(employee.getSalary(), new Double(200000));
    }

    @Test
    public void whenStreamCount_thenGetElementCount() {
        Long empCount = 0L;

        /*
         * TODO Count how many employees have salary bigger than 200000
         *
         */
        empCount = empList.stream()
                            .filter(emp -> emp.getSalary()>200000)
                            .count();

        assertEquals(empCount, Long.valueOf(1));
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

        collect = infiniteStream.skip(3)
                                .limit(5)
                                .collect(Collectors.toList());

        assertEquals(collect, Arrays.asList(16, 32, 64, 128, 256));
    }

    @Test
    public void whenSortStream_thenGetSortedStream() {

        /*
         * TODO Sort the employees by name
         *
         */

        List<Employee> employees = empList.stream()
                                        .sorted(Comparator.comparing(Employee::getName))
                                        .collect(Collectors.toList());

        assertEquals(employees.get(0).getName(), "Bill Gates");
        assertEquals(employees.get(1).getName(), "Elon Musk");
        assertEquals(employees.get(2).getName(), "Mark Zuckerberg");
    }

    @Test
    public void whenFindMin_thenGetMinElementFromStream() {
        /*
         * TODO find the employee with the minimum salary
         */
        Employee emp = empList.stream()
                                .min(Comparator.comparingDouble(Employee::getSalary))
                                .get();

        assertEquals(emp.getId(), new Integer(1));
    }

    @Test
    public void whenFindMax_thenGetMaxElementFromStream() {
        /*
         * TODO find the employee with the maximum salary
         */
        Employee emp = empList.stream()
                .max(Comparator.comparingDouble(Employee::getSalary))
                .get();

        assertEquals(emp.getSalary(), new Double(300000.0));
    }

    @Test
    public void whenApplyMatch_thenReturnBoolean() {
        List<Integer> intList = Arrays.asList(2, 4, 5, 6, 8);

        /*
         * TODO Implement the lambda functions
         */
        boolean allEven = intList.stream().allMatch(i -> i % 2 == 0);
        boolean oneEven = intList.stream().anyMatch(i -> i % 2 != 0);
        boolean noneMultipleOfThree = intList.stream().noneMatch(i -> i % 3 == 0);

        assertEquals(allEven, false);
        assertEquals(oneEven, true);
        assertEquals(noneMultipleOfThree, false);
    }

    @Test
    public void whenApplySumOnIntStream_thenGetSum() {
        Double avgSal = 0.00;

        // TODO compute the salary average of all employees
        avgSal = empList.stream()
                        .mapToDouble(Employee::getSalary)
                        .average()
                        .getAsDouble();

        assertEquals(avgSal, new Double(200000));
    }

    @Test
    public void whenApplyReduceOnStream_thenGetValue() {
        // TODO compute the sum of salary of all employees
        //  Hint : use reduce
        Double sumSal = 0.00;

        sumSal = empList.stream().map(Employee::getSalary).reduce((double) 0, Double::sum);

        assertEquals(sumSal, new Double(600000));
    }

    @Test
    public void whenStreamGroupingBy_thenGetMap() {
        // TODO Use Collectors.groupingBy to group employees by name first letter
        Map<Character, List<Employee>> groupByAlphabet = empList.stream().collect(groupingBy(emp -> emp.getName().charAt(0)));

        assertEquals(groupByAlphabet.get('B').get(0).getName(), "Bill Gates");
        assertEquals(groupByAlphabet.get('E').get(0).getName(), "Elon Musk");
        assertEquals(groupByAlphabet.get('M').get(0).getName(), "Mark Zuckerberg");
    }

    @Test
    public void whenStream_thenOk() {
        Stream<User> users = new ArrayList<User>().stream();

        // TODO get first element of the stream, if null create a default user
        User user = users.findFirst().orElse(new User("default", "0000"));

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
                .map(employeeRepository::findEmployeeById)
                .map(Optional::get)
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
                .map(employeeRepository::findEmployeeById)
                .filter(Optional::isPresent)
                .map(Optional::get)
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
                .map(employeeRepository::findEmployeeById)
                .filter(e-> e != null)
                .map(Optional::get)
                .findFirst()
                .orElse(null);

        assertEquals(employee.getSalary(), new Double(200000));
    }

}
