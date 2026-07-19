package org.example.archlense.service;

import net.sourceforge.plantuml.SourceStringReader;
import net.sourceforge.plantuml.pdf.PdfConverter;
import org.example.archlense.analyzer.ClassAnalyzer;
import org.example.archlense.analyzer.FileAnalyzer;
import org.example.archlense.analyzer.RelationShipAnalyzer;
import org.example.archlense.generator.PdfGenerator;
import org.example.archlense.generator.PlainUmlGenerator;
import org.example.archlense.generator.UMLCodeGenerator;
import org.example.archlense.model.UMLClass;
import org.example.archlense.model.UMLRelationship;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

@Service

public class UMLGenerator {
    private final FileAnalyzer fileAnalyzer;
    private final PlainUmlGenerator generator;
    private final PdfGenerator pdfGenerator;
    private final ClassAnalyzer classAnalyzer;
    private final RelationShipAnalyzer relationshipAnalyzer;
    private final UMLCodeGenerator codeGenerator;

    public UMLGenerator(FileAnalyzer fileAnalyzer, PlainUmlGenerator generator, PdfGenerator pdfGenerator, ClassAnalyzer classAnalyzer, RelationShipAnalyzer relationShipAnalyzer, RelationShipAnalyzer relationshipAnalyzer, UMLCodeGenerator codeGenerator) {
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
            UMLClass umlClass = classAnalyzer.analyze(file);

            if(umlClass != null){
                System.out.println("Class found: " + umlClass.getName());
                classes.add(umlClass);


            }else{
                System.out.println("Class not found in file: " + file.getName());
            }
        }
        List<UMLRelationship> relationships = relationshipAnalyzer.analyze(classes);
        String uml = generator.generate(classes, relationships);
        pdfGenerator.printDiagram(uml);
        codeGenerator.saveUMLCode(uml);

    }


}
