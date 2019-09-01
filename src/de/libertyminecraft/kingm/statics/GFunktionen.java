package de.libertyminecraft.kingm.statics;

public class GFunktionen {
	public static Integer getOnTimeH(String uuid) {
		return Main.Ph.get(uuid);
	}
	public static Integer getOnTimeM(String uuid) {
		return Main.Pmin.get(uuid);
	}
	public static Integer getBlockbreakc(String uuid) {
		return Main.Pbreak.get(uuid);
	}
	public static Integer getBlockset(String uuid) {
		return Main.Pbset.get(uuid);
	}
	public static Integer getDeathc(String uuid) {
		return Main.Pd.get(uuid);
		
		
	}
	public static void addDeathc(String uuid) {
		int temp = getDeathc(uuid);
		temp +=1;
		Main.Pd.put(uuid, temp);
		return;
	}
	public static void addBBrak(String uuid) {
		int temp = getBlockbreakc(uuid);
		temp +=1;
		Main.Pbreak.put(uuid, temp);
		return;
	}
	public static void addBSet(String uuid) {
		int temp = getBlockset(uuid);
		temp +=1;
		Main.Pbset.put(uuid, temp);
		return;
	}
	public static void addTime(String uuid) {
		int tempm= getOnTimeM(uuid);
		tempm +=1;
		if(tempm==60) {
			int temph= getOnTimeH(uuid);
			temph+=1;
			Main.Ph.put(uuid, temph);
			Main.Pmin.put(uuid, 0);
			}else {
				Main.Pmin.put(uuid, tempm);
			}
	}

}
