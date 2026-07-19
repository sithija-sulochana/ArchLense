package org.example.archlense.detectors;

import org.example.archlense.enumerators.RelationshipType;
import org.example.archlense.model.UMLClass;
import org.example.archlense.model.UMLRelationship;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ImplementationDetector {
    public List<UMLRelationship> detect(List<UMLClass> classes) {
        Set<UMLRelationship> results = new HashSet<>();
        for (UMLClass clazz : classes) {
            for (String interfaceName : clazz.getInterfaces()) {
                results.add(new UMLRelationship(clazz.getName(), interfaceName, RelationshipType.IMPLEMENTATION));
            }
        }
        return new ArrayList<>(results);
    }
}
