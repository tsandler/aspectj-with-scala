package model;

import annotations.Annotation;

public class JavaEntity {

    @Annotation
    public String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
