package org.savchuk.project.service;

/**
 * Создание экземпляров классов.
 */
public interface DependencyFactory {
    <T> T createInstance(Class<T> type);
}