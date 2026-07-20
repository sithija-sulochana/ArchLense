package org.example.archlense.analyzer;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import org.example.archlense.model.UMLClass;
import org.example.archlense.model.UMLField;
import org.example.archlense.model.UMLMethod;


import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClassAnalyzer {
    public List<UMLClass> analyze(File file) throws Exception{
        CompilationUnit cu = StaticJavaParser.parse(file);

        List<UMLClass> result = new ArrayList<>();
        for (ClassOrInterfaceDeclaration declaration : cu.findAll(ClassOrInterfaceDeclaration.class)){

            UMLClass umlClass = new UMLClass(declaration.getNameAsString());

            declaration.getFields().forEach(field -> {
                String fieldName = field.getVariables().get(0).getNameAsString();
                String fieldType = field.getVariables().get(0).getType().asString();
                String visibility = getVisibility(field.getAccessSpecifier().asString());
                umlClass.getFields().add(new UMLField(fieldName, fieldType, visibility));
            });
            declaration.getMethods().forEach(method -> {
                List<String> parameters = new ArrayList<>();
                String methodName = method.getNameAsString();
                String returnType = method.getType().asString();
                String visibility = getVisibility(method.getAccessSpecifier().asString());
                method.getParameters().forEach(parameter -> {
                    parameters.add(parameter.getType().asString());
                });
                umlClass.getMethods().add(new UMLMethod(methodName, returnType, visibility,parameters));
            });

            declaration.getExtendedTypes()
                    .forEach(type -> {
                        umlClass.getParentClass().add(type.getNameAsString());
                    });
            result.add(umlClass);
        }
        return result;
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
