package org.example.archlense.shell;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
public class UmlCommands {
    @ShellMethod(key = "hello", value = "Prints a personalized greeting.")
    public String sayHello(@ShellOption(defaultValue = "World") String name) {
        return "👋 Hello, " + name + "!";
    }
}
