package org.example.archlense.generator;

import net.sourceforge.plantuml.FileFormat;
import net.sourceforge.plantuml.FileFormatOption;
import net.sourceforge.plantuml.SourceStringReader;
import org.springframework.stereotype.Component;

import java.io.FileOutputStream;
@Component
public class PdfGenerator {
    public static void printDiagram(String umlText){
        SourceStringReader reader = new SourceStringReader(umlText);
        try {
            reader.outputImage(
                    new FileOutputStream(
                            "diagram.pdf"
                    ),
                    new FileFormatOption(
                            FileFormat.PDF
                    )
            );
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
