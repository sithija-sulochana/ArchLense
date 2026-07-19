package org.example.archlense.generator;

import org.example.archlense.model.UMLClass;
import org.example.archlense.model.UMLField;
import org.example.archlense.model.UMLMethod;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PlainUmlGenerator {
    public String generate(List<UMLClass> classes){
        StringBuilder sb = new StringBuilder();

        sb.append("@startuml\n");
        for (UMLClass umlClass : classes) {
            sb.append("class ").append(umlClass.getName()).append(" {\n");
            for (UMLField field : umlClass.getFields()) {
                sb.append("  ").append(field.getName()).append(" : ").append(field.getType()).append("\n");
            }
            for (UMLMethod method : umlClass.getMethods()) {
                sb.append("  ").append(method.getVisibility()).append(" ").append(method.getName()).append("() : ").append(method.getReturnType()).append("\n");
            }
            sb.append("}\n");
        }
        sb.append("@enduml\n");
        return sb.toString();
    }
}
