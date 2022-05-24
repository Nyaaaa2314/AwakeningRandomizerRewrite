import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Modifiers {
	
	
	
	public static void run() throws IOException {
		Random rng = new Random();
		int seed = rng.nextInt();
		FileSys f = FileSys.getInstance();
		ArrayList<ArrayList<String>> a = new ArrayList<ArrayList<String>>();
		for(int i = 0; i < 52; i++) {
			ArrayList<String> m = new ArrayList<String>();
			rng = new Random(seed + i);
			for(int j = 0; j < 7; j++) {
				if(j == 0 || j == 1) {
					int r = -1 * rng.nextInt(4);
					switch(r) {
					case -3:
						m.add("FD");
						break;
					case -2:
						m.add("FE");
						break;
					case -1:
						m.add("FF");
						break;
					default:
						m.add("00");
						break;
					}
				}
				else {
					int r = rng.nextInt(4);
					switch(r) {
					case 3:
						m.add("03");
						break;
					case 2:
						m.add("02");
						break;
					case 1:
						m.add("01");
						break;
					default:
						m.add("00");
						break;
					}
				}
			}
			Collections.shuffle(m);
			a.add(m);
		}
		//TODO add logging
		ArrayList<String> Static = f.getStatic();
		for(int i = 0, k = 16; i < 51; i++) {
			if(i == 2) {
				continue;
			}
			ArrayList<String> m = a.get(i);
			int index = k + 143 * i;
			Static.set(index, Static.get(index).substring(0, 4) + m.get(0) + m.get(1) + m.get(2));
			Static.set(index + 1, "0x" + m.get(3) + m.get(4) + m.get(6) + m.get(7));
		}
		f.setStatic(Static);
	}
	
	
}
