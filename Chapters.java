import java.io.File;

public class Chapters {
	public static Data d;
	public static FileSys f;
	public static void run() {
		f = FileSys.getInstance();
		d = Data.getInstance();
		
		File dir = new File(System.getProperty("user.dir"));
		File[] directoryListing = dir.listFiles();

		for (File child : directoryListing) {
			if(child.getName().contains(".exl")) {
				//TODO: code to replace all instances of char[i] with rchar[i]
				//reminder: use Scanner and the str.replaceAll() ez
				
				
				
				
				
				
			}
		}
		
		
		
		
		
	}
}
