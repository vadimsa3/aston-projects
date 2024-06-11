public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        String[] roles = {
                "Городничий",
                "Аммос Федорович",
                "Артемий Филиппович",
                "Лука Лукич"};

        String[] textLines = {
                "Городничий: Я пригласил вас, господа, с тем, чтобы сообщить вам пренеприятное известие: к нам едет ревизор.",
                "Аммос Федорович: Как ревизор?",
                "Артемий Филиппович: Как ревизор?",
                "Городничий: Ревизор из Петербурга, инкогнито. И еще с секретным предписаньем.",
                "Аммос Федорович: Вот те на!",
                "Артемий Филиппович: Вот не было заботы, так подай!",
                "Лука Лукич: Господи боже! еще и с секретным предписаньем!"};

        for (String role : roles) {
            System.out.println(role + ": ");
            for (int i = 0; i <= textLines.length - 1; i++) {
                String textLine = textLines[i];
                if (textLine.contains(role)) {
                    System.out.println(textLine.replaceAll(role + ":", i + 1 + ")"));
                }
            }
            System.out.println("\n");
        }

// -------------------------------------------------------------------------------------------------------------------
        // АЛГОРИТМЫ

        // поиск n-го числа Фибоначчи
        int n = 10;
        System.out.println("Введенное число - " + n);
        System.out.println("Рекурсия - " + fibonacciValueRecurs(n));
        System.out.println("Цикл - ");
        fibonacciValueCycle(n);
    }

    // поиск n-го числа Фибоначчи циклом
    public static void fibonacciValueCycle(int n) {
        //Объявляем переменные при известных первых двух:
        int num0 = 0;
        int num1 = 1;
        int num2;
        //Первые две переменные выводим вне цикла:
        System.out.print(num0 + " " + num1 + " ");
        for (int i = 3; i <= n; i++) {
            num2 = num0 + num1;
            //Каждый следующий элемент выводим в цикле:
            System.out.print(num2 + " ");
            //Предыдущим двум переменным присваиваем новые значения:
            num0 = num1;
            num1 = num2;
        }
    }

    // поиск n-го числа Фибоначчи (рекурсией).
    // Рекурсивная функция приводит к многоразовому вызову одних и тех же операций.
    // Из-за этого её не рекомендуется использовать.
    public static int fibonacciValueRecurs(int n) {
        if (n <= 1) {
            return 0;
        } else if (n == 2) {
            return 1;
        } else {
            return fibonacciValueRecurs(n - 1) + fibonacciValueRecurs(n - 2);
        }
    }
}