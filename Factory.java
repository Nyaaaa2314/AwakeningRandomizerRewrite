import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Factory { //named factory because this class uses the Factory design pattern
	public static boolean[] choice;
	
	
	
	public static void main(String[] args) throws IOException {
		
		boolean debug = true;
		
		if(debug) {
			Scanner s = new Scanner(new File("test.txt"));
			System.out.println(s.next());
		}
		//everything below will be used later
		choice = new boolean[7];
		Scanner in = new Scanner(System.in);
		System.out.println("Randomize character growths? (Y/N)");
		choice[0] = in.next().toLowerCase().charAt(0) == 'y' ? true : false;
		System.out.println("Randomize character join order? (Y/N)");
		choice[1] = in.next().toLowerCase().charAt(0) == 'y' ? true : false;
		System.out.println("Randomize class skills? (Y/N)");
		choice[2] = in.next().toLowerCase().charAt(0) == 'y' ? true : false;
		
		
		
		
		if(choice[0]) {
			Growths.run();
		}
		if(choice[1]) {
			
		}
	}
	
}
