package org.example.archlense.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.checkerframework.checker.units.qual.C;
import org.example.archlense.enumerators.RelationshipType;
import org.example.archlense.util.RelationshipUtils;



public class UMLRelationship {
    private String source;

    private String target;

    private RelationshipType type;

    public UMLRelationship(String source, String target, RelationshipType type) {
        this.source = source;
        this.target = target;
        this.type = type;
    }

    @Override
    public String toString() {

        return source
                + " -- "
                + type
                + RelationshipUtils.generateRelationshipArrow(type)
                + target;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public RelationshipType getType() {
        return type;
    }

    public void setType(RelationshipType type) {
        this.type = type;
    }
}
