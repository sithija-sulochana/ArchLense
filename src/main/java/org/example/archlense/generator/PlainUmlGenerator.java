package org.example.archlense.generator;

import org.example.archlense.model.UMLClass;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PlainUmlGenerator {
    public String generate(List<UMLClass> classes){
        StringBuilder sb = new StringBuilder();

        sb.append("@startuml\n");
        for (UMLClass umlClass : classes) {
            sb.append("class ").append(umlClass.getName()).append(" {\n");
            for (String field : umlClass.getFields()) {
                sb.append("  ").append(field).append("\n");
            }
            sb.append("}\n");
        }
        sb.append("@enduml\n");
        return sb.toString();
    }
}
