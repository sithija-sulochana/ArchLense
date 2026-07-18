package org.example.archlense.analyzer;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import org.example.archlense.model.UMLClass;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class ClassAnalyzer {
    public UMLClass analyze(File file) throws Exception{
        CompilationUnit cu = StaticJavaParser.parse(file);
        ClassOrInterfaceDeclaration classDeclaration = cu.findFirst(ClassOrInterfaceDeclaration.class).get();

        UMLClass umlClass = new UMLClass(classDeclaration.getNameAsString());
        classDeclaration.getFields().forEach(field -> {
            umlClass.getFields().add(field.getVariables().get(0).getNameAsString());
        });
        classDeclaration.getMethods().forEach(method -> {
            umlClass.getMethods().add(method.getNameAsString());
        });
        return umlClass;
    }
}
