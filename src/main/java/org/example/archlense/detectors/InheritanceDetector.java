package org.example.archlense.detectors;

import org.example.archlense.enumerators.RelationshipType;
import org.example.archlense.model.UMLClass;
import org.example.archlense.model.UMLRelationship;


import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class InheritanceDetector {
    public List<UMLRelationship> detect(List<UMLClass> classes) {
        Set<UMLRelationship> results = new HashSet<>();
        for (UMLClass clazz : classes) {
            if(clazz.getParentClass() != null && !clazz.getParentClass().isEmpty()) {
                results.add(new UMLRelationship(clazz.getName(), clazz.getParentClass().get(0), RelationshipType.INHERITANCE));
            }
        }
        return List.copyOf(results);
    }
}
