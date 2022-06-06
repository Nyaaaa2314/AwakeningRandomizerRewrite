
public class Class extends Data{
	//Just to keep Data cleaner all class data is stored here then passed to Data upon initialization
	
	private static boolean[] Promoted = { false, true, false, true, false, false, true, true, true, false, false, false, false, true, true, true, true, true, false, false, true, true, true, 
            false, true, true, false, true, true, false, false, false, false, true, true, true, true, true,  false, false, false, false };
        private static String[] wa = { "Sword", "Sword", "Tome", "Tome", "Lance", "Lance", "Sword", "Axe", "Lance", "Axe", "Axe", "Sword", "Bow", "Axe", "Axe", "Sword", "Bow", "Bow", "Sword", "Sword", "Sword", "Sword", "Sword", "Lance", "Lance", "Lance", "Axe", "Axe", "Axe", "Staff", "Staff", "Tome", "Tome", "Tome", "Axe", "Tome", "Tome", "Tome", "Sword", "Dragonstone", "Beaststone", "Lance" };
        private static String[] wb = { "none", "Lance", "Sword", "Sword", "Sword", "none", "Sword", "Lance", "Axe", "none", "none", "none", "none","none", "Bow", "Axe", "Sword", "none", "none", "none", 
            "none", "Bow", "Staff", "none", "Staff", "Tome", "none", "Lance", "none", "none", "none", "none", "none", "Staff", "Staff", "Staff", "Sword", "none", "none", "none", "none", "none" };
        private static String[] wc = { "none", "none", "none", "none", "none", "none", "none", "Sword", "none", "none", "none", "none", "none", "none", "none", "none", "none", "none", "none", "none", "none", "none", "none", "none", "none", "none", "none", "none", "none", "none", "none", "none", "none", "none", "none", "none", "none", "none", "none", "none", "none", "none" };
        private static String[] JID = { "JID_ロード", "JID_マスターロード", "JID_戦術師", "JID_神軍師", "JID_ソシアルナイト", "JID_アーマーナイト", "JID_パラディン", "JID_グレートナイト", "JID_ジェネラル", "JID_蛮族男", "JID_戦士男", "JID_傭兵", "JID_アーチャー", "JID_バーサーカー男",
                "JID_ウォーリアー男", "JID_勇者", "JID_ボウナイト", "JID_スナイパー", "JID_剣士", "JID_盗賊", "JID_ソードマスター", "JID_アサシン", "JID_トリックスター", "JID_ペガサスナイト女", "JID_ファルコンナイト女", "JID_ダークペガサス女", "JID_ドラゴンナイト", "JID_ドラゴンマスター", "JID_グリフォンナイト",
                "JID_トルバドール女", "", "JID_魔道士", "JID_ダークマージ", "JID_ヴァルキュリア女", "", "JID_賢者", "JID_ダークナイト", "JID_ソーサラー", "JID_踊り子女", "JID_マムクート女", "JID_ラグズ", "JID_村人男" };
        public static void setClassData() {
        	d = Data.getInstance();
        	d.wa = wa;
        	d.wb = wb;
        	d.wc = wc;
        	d.JID = JID;
        	d.Promoted = Promoted;
        }
}
