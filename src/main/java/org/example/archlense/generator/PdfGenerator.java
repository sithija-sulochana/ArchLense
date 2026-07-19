package org.example.archlense.generator;

import net.sourceforge.plantuml.FileFormat;
import net.sourceforge.plantuml.FileFormatOption;
import net.sourceforge.plantuml.SourceStringReader;


import java.io.File;
import java.io.FileOutputStream;


public class PdfGenerator {

    public void printDiagram(String umlText) {

        SourceStringReader reader = new SourceStringReader(umlText);

        File file = new File("diagram.png");

        System.out.println("Saving diagram: " + file.getAbsolutePath());

        try (FileOutputStream output = new FileOutputStream(file)) {

            reader.outputImage(
                    output,
                    new FileFormatOption(FileFormat.PNG)
            );

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}