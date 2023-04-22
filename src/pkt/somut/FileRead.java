package pkt.somut;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import pkt.soyut.IFileRead;

public class FileRead  implements IFileRead{

	@Override
	public String readFile(String fileName) {
		StringBuilder fileContent = new StringBuilder();
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			String line;
			while ((line = br.readLine()) != null) {
		fileContent.append(line).append("\n");
			//fileContent.append(line);
			}
			br.close();
		} catch (IOException e) {
			 throw new RuntimeException("Dosya okuma hatası: " + e.getMessage(), e);
		}
		return fileContent.toString();
	}
	
	
	

}
