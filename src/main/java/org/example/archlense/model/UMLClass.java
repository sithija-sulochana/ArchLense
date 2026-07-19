package org.example.archlense.model;


import java.util.ArrayList;
import java.util.List;


public class UMLClass {
    private String name;
    private List<UMLField > fields = new ArrayList<>();
    private List<UMLMethod> methods = new ArrayList<>();
    private List<String> interfaces = new ArrayList<>();
    private List<String> parentClass = new ArrayList<>();
    private List<String> dependencies = new ArrayList<>();
    private List<String> createdObjects = new ArrayList<>();
    public UMLClass(String name) {
        this.name = name;
    }

    public UMLClass(String name, List<UMLField> fields, List<UMLMethod> methods, List<String> interfaces, List<String> parentClass, List<String> dependencies, List<String> createdObjects) {
        this.name = name;
        this.fields = fields;
        this.methods = methods;
        this.interfaces = interfaces;
        this.parentClass = parentClass;
        this.dependencies = dependencies;
        this.createdObjects = createdObjects;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<UMLField> getFields() {
        return fields;
    }

    public void setFields(List<UMLField> fields) {
        this.fields = fields;
    }

    public List<UMLMethod> getMethods() {
        return methods;
    }

    public void setMethods(List<UMLMethod> methods) {
        this.methods = methods;
    }

    public List<String> getInterfaces() {
        return interfaces;
    }

    public void setInterfaces(List<String> interfaces) {
        this.interfaces = interfaces;
    }

    public List<String> getParentClass() {
        return parentClass;
    }

    public void setParentClass(List<String> parentClass) {
        this.parentClass = parentClass;
    }

    public List<String> getDependencies() {
        return dependencies;
    }

    public void setDependencies(List<String> dependencies) {
        this.dependencies = dependencies;
    }

    public List<String> getCreatedObjects() {
        return createdObjects;
    }

    public void setCreatedObjects(List<String> createdObjects) {
        this.createdObjects = createdObjects;
    }
}
