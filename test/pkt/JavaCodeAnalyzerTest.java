/** *
* @author Kader Oral kadriye.oral@ogr.sakarya.edu.tr
* @since 20.04.2023
* <p>
* yazdırma işleminin yapıldığı sınıfın testi 
* </p> */
package pkt;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pkt.somut.*;
import pkt.soyut.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@ExtendWith(MockitoExtension.class)
public class JavaCodeAnalyzerTest {
	String sampleJavaContent;
    @Mock
    private IFileRead fileReader;

    @InjectMocks
    private JavaCodeAnalyzer javaCodeAnalyzer;
    @BeforeEach
    public void setUp() {
        // Örnek Java dosya içeriği
    	 sampleJavaContent = "public class Example {\n" +
                            "    public static void main(String[] args) {\n" +
                            "        int a = 5;\n" +
                            "        int b = a + 3;\n" +
                            "        if (b > 5) {\n" +
                            "            System.out.println(\"Bigger than 5\");\n" +
                            "        } else {\n" +
                            "            System.out.println(\"Equal to or smaller than 5\");\n" +
                            "        }\n" +
                            "    }\n" +
                            "}";
    }

    @Test
    public void testIntegration() throws IOException {
        // Örnek Java dosya içeriği
        

        // Sahte bir dosya oluşturma ve içine sampleJavaContent yazma
        Path tempFile = Files.createTempFile("Test", ".java");
        Files.writeString(tempFile, sampleJavaContent);

        // Dosya okuma işlemini simüle etme
        when(fileReader.readFile(anyString())).thenReturn(Files.readString(tempFile));

        // JavaCodeAnalyzer sınıfının sonuçlarını al
        javaCodeAnalyzer.getResult(sampleJavaContent.toString());

        // Operatör sayılarını kontrol et
      
        Files.delete(tempFile);
    }
}
