package org.example.archlense.shell;

import org.example.archlense.service.UMLGenerator;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
public class UmlCommands {
    private final UMLGenerator umlGenerator;

    public UmlCommands(UMLGenerator umlGenerator) {
        this.umlGenerator = umlGenerator;
    }

    @ShellMethod(value = "Generate UML diagram for a given package", key = "uml generate")
    public String generateUml(@ShellOption String path) throws Exception {
        umlGenerator.generate(path);
        return "UML diagram generated for package: " + path;
    }
}
