package org.savchuk.project.someClass;

import org.savchuk.project.annotation.IntensiveComponent;

import java.util.logging.Logger;

@IntensiveComponent
public class SomeClass1 {

    private static final Logger logger = Logger.getLogger(SomeClass1.class.getName());

      public void run() {
        logger.info("SomeClass1 metod run is running");
    }
}
