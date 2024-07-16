package org.savchuk.project;

import org.savchuk.project.context.IntensiveContext;
import org.savchuk.project.someClass.SomeClass1;

public class Main {
    public static void main(String[] args){

        IntensiveContext context = new IntensiveContext("org.savchuk.project");
        SomeClass1 class1 = context.getObject(SomeClass1.class);
        class1.run();
    }
}