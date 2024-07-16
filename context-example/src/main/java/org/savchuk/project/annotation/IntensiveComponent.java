package org.savchuk.project.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Аннотация для классов, включаемых в IntensiveContext.
 * С политикой хранения RUNTIME (можно получить доступ в программе во время ее выполнения).
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface IntensiveComponent {
}