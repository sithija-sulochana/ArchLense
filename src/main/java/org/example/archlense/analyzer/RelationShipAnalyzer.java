package org.example.archlense.analyzer;

import org.example.archlense.detectors.*;
import org.example.archlense.enumerators.RelationshipType;
import org.example.archlense.model.UMLClass;
import org.example.archlense.model.UMLRelationship;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RelationShipAnalyzer {
    private final AssociationDetector association;
    private final InheritanceDetector inheritance;
    private final ImplementationDetector implementation;
    private final DependencyDetector dependency;
    private final CompositionDetector composition;
    private final AggregationDetector aggregation;

    public RelationShipAnalyzer(AssociationDetector association, InheritanceDetector inheritance, ImplementationDetector implementation, DependencyDetector dependency, CompositionDetector composition, AggregationDetector aggregation) {
        this.association = association;
        this.inheritance = inheritance;
        this.implementation = implementation;
        this.dependency = dependency;
        this.composition = composition;
        this.aggregation = aggregation;
    }

    public List<UMLRelationship> analyze(List<UMLClass> classes){
        List<UMLRelationship> result = new ArrayList<>();

        result.addAll(association.detect(classes));
        result.addAll(inheritance.detect(classes));
        result.addAll(implementation.detect(classes));
        result.addAll(dependency.detect(classes));
        result.addAll(composition.detect(classes));
        result.addAll(aggregation.detect(classes));
        return result;

    }


}
