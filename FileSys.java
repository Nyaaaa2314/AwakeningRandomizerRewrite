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
	//String filepath;
	File sFile;
	File file;
	private ArrayList<String> Static;
	private ArrayList<String> curChapter;
	private String chap;
	private FileSys(){
		Static = null;
		sFile = null;
		chap = "";
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
	public ArrayList<String> getChapter(String chapter) throws IOException{
		if(chapter.equals(chap)) {
			return curChapter;
		}
		curChapter = buildChapter(chapter);
		
		return curChapter;
		
	}
	public void closeChapter(String chapter) throws IOException {
		Files.write(new File(chapter + ".exl").toPath(), curChapter, StandardOpenOption.TRUNCATE_EXISTING);
	}
	private ArrayList<String> buildChapter(String chapter) throws IOException{
		File tf = new File("romfs\\scripts\\" + chapter);
		ArrayList<String> a = new ArrayList<String>();
		a = (ArrayList<String>) Files.readAllLines(tf.toPath());
		return a;
	}
	private ArrayList<String> buildStatic() throws IOException{
		File tf = new File("romfs\\data\\person\\static.txt");
		//if(tf.exists()) return Static;
		ArrayList<String> a = new ArrayList<String>();
		sFile = new File("romfs\\data\\person\\static.txt");
		a = (ArrayList<String>) Files.readAllLines(sFile.toPath());
		return a;
	}
	public void cleanUp() {
		
		//deletes any Terrain .exl file as they're all unnecessary and i cant delete them with the batch file
		File dir = new File(System.getProperty("user.dir"));
		File[] directoryListing = dir.listFiles();

		for (File child : directoryListing) {
			if(child.getName().contains("Terrain")) {
				child.delete();
			}
		}
		
		
		

		
		
	}
	//private openChapter
	
	
	
}
