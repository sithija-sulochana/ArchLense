package org.example.archlense.analyzer;

import org.example.archlense.enumerators.RelationshipType;
import org.example.archlense.model.UMLClass;
import org.example.archlense.model.UMLRelationship;
import org.springframework.stereotype.Component;

@Component
public class RelationShipAnalyzer {
    public UMLRelationship analyze (UMLClass source, String field){
        String type = extractType(field);
        UMLRelationship relationship = new UMLRelationship(source.getName(),field, RelationshipType.ASSOCIATION);
        return relationship;
    }

    private String extractType(String fieldDeclaration){
        String [] parts = fieldDeclaration.split(" ");
        return parts[1];
    }
}
