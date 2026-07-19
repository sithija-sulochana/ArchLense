package org.example.archlense.analyzer;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import org.example.archlense.model.UMLClass;
import org.example.archlense.model.UMLField;
import org.example.archlense.model.UMLMethod;
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
            String fieldName = field.getVariables().get(0).getNameAsString();
            String fieldType = field.getElementType().asString();
            String visibility = getVisibility(field.getAccessSpecifier().asString());
            umlClass.getFields().add(new UMLField(fieldName, fieldType, visibility));
        });
        classDeclaration.getMethods().forEach(method -> {
            String methodName = method.getNameAsString();
            String returnType = method.getType().asString();
            String visibility = getVisibility(method.getAccessSpecifier().asString());
            umlClass.getMethods().add(new UMLMethod(methodName, returnType, visibility));
        });
        return umlClass;
    }
    private String getVisibility(String modifier){

        if(modifier.equals("public")){
            return "+";
        }else if(modifier.equals("private")){
            return "-";
        }else if(modifier.equals("protected")){
            return "#";
        }else{
            return "~";
        }

    }
}
