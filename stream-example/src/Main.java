import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

/*
    1.	Напишите программу, которая создает список целых чисел,
    а затем использует стримы для фильтрации только четных чисел и их сортировки
    по возрастанию.
 */
        System.out.print(" -- Sorted stream, ver.1 --" + "\n");
        Arrays.stream(new Integer[]{3, -1, 0, -4, 1, -2, 3, 7, 5, 6, -10, 8, 20, -10, 2})
                .filter(x -> x % 2 == 0)
                .sorted()
                .forEach(System.out::println);

        System.out.print(" -- Sorted stream, ver.2 --" + "\n");
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

        System.out.print("-- Person grouping by > 40  -- " + "\n");
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
                .forEachOrdered(System.out::println);

/*
    7. Напишите программу, которая читает текстовый файл построчно,
    фильтрует строки по заданному условию (например, содержащим определенное слово),
    и выводит результаты на консоль.
 */
        System.out.print("-- Read file txt -- " + "\n");
        Path path = Paths.get("example.txt");
        try {
            Stream<String> streamByCondition = Files.lines(path, StandardCharsets.UTF_8)
                    .filter(s -> s.contains("по заданному условию"))
                    .collect(Collectors.joining()).lines();
            System.out.println("String by condition : " + streamByCondition.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }

/*  8. Рассмотрите ситуацию, когда стрим может содержать значения, которые не могут быть преобразованы в желаемый тип.
    Напишите программу, которая фильтрует стрим таким образом, чтобы исключить некорректные значения
    и обработать такие случаи.
 */
        System.out.print("\n" + "-- Transformation is OK -- " + "\n");
        Stream.of("3", "6", "8", "14", "15")
                .mapToInt(Integer::parseInt)
                .filter(num -> num % 3 == 0)
                .forEach(System.out::println);

//        System.out.print("\n" + "-- Transformation is not OK -- " + "\n");
//        Stream.of(3, "6", "8", 14, "15")
//                .filter(   )
//                .mapToInt(Integer::parseInt)
//                .forEach(System.out::println);
    }
}