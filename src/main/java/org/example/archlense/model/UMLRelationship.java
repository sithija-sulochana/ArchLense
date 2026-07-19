package org.example.archlense.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.checkerframework.checker.units.qual.C;
import org.example.archlense.enumerators.RelationshipType;
import org.example.archlense.util.RelationshipUtils;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Component
public class UMLRelationship {
    private String source;

    private String target;

    private RelationshipType type;

    @Override
    public String toString() {

        return source
                + " -- "
                + type
                + RelationshipUtils.generateRelationshipArrow(type)
                + target;
    }

}
