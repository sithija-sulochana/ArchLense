package org.example.archlense.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UMLField{
    private String name;

    private String type;

    private String visibility;

    @Override
    public String toString() {
        return visibility + " "
                + name
                + " : "
                + type;
    }
}
