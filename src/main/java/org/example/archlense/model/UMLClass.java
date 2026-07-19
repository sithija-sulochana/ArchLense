package org.example.archlense.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.expression.spel.ast.Literal;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Component
public class UMLClass {
    private String name;
    private List<UMLField > fields = new ArrayList<>();
    private List<UMLMethod> methods = new ArrayList<>();
    private List<String> interfaces = new ArrayList<>();
    private List<String> parentClass = new ArrayList<>();
    private List<String> dependencies = new ArrayList<>();
    private List<String> createdObjects = new ArrayList<>();
    public UMLClass(String name) {
        this.name = name;
    }


}
