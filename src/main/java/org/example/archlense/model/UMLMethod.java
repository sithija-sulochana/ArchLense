package org.example.archlense.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class UMLMethod {
    private String name;
    private String returnType;
    private String visibility;
    private List<String> parameter = new ArrayList<>();

}

