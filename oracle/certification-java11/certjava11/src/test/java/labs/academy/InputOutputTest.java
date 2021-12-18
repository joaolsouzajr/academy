package labs.academy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class InputOutputTest {

	static final String HOME_DIR_PATH = System.getProperty("user.home");
	static final String APP_DIR_PATH = System.getProperty("user.dir");
	static final String TEST_FILE_NAME = "test.txt";
	static final Charset UTF_8 = Charset.forName("UTF-8");
	
	@BeforeAll
	public static void setUp() {
		 //System.getProperties().list(System.out);	
		//create file on the root project folder
		File testTxt =  new File(TEST_FILE_NAME);
		testTxt.delete();
		try {
			if(testTxt.createNewFile()) {
				FileWriter fileWriter = new FileWriter(testTxt, UTF_8);
				fileWriter.write("a,b,c");
				fileWriter.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//System.out.println(testTxt.getAbsolutePath());
		//try(InputStream in = new FileInputStream("teste.txt"))
		
		assertTrue(true);
	}
	
	@Test
	public void readWriteBytes() {
		String testCopyTxt = "testCopy.txt"; 
		try(InputStream in = new FileInputStream(TEST_FILE_NAME);
				OutputStream out = new FileOutputStream(testCopyTxt)){
			byte [] buffer = new byte[1024];
			int lenght = 0;
			while ((lenght = in.read(buffer)) != -1) {
				out.write(buffer, 0, lenght);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			assertEquals("a,b,c", Files.readString(Path.of(testCopyTxt), UTF_8));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
}
