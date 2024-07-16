package org.savchuk.project.someClass;

import org.savchuk.project.annotation.IntensiveComponent;

import java.util.logging.Logger;

/**
 * Тестовый класс (компонент) с методом run.
 */

@IntensiveComponent
public class SomeClass1 {

    private static final Logger logger = Logger.getLogger(SomeClass1.class.getName());

    public void run() {
        logger.info("Congratulations! SomeClass1 method --run-- is running");
    }
}
