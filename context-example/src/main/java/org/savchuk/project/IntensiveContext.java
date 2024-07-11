package org.savchuk.project;


public class IntensiveContext {

    private final String somePackageName;

    /**
     * Принимает пакет somePackageName для поиска классов, аннотированных @IntensiveComponent
     *
     * @param somePackageName
     */
    public IntensiveContext(String somePackageName) {
        this.somePackageName = somePackageName;
    }

    public <T> T getObject(Class<T> type) {
        return null;
    }
}
