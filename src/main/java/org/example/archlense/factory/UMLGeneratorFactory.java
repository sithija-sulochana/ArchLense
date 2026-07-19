package org.example.archlense.factory;

import org.example.archlense.analyzer.ClassAnalyzer;
import org.example.archlense.analyzer.FileAnalyzer;
import org.example.archlense.analyzer.RelationShipAnalyzer;
import org.example.archlense.detectors.*;
import org.example.archlense.generator.PdfGenerator;
import org.example.archlense.generator.PlainUmlGenerator;
import org.example.archlense.generator.UMLCodeGenerator;
import org.example.archlense.service.UMLGenerator;

public class UMLGeneratorFactory {
   public RelationShipAnalyzer createRelationshipAnalyzer(){
       FileAnalyzer fileAnalyzer =
               new FileAnalyzer();

       ClassAnalyzer classAnalyzer =
               new ClassAnalyzer();


       AssociationDetector association =
               new AssociationDetector();

       InheritanceDetector inheritance =
               new InheritanceDetector();

       DependencyDetector dependency =
               new DependencyDetector();

       CompositionDetector composition =
               new CompositionDetector();

       ImplementationDetector implementation =
               new ImplementationDetector();

         return new RelationShipAnalyzer(association, inheritance, implementation, dependency, composition);
   }

    public static UMLGenerator createUMLGenerator(){


        FileAnalyzer fileAnalyzer =
                new FileAnalyzer();


        ClassAnalyzer classAnalyzer =
                new ClassAnalyzer();


        RelationShipAnalyzer relationshipAnalyzer =
                new RelationShipAnalyzer(
                        new AssociationDetector(),
                        new InheritanceDetector(),
                        new ImplementationDetector(),
                        new DependencyDetector(),
                        new CompositionDetector()
                );


        PlainUmlGenerator umlGenerator =
                new PlainUmlGenerator();


        PdfGenerator pdfGenerator =
                new PdfGenerator();


        UMLCodeGenerator codeGenerator =
                new UMLCodeGenerator();


        return new UMLGenerator(
                fileAnalyzer,
                umlGenerator,
                pdfGenerator,
                classAnalyzer,
                relationshipAnalyzer,
                codeGenerator
        );
    }
}
