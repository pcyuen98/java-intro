package basic.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileLineByLineUsingBufferedReader {

	public static void main(String[] args) {
		  BufferedReader reader;

		  try {
		   reader = new BufferedReader(new FileReader("D:\\workspace\\java-intro\\src\\main\\java\\basic\\file\\sample.txt"));
		   String line = reader.readLine();

		   while (line != null) {
		    System.out.println(line);
		    // read next line
		    line = reader.readLine();
		   }

		   reader.close();
		  } catch (IOException e) {
		   e.printStackTrace();
		  }
		 }
}
