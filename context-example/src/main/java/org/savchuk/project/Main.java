package org.savchuk.project;

import org.savchuk.project.service.SearchServiceImpl;
import org.savchuk.project.someClass.SomeClass1;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {

        SearchServiceImpl service = new SearchServiceImpl();
        System.out.println(service.searchClassByAnnotation("org.savchuk.project"));



        IntensiveContext context = new IntensiveContext("someClass");
        SomeClass1 class1 = context.getObject(SomeClass1.class);
//        class1.run(); // должен, например, вывести сообщение в консоль
    }
}