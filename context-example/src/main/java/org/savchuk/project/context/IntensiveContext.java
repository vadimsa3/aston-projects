package org.savchuk.project.context;

import org.savchuk.project.annotation.IntensiveComponent;
import org.savchuk.project.service.DependencyFactory;
import org.savchuk.project.service.DependencyFactoryImpl;
import org.savchuk.project.service.SearchService;
import org.savchuk.project.service.SearchServiceImpl;

import java.util.Set;

/**
 * Аналог SpringContext
 */
public class IntensiveContext {

    private final String somePackageName;
    private final SearchService searchService;
    private final DependencyFactory dependencyFactory;

    /**
     * Конструктор для создания экземпляра класса из переданного пакета somePackageName
     */
    public IntensiveContext(String somePackageName) {
        this.somePackageName = somePackageName;
        this.searchService = new SearchServiceImpl();
        this.dependencyFactory = new DependencyFactoryImpl();
    }

    /**
     * Получение объекта переданного класса, аннотированного @IntensiveComponent, из контекста.
     *
     * @param type класс, объект которого необходимо получить
     * @param <T>  тип объекта
     * @return объект указанного класса из контекста
     * @throws RuntimeException если количество совпадающих классов не равно 1
     */
    public <T> T getObject(Class<T> type) {
        Set<Class<?>> componentAnnotatedClasses = searchService.searchClassByAnnotation(somePackageName,
                IntensiveComponent.class);
        Class<?> someClass = componentAnnotatedClasses.iterator().next();
        Object dependencyFactoryInstance = dependencyFactory.createInstance(someClass);
        return (T) dependencyFactoryInstance;
    }
}