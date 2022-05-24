import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Scanner;

public class FileSys {
	
	private static FileSys f;
	String filepath;
	File sFile;
	File file;
	private ArrayList<String> Static;
	private FileSys(){
		Static = null;
		sFile = null;
	}
	
	public static FileSys getInstance() {
		if(f == null) {
			f = new FileSys();
		}
		return f;
	}
	public void closeStatic() throws IOException {
		Files.write(sFile.toPath(), Static, StandardOpenOption.TRUNCATE_EXISTING);
	}
	public void setStatic(ArrayList<String> Static){
		this.Static = Static;
	}
	public ArrayList<String> getStatic() throws IOException{
		if(Static == null) {
			Static = buildStatic();
			if(Static == null) {
				throw new IOException("Error reading static.txt");
			}
		}
		return Static;
	}
	private ArrayList<String> buildStatic() throws IOException{
		File tf = new File("romfs\\data\\person\\static.txt");
		if(tf.exists()) return Static;
		ArrayList<String> a = new ArrayList<String>();
		sFile = new File("romfs\\data\\person\\static.txt");
		a = (ArrayList<String>) Files.readAllLines(sFile.toPath());
		return a;
	}
	
	
	
}
