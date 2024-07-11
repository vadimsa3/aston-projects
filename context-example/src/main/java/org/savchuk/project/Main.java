package org.savchuk.project;

import org.savchuk.project.someClass.SomeClass1;

public class Main {
    public static void main(String[] args) {

        IntensiveContext context = new IntensiveContext("someClass");
        SomeClass1 class1 = context.getObject(SomeClass1.class);
        class1.run(); // должен, например, вывести сообщение в консоль
    }
}