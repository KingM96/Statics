package de.libertyminecraft.kingm.statics;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class Li_BB implements Listener {
	@EventHandler
	public void onBp(BlockBreakEvent e ) {
		String puuid= e.getPlayer().getUniqueId().toString();
		GFunktionen.addBBrak(puuid);
		}
	

}
