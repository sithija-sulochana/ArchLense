package org.example.archlense.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.archlense.enumerators.RelationshipType;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UMLRelationship {
    private String source;

    private String target;

    private RelationshipType type;

    @Override
    public String toString() {

        return source
                + " -- "
                + type
                + " --> "
                + target;
    }

}
