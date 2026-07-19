package org.example.archlense.analyzer;

import org.springframework.stereotype.Component;
import org.w3c.dom.stylesheets.LinkStyle;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
@Component
public class FileAnalyzer {

    public List<File> scan(String path) {
        try {
            return Files.walk(Path.of(path))
                    .filter(Files::isRegularFile)
                    .filter(p -> p.toString().endsWith(".java"))
                    .map(Path::toFile)
                    .toList();

        } catch (Exception e) {
            e.printStackTrace();
            return List.of();
        }
    }
}
