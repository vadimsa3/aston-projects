package org.savchuk.project.service;

import java.util.Set;

public interface SearchService {
    Set<Class<?>> searchClassByAnnotation(String packageName) throws ClassNotFoundException;
}