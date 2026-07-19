package org.example.archlense.generator;

import org.example.archlense.enumerators.RelationshipType;
import org.example.archlense.model.UMLClass;
import org.example.archlense.model.UMLField;
import org.example.archlense.model.UMLMethod;
import org.example.archlense.model.UMLRelationship;
import org.example.archlense.util.RelationshipUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PlainUmlGenerator {


    public String generate(List<UMLClass> classes, List<UMLRelationship> relationships){
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
        for (UMLRelationship relationship : relationships){
            sb.append(relationship.getSource()).append(" ").append(RelationshipUtils.generateRelationshipArrow(relationship.getType())).append(" ").append(relationship.getTarget()).append("\n");

        }
        sb.append("@enduml\n");
        return sb.toString();
    }
}
