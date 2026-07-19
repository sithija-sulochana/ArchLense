package org.example.archlense.shell;

import org.example.archlense.factory.UMLGeneratorFactory;
import org.example.archlense.service.UMLGenerator;


public class UmlCommands {

    public static void main(String[] args) throws Exception {
        if(args.length ==0){
            System.out.println("Please provide a path to generate UML diagram.");
            return;
        }
        UMLGenerator umlGenerator = UMLGeneratorFactory.createUMLGenerator();
        umlGenerator.generate(args[0]);




    }
}
