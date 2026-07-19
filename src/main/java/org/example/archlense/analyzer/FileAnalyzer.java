package org.example.archlense.analyzer;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

import java.util.List;

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
