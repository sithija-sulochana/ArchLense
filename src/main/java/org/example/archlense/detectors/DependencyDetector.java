package org.example.archlense.detectors;

import org.example.archlense.enumerators.RelationshipType;
import org.example.archlense.model.UMLClass;
import org.example.archlense.model.UMLMethod;
import org.example.archlense.model.UMLRelationship;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class DependencyDetector {
    public List<UMLRelationship> detect(List<UMLClass> classes) {
        Set<UMLRelationship> results = new HashSet<>();
        for (UMLClass source : classes) {
            for (UMLMethod method : source.getMethods()){
                for (String parameter : method.getParameter()){
                    for (UMLClass target : classes) {
                        if (parameter.equals(target.getName())) {
                            results.add(new UMLRelationship(source.getName(), target.getName(), RelationshipType.DEPENDENCY));
                        }
                    }
                }
            }
        }
        return new ArrayList<>(results);
    }
}
