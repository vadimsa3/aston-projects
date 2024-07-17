package org.savchuk.project.service;

import java.lang.reflect.Constructor;

/**
 * Реализация интерфейса создания экземпляров класса.
 */

public class DependencyFactoryImpl implements DependencyFactory {

    /**
     * Создание экземпляра класса с помощью конструктора.
     *
     * @param type класса
     * @exception RuntimeException ошибка создания экземпляра класса
     * @return экземпляр класса
     */
    @Override
    public <T> T createInstance(Class<T> type) {
        try {
            Constructor<T> constructor = type.getDeclaredConstructor();
            return constructor.newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Ошибка создания экземпляра класса " + e);
        }
    }
}
