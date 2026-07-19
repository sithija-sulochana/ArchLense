package org.example.archlense.detectors;

import org.example.archlense.enumerators.RelationshipType;
import org.example.archlense.model.UMLClass;
import org.example.archlense.model.UMLRelationship;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CompositionDetector {
    public List<UMLRelationship> detect(List<UMLClass> classes) {
        Set<UMLRelationship> results = new HashSet<>();
        for (UMLClass source : classes) {
           for (String created : source.getCreatedObjects()){
               results.add(new UMLRelationship(source.getName(), created, RelationshipType.COMPOSITION));
           }
        }
        return new ArrayList<>(results);
    }
}
