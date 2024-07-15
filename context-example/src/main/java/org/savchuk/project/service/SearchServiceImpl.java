package org.savchuk.project.service;

import org.reflections.Reflections;
import org.savchuk.project.annotation.IntensiveComponent;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class SearchServiceImpl implements SearchService {

    @Override
    public Set<Class<?>> searchClassByAnnotation(String packageName) throws ClassNotFoundException {
        Reflections reflections = new Reflections(packageName);
        Set<Class<?>> set = reflections.getTypesAnnotatedWith(IntensiveComponent.class);
//        List<String> collect = set.stream()
//                .map(Class::getCanonicalName)
//                .collect(Collectors.toList());
        return set;
    }
}
