//package org.example.archlense.detectors;
//
//import org.example.archlense.enumerators.RelationshipType;
//import org.example.archlense.model.UMLClass;
//import org.example.archlense.model.UMLField;
//import org.example.archlense.model.UMLRelationship;
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//import java.util.stream.Collectors;
//
//@Component
//public class AggregationDetector {
//    public List<UMLRelationship> detect(List<UMLClass> classes) {
//        Set<UMLRelationship> results =
//                new HashSet<>();
//        Set<String> classNames =
//                classes.stream()
//                        .map(UMLClass::getName)
//                        .collect(Collectors.toSet());
//
//
//        for(UMLClass source : classes){
//
//            for(UMLField field : source.getFields()){
//
//
//                String type = field.getType();
//
//
//                if(classNames.contains(type)){
//                    results.add(
//                            new UMLRelationship(
//                                    source.getName(),
//                                    type,
//                                    RelationshipType.AGGREGATION
//                            )
//                    );
//
//                }
//
//            }
//
//        }
//
//
//        return new ArrayList<>(results);
//
//    }
//    }
//
