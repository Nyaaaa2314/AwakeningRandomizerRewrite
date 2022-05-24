import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Growths {
	public static Data d;
	public static FileSys f;
	public static void run() throws IOException {
		String[] LT = { "59", "89", "D2", "D1", "DE", "C6", "47", "21", "BA", "DB", "C5", "EC", "35", "BD", "9F", "9B",
				"2D", "7B", "B2", "09", "F7", "53", "99", "8F", "C4", "90", "FA", "34", "F8", "19", "94", "02", "ED",
				"56", "40", "6C", "F4", "88", "4F", "2B", "B4", "BB", "EB", "74", "B7", "0D", "C2", "A4", "EE", "93",
				"CF", "42", "F1", "17", "BF", "F0", "A5", "BC", "0F", "6E", "1B", "73", "8D", "A6", "3B", "50", "33",
				"E0", "AF", "9D", "DD", "FF", "FE", "AA", "CE", "12", "62", "E2", "FB", "C1", "23", "49", "D6", "CD",
				"04", "2F", "41", "15", "1A", "32", "03", "8A", "14", "58", "0A", "A3", "D0", "71", "7D", "D3", "A0",
				"52", "BE", "D7", "8B", "48", "37", "13", "A8", "44", "08", "3C", "E3", "63", "F6", "DF", "16", "7C",
				"46", "F3", "07", "CC", "79", "C3", "6B", "3F", "81", "00", "20", "28", "AE", "EF", "6D", "8E", "0E",
				"1D", "4B", "95", "A1", "B6", "D4", "C7", "3E", "E5", "D8", "5A", "43", "26", "7A", "E4", "4E", "9C",
				"30", "4C", "C8", "97", "FD", "54", "68", "C0", "FC", "36", "1C", "75", "01", "96", "E9", "1F", "45",
				"06", "70", "2C", "29", "67", "2E", "F5", "9E", "92", "60", "3D", "E8", "E7", "66", "2A", "91", "EA",
				"57", "A9", "1E", "5F", "27", "51", "C9", "65", "18", "AB", "83", "D5", "85", "61", "0C", "77", "7E",
				"F9", "7F", "5E", "DC", "84", "5C", "6A", "39", "4D", "87", "5B", "DA", "69", "E6", "5D", "11", "82",
				"10", "55", "D9", "CB", "8C", "72", "86", "6F", "64", "80", "CA", "A2", "05", "AC", "4A", "B1", "0B",
				"38", "E1", "AD", "31", "B3", "98", "78", "B8", "22", "76", "9A", "24", "A7", "25", "B5", "F2", "B9",
				"B0", "3A" };
		ArrayList<String> LOOKUP_TABLE = new ArrayList<String>(Arrays.asList(LT));
		f = FileSys.getInstance();
		d = Data.getInstance();
		Random rnd = new Random();
		boolean zero = false; //TODO: actually check for zero growths
		int seed = rnd.nextInt(263263263);
		// int[] Growths = new int[8];
		String[] HexG = new String[8];
		// int[] GRlog = new int[8];
		String[] GRLog = new String[8 * 52];
		String[][] Growths = new String[52][8];
		for (int i = 0; i < 52; i++) {
			int seed2 = seed;
			while (seed2 == seed) {
				seed = rnd.nextInt(263263263);
			}
			int ID = i;
			int GR = 0;
			String GRHex = "";
			int index = 0;
			for (int j = 0; j < 8; j++) {
				Random rng = new Random(i + j + seed); // This keeps the randomization from being the same across the
													   // stats by forcing a new seed for every character and stat.
				switch (j) {
				case 0:
					GR = 35 + rng.nextInt(15);
					break;
				case 3:
					GR = 30 + rng.nextInt(20);
					break;
				case 4:
					GR = 30 + rng.nextInt(20);
					break;
				case 5:
					GR = 30 + rng.nextInt(40);
					break;
				default:
					GR = 10 + rng.nextInt(40);
					break;
				}
				GRHex = Integer.toHexString(GR).toUpperCase();
				if (GRHex.length() == 1) {
					GRHex = "0" + GRHex;
				}
				if(zero) {
					GRHex = "00";
				}
				//GRHex = Integer.toHexString(GR);
				index = LOOKUP_TABLE.indexOf(GRHex);
				//System.out.println(index);
				//Cringe af equation to encipher growths
				Growths[i][j] = Integer.toHexString(((index + (99 * ((ID ^ 167) - (33 * j)) ^ 217)) & 0xFF)).toUpperCase();
				if(Growths[i][j].length() == 1) {
					Growths[i][j] = "0" + Growths[i][j];
				}
				//System.out.println(Growths[i][j]);

			}

		}
		
		ArrayList<String> log = new ArrayList<String>();
		//code to write to log
		log.add("Growth log");
		for(int i = 0; i < 51; i++) {
			if(i == 0) {
				log.add("M!Robin");
			}
			else if(i == 1) {
				log.add("F!Robin");
			}
			else if(i == 2) {
				continue;
			}
			else {
				log.add(d.CharacterNames[i - 3]);
			}
			for(int j = 0; j < 8; j++) {
				//TODO Make this log print actual growth values and not the hex as int.
				switch(j) {
				case 0:
					log.add("HP: " + Integer.parseUnsignedInt(Growths[i][j], 16));
					break;
				case 1:
					log.add("Str: " + Integer.parseUnsignedInt(Growths[i][j], 16));
					break;
				case 2:
					log.add("Mag: " + Integer.parseUnsignedInt(Growths[i][j], 16));
					break;
				case 3:
					log.add("Spd: " + Integer.parseUnsignedInt(Growths[i][j], 16));
					break;
				case 4:
					log.add("Skl: " + Integer.parseUnsignedInt(Growths[i][j], 16));
					break;
				case 5:
					log.add("Lck: " + Integer.parseUnsignedInt(Growths[i][j], 16));
					break;
				case 6:
					log.add("Def: " + Integer.parseUnsignedInt(Growths[i][j], 16));
					break;
				case 7:
					log.add("Res: " + Integer.parseUnsignedInt(Growths[i][j], 16));
					break;
				}
			}
		}
		d.addLog(log);
		ArrayList<String> Static = f.getStatic();
		for(int i = 0, k = 12; i < 51; i++) {
			if(i == 2) {
				continue;
			}
			Static.set(k + (143 * i), "0x" + Growths[i][0] + Growths[i][1] + Growths[i][2] + Growths[i][3]);
			Static.set(k + (143 * i) + 1, "0x" + Growths[i][4] + Growths[i][5] + Growths[i][6] + Growths[i][7]);
		}
		f.setStatic(Static);
		try {
			f.closeStatic();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
