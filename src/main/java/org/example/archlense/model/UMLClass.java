package org.example.archlense.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UMLClass {
    private String name;
    private List<String > fields = new ArrayList<>();
    private List<String> methods = new ArrayList<>();
    public UMLClass(String name) {
        this.name = name;
    }


}
