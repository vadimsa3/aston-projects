package org.savchuk.project.service;

import java.lang.annotation.Annotation;
import java.util.Set;

/**
 * Поиск классов с аннотацией @IntensiveComponent.
 */
public interface SearchService {
    Set<Class<?>> searchClassByAnnotation(String packageName,Class<? extends Annotation> annotation);
}