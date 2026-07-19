package org.example.archlense.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Component
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
