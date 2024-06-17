import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args){

/*
    1.	Напишите программу, которая создает список целых чисел,
    а затем использует стримы для фильтрации только четных чисел и их сортировки
    по возрастанию.
 */
        System.out.print(" -- Sorted stream --" + "\n");
        Arrays.stream(new Integer[]{3, -1, 0, -4, 1, -2, 3, 7, 5, 6, -10, 8, 20, -10, 2})
                .filter(x -> x % 2 == 0)
                .sorted()
                .forEach(System.out::println);

        System.out.print(" -- Sorted stream --" + "\n");
        int[] arr = {-3, -1, 0, -4, 1, -2, 3, 7, 5, 6, -10, 8, 20, -10, 2};
        Arrays.stream(arr)
                .filter(x -> x % 2 == 0)
                .sorted()
                .forEach(System.out::println);

/*
    2.	Создайте список строк, затем используйте стримы для преобразования каждой строки
    в верхний регистр и сборки результатов в новый список.
 */
        System.out.print("-- To uppercase convert -- " + "\n");
        String[] people = {"Вадим", "Антон", "Светлана"};
        List<String> asList = Arrays.stream(people)
                .map(String::toUpperCase)
                .toList();
        asList.forEach(System.out::println);

/*
    3.	Напишите программу, которая использует стрим для вычисления суммы всех элементов
    в массиве целых чисел.
 */
        System.out.print("-- Sum all elements -- " + "\n");
        int[] arrSum = {-3, -1, 0, -4, 1, -2, 3, 7, 5, 6, -10, 8, 20, -10, 2};
        Integer sum = Arrays.stream(arrSum)
                .sum();
        System.out.println(sum);

/*
    4.	Создайте список объектов (например, объекты класса Person с полями name и age).
    Используйте стримы для группировки объектов по возрасту и вычисления среднего возраста
    в каждой группе.
 */
        System.out.print("-- Person grouping by -- " + "\n");
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Вадим", 25));
        persons.add(new Person("Антон", 50));
        persons.add(new Person("Светлана", 43));
        persons.add(new Person("Евгений", 50));
        persons.add(new Person("Дмитрий", 36));
        persons.add(new Person("Дмитрий", 31));

        Map<Integer, List<Person>> map1 = persons.stream()
                .collect(Collectors.groupingBy(Person::getAge));
        map1.forEach((k, v) -> System.out.println(k + ": " + v));
        System.out.println();

        Map<Integer, List<Person>> map2 = persons.stream()
                .filter(p -> p.getAge() > 40)
                .collect(Collectors.groupingBy(Person::getAge));
        map2.forEach((k, v) -> System.out.println(k + ": " + v));
        System.out.println();

        System.out.print("-- Person average -- " + "\n");
        Map<String, Double> avg = persons
                .stream()
                .collect(Collectors.groupingBy(Person::getName, Collectors.averagingInt(Person::getAge)));
        System.out.println(avg);

//        List<Customer> customers = Arrays.asList(
//                new Customer(10, true, 5),
//                new Customer(11, true, 3),
//                new Customer(20, false, 12),
//                new Customer(21, false, 11));
//
//        Map<Boolean, Integer> sum = customers
//                .stream()
//                .collect(Collectors.groupingBy(Customer::isActive, Collectors.summingInt(Customer::getBillingCount)));
//        System.out.println(sum);
//
//        Map<Boolean, Double> avg = customers
//                .stream()
//                .collect(Collectors.groupingBy(Customer::isActive, Collectors.averagingInt(Customer::getBillingCount)));
//        System.out.println(avg);

/*
    5.	Создайте список строк. Используйте стримы для фильтрации строк длиной
    более 5 символов и поиска первой строки, удовлетворяющей условию.
 */
        System.out.print("-- List string > 5 -- " + "\n");
        List<String> list = Arrays.asList("Anna", "Elena", "Vadim",
                "Gennadiy", "Evgeniy", "Evgeniy", "Elena");
        list.stream()
                .filter(s -> s.length() > 5)
                .distinct()
                .forEach(System.out::println);

/*
    6. Перепишите одну из предыдущих задач с использованием параллельного стрима
    (parallelStream()) для выполнения операций на нескольких ядрах процессора.
 */
        System.out.print("-- Use parallelStream -- " + "\n");
        List<String> list1 = Arrays.asList("Anna", "Elena", "Vadim",
                "Gennadiy", "Evgeniy", "Evgeniy", "Elena");
        list.parallelStream()
                .filter(s -> s.length() > 5)
                .distinct()
                .forEach(System.out::println);

/*
    7. Напишите программу, которая читает текстовый файл построчно,
    фильтрует строки по заданному условию (например, содержащим определенное слово),
    и выводит результаты на консоль.
 */
        System.out.print("-- Read file -- " + "\n");

        Path path = Paths.get("example.txt");
        try {
            String res = Files.lines(path, StandardCharsets.UTF_8)
                    .collect(Collectors.joining(System.lineSeparator()));
            System.out.println(res);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}