public class Main {
    public static void main(String[] args) {


//        System.out.println("Start 1 - Throw ArrayIndexOutOfBoundsException");
//        String[] people = {"Вадим", "Антон", "Светлана"};
//        for (int i = 0; i <= 4; i++) {
//            System.out.println(people[i]);
//        }

//        System.out.println("Start 2 - Not Throw ArrayIndexOutOfBoundsException");
//        Arrays.stream(people)
//                .forEach(System.out::println);

       // NumberFormatException extends IllegalArgumentException
        System.out.println("Start 3 - Throw IllegalArgumentException");
        String str = "abc";
        int value = Integer.parseInt("abc");

//        System.out.println("Start 3 - Not Throw IllegalArgumentException");
//        String str = "123";
//        int value1 = Integer.parseInt(str);
//        System.out.println(value1);
    }
}
