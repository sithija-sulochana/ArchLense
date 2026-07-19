package org.example.archlense.analyzer;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import org.example.archlense.model.UMLClass;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.Optional;

@Component
public class ClassAnalyzer {
    public UMLClass analyze(File file) throws Exception{
        CompilationUnit cu = StaticJavaParser.parse(file);
        Optional<ClassOrInterfaceDeclaration> optionalClass =
                cu.findFirst(ClassOrInterfaceDeclaration.class);

        if (optionalClass.isEmpty()) {
            return null;
        }

        ClassOrInterfaceDeclaration classDeclaration =
                optionalClass.get();

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
