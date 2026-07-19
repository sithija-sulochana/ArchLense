package org.example.archlense.generator;

import net.sourceforge.plantuml.SourceStringReader;
import org.springframework.stereotype.Component;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class UMLCodeGenerator {
    public void saveUMLCode(String umlText){

        try{
            Files.write(Paths.get("diagram.puml"), umlText.getBytes(StandardCharsets.UTF_8));
            System.out.println("UML code saved to diagram.puml");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
