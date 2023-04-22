package pkt;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import pkt.somut.FileRead;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class FileReadTest {

    private FileRead fileRead;
    
    @TempDir
    Path tempDir;

    @BeforeEach
    public void setUp() {
        fileRead = new FileRead();
    }

	/*
	 * Bu testin amacı, FileRead sınıfının readFile metodunun verilen dosya
	 * adından başarılı bir şekilde dosya okuyup doğru içeriği döndürdüğünü
	 * doğrulamaktır. Test sırasında, örnek bir dosya oluşturulur ve içeriği
	 * yazılır. Ardından, readFile metodunu çağırarak dosyanın içeriğini okur ve
	 * döndürdüğü değeri beklenen değerle karşılaştırır.
	 */    @Test
    public void testReadFile() throws IOException {
        Path tempFile = tempDir.resolve("deneme.txt");
        try (BufferedWriter writer = Files.newBufferedWriter(tempFile)) {
            writer.write("Hello, World!");
            writer.write("This is a test.");
        }
        String fileContent = fileRead.readFile(tempFile.toString());
        assertEquals("Hello, World!This is a test.\n", fileContent);
    }
	// bu test hataların düzgün bir şekilde yönetimini sağlar.

	 @Test
	 public void testReadNonExistentFile() {
	     String fileName = "nonexistent.txt";
	     RuntimeException exception = assertThrows(RuntimeException.class, () -> fileRead.readFile(fileName));
	     assertTrue(exception.getMessage().startsWith("Dosya okuma hatası: nonexistent.txt ("));
	 }

	

}
