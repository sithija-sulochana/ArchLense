package org.example.archlense.util;

import org.example.archlense.enumerators.RelationshipType;

public class RelationshipUtils {
    public static String generateRelationshipArrow(RelationshipType type) {
        String arrow = "";
        if(type == RelationshipType.ASSOCIATION) {
            arrow = "--";
        } else if(type == RelationshipType.INHERITANCE) {
            arrow = "--|>";
        } else if(type == RelationshipType.IMPLEMENTATION) {
            arrow = "..|>";
        } else if(type == RelationshipType.DEPENDENCY) {
            arrow = "..>";
        } else if(type == RelationshipType.COMPOSITION) {
            arrow = "*--";
        } else if(type == RelationshipType.AGGREGATION) {
            arrow = "o--";
        }
        return arrow;
    }
}
