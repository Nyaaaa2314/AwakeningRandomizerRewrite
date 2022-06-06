import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

public class Data {
	
	protected static Data d;
	public String[] Skills;
	public String[] SkillsD;
	public String[] Classes;
	public String[] ClassesD;
	public String[] CharacterNames;
	public String[] CharacterR;
	public String[] cAdults;
	public String[] cChildren;
	public String[] wa;
	public String[] wb;
	public String[] wc;
	public String[] JID;
	public boolean[] Promoted;
	private ArrayList<ArrayList<String>> Logs;
	public Data() {
		String[] CharacterNames = { "Chrom", "Lissa", "Frederick", "Virion", "Sully", "Vaike", "Stahl", "Miriel", "Kellam", "Sumia", "Lon'qu", "Ricken", "Maribelle", "Panne", "Gaius", "Cordelia", "Gregor", "Nowi", "Libra", "Tharja", "Olivia", "Cherche", "Henry", "Lucina", "Say'ri", "Basilio", "Flavia", "Donnel", "Anna", "Owain", "Inigo", "Brady", "Kjelle", "Cynthia", "Severa", "Gerome", "M!Morgan", "F!Morgan", "Yarne", "Laurent", "Noire", "Nah", "Tiki", "Gangrel", "Walhart", "Emmeryn", "Yen'fay", "Aversa", "Priam" };
		this.CharacterNames = CharacterNames;
		String[] Skills = {"01", "02", "03", "04", "05", "06", "07", "09", "0A", "0B", "0C", "0D", "0E", "0F", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "1A", "1B", "1C", "1D", "1E", "1F", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "2A", "2B", "2C", "2D", "2E", "2F", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "3A", "3B", "3C", "3D", "3E", "3F", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "4A", "4B", "4C", "4D", "4E", "4F", "50", "51", "52", "53", "54", "55", "56", "57"};
		this.Skills = Skills;
        String[] SkillsD = {"01", "02", "03", "04", "05", "06", "07", "09", "0A", "0B", "0C", "0D", "0E", "0F", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "1A", "1B", "1C", "1D", "1E", "1F", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "2A", "2B", "2C", "2D", "2E", "2F", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "3A", "3B", "3C", "3D", "3E", "3F", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "4A", "4B", "4C", "4D", "4E", "4F", "50", "51", "52", "53", "54", "55", "56", "57", "63", "64", "65", "66"};
        this.SkillsD = SkillsD;
        String[] Classes = { "Lord", "Great Lord", "Tactician", "Grandmaster", "Cavalier", "Knight", "Paladin", "Great Knight", "General", "Barbarian", "Fighter", "Mercenary", "Archer", "Berserker", "Warrior", "Hero", "Bow Knight", "Sniper", "Myrmidon", "Thief", "Swordmaster", "Assassin", "Trickster", "Pegasus Knight", "Falcon Knight", "Dark Flier", "Wyvern Rider", "Wyvern Lord", "Griffon Rider", "Troubadour", "Priest/Cleric", "Mage", "Dark Mage", "Valkyrie", "War Monk/ War Cleric", "Sage", "Dark Knight", "Sorcerer", "Dancer", "Manakete", "Taguel", "Villager" };
        this.Classes = Classes;
        String[] ClassesD = { "Lord", "Great Lord", "Tactician", "Grandmaster", "Cavalier", "Knight", "Paladin", "Great Knight", "General", "Barbarian", "Fighter", "Mercenary", "Archer", "Berserker", "Warrior", "Hero", "Bow Knight", "Sniper", "Myrmidon", "Thief", "Swordmaster", "Assassin", "Trickster", "Pegasus Knight", "Falcon Knight", "Dark Flier", "Wyvern Rider", "Wyvern Lord", "Griffon Rider", "Troubadour", "Priest/Cleric", "Mage", "Dark Mage", "Valkyrie", "War Monk/ War Cleric", "Sage", "Dark Knight", "Sorcerer", "Dancer", "Manakete", "Taguel", "Villager", "Dread Fighter", "Bride"};
        this.ClassesD = ClassesD;
        String[] cAdults = { "Chrom", "Lissa", "Frederick", "Virion", "Sully", "Vaike", "Stahl", "Miriel", "Kellam", "Sumia", "Lon'qu", "Ricken", "Maribelle", "Panne", "Gaius", "Cordelia", "Gregor", "Nowi", "Libra", "Tharja", "Olivia", "Cherche", "Henry", "Say'ri", "Basilio", "Flavia", "Donnel", "Anna", "Tiki", "Gangrel", "Walhart", "Emmeryn", "Yen'fay", "Aversa", "Priam"};
        this.cAdults = cAdults;
        String[] cChildren = { "Lucina", "Owain", "Inigo", "Brady", "Kjelle", "Cynthia", "Severa", "Gerome", "M!Morgan", "F!Morgan", "Yarne", "Laurent", "Noire", "Nah"};
        this.cChildren = cChildren;
        Logs = new ArrayList<ArrayList<String>>();
        randomizeChar();
        Class.setClassData();
	}
	public static Data getInstance() {
		if(d == null) {
			d = new Data();
		}
		return d;
	}
	private void randomizeChar() {
		
		ArrayList<String> a = (ArrayList<String>) Arrays.asList(cAdults);
		ArrayList<String> c = (ArrayList<String>) Arrays.asList(cChildren);
		//Collections.addAll(a, cAdults);
		//Collections.addAll(c, cChildren);
		Collections.shuffle(a);
		Collections.shuffle(c);	
		CharacterR = new String[CharacterNames.length];
		for(int i = 0, j = 0; i < CharacterR.length; i++) {
			if(i == 23) {
				CharacterR[i] = c.get(0);
			}
			else if(i == 29) {
				for(int k = 1; k < c.size(); k++, i++) {
					CharacterR[i] = c.get(k);
				}
			}
			else {
				CharacterR[i] = a.get(j++);
			}
		}
	}
	public ArrayList<String> getLogs(){
		return Logs.get(0);
	}
	public void addLog(ArrayList<String> s) {
		Logs.add(s);
	}
}
