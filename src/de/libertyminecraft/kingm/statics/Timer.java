package de.libertyminecraft.kingm.statics;

import org.bukkit.entity.Player;

public class Timer {
	public static void timer() {
		Main.pl.getServer().getScheduler().scheduleSyncRepeatingTask(Main.pl, new Runnable() {
		     public void run() {
		    	 if(Main.s == 60 ) {
		    		 Main.s =0;
		    		 for (Player p : Main.pl.getServer().getOnlinePlayers()) {
		    			 GFunktionen.addTime(p.getUniqueId().toString());
		    		 }
		    			
		    	 }else { 
		    		 Main.s += 1;
		    	 }
		    	 
		     }
		}, 140L, 20L);
	}
	
	

}
