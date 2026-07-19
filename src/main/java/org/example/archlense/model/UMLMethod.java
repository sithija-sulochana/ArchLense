package org.example.archlense.model;


import java.util.ArrayList;
import java.util.List;


public class UMLMethod {
    private String name;
    private String returnType;
    private String visibility;
    private List<String> parameter = new ArrayList<>();

    public UMLMethod(String name, String returnType, String visibility, List<String> parameter) {
        this.name = name;
        this.returnType = returnType;
        this.visibility = visibility;
        this.parameter = parameter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReturnType() {
        return returnType;
    }

    public void setReturnType(String returnType) {
        this.returnType = returnType;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public List<String> getParameter() {
        return parameter;
    }

    public void setParameter(List<String> parameter) {
        this.parameter = parameter;
    }
}


