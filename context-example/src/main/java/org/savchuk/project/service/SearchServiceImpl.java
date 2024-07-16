package org.savchuk.project.service;

import org.reflections.Reflections;
import org.savchuk.project.annotation.IntensiveComponent;

import java.lang.annotation.Annotation;
import java.util.NoSuchElementException;
import java.util.Set;

/**
 * Реализация интерфейса поиска аннотированных классов в передаваемом пакете.
 */

public class SearchServiceImpl implements SearchService {

    /**
     * Поиск и получение набора уникальных аннотированных классов
     *
     * @param packageName передаваемый пакет для поиска аннотированных классов
     * @param annotation  класс аннотации которой аннотирован искомый класс в передаваемом пакете
     * @exception NoSuchElementException при отсутствии аннотированного класса в переданном пакете
     * @return набор уникальных аннотированных классов
     */
    @Override
    public Set<Class<?>> searchClassByAnnotation(String packageName, Class<? extends Annotation> annotation) {
        Reflections reflections = new Reflections(packageName);
        Set<Class<?>> setAnnotatedClasses = reflections.getTypesAnnotatedWith(annotation);
        if (setAnnotatedClasses.isEmpty()) {
            throw new NoSuchElementException("Класс с аннотацией " +
                    IntensiveComponent.class.getSimpleName() +
                    " в переданном пакете не найден");
        }
        return setAnnotatedClasses;
    }
}