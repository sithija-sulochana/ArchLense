package org.example.archlense.detectors;

import org.example.archlense.enumerators.RelationshipType;
import org.example.archlense.model.UMLClass;
import org.example.archlense.model.UMLField;
import org.example.archlense.model.UMLRelationship;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class AssociationDetector {

    public List<UMLRelationship> detect(List<UMLClass> classes) {

        Set<UMLRelationship> results = new HashSet<>();
        for (UMLClass source : classes) {
            for (UMLField field :source.getFields()){
                for (UMLClass target : classes) {
                    if (field.getType().equals(target.getName())) {
                        results.add(new UMLRelationship(source.getName(), target.getName(), RelationshipType.ASSOCIATION));
                    }
                }
            }
        }
        return new ArrayList<>(results);
    }
}
