package org.example.archlense.service;
import org.example.archlense.analyzer.ClassAnalyzer;
import org.example.archlense.analyzer.FileAnalyzer;
import org.example.archlense.analyzer.RelationShipAnalyzer;
import org.example.archlense.generator.PdfGenerator;
import org.example.archlense.generator.PlainUmlGenerator;
import org.example.archlense.generator.UMLCodeGenerator;
import org.example.archlense.model.UMLClass;
import org.example.archlense.model.UMLRelationship;


import java.io.File;
import java.util.ArrayList;
import java.util.List;



public class UMLGenerator {
    private final FileAnalyzer fileAnalyzer;
    private final PlainUmlGenerator generator;
    private final PdfGenerator pdfGenerator;
    private final ClassAnalyzer classAnalyzer;
    private final RelationShipAnalyzer relationshipAnalyzer;
    private final UMLCodeGenerator codeGenerator;

    public UMLGenerator(FileAnalyzer fileAnalyzer, PlainUmlGenerator generator, PdfGenerator pdfGenerator, ClassAnalyzer classAnalyzer, RelationShipAnalyzer relationshipAnalyzer, UMLCodeGenerator codeGenerator) {
        this.fileAnalyzer = fileAnalyzer;
        this.generator = generator;
        this.pdfGenerator = pdfGenerator;
        this.classAnalyzer = classAnalyzer;
        this.relationshipAnalyzer = relationshipAnalyzer;
        this.codeGenerator = codeGenerator;
    }


    public void generate(String path) throws Exception {
        List<File> files = fileAnalyzer.scan(path);
        List<UMLClass> classes = new ArrayList<>();
        System.out.println("Files found: " + files.size());
        for (File file : files) {
            List<UMLClass> umlClasses = classAnalyzer.analyze(file);

            if(!umlClasses.isEmpty()){
                classes.addAll(umlClasses);
                for (UMLClass umlClass : umlClasses) {
                    System.out.println("Class found: " + umlClass.getName());
                }
            }else {
                System.out.println("No classes found in file: " + file.getName());
            }

        }
        System.out.println("Classes found: " + classes.size());
        List<UMLRelationship> relationships = relationshipAnalyzer.analyze(classes);
        String uml = generator.generate(classes, relationships);
        pdfGenerator.printDiagram(uml);
        codeGenerator.saveUMLCode(uml);

    }


}
