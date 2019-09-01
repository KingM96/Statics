package de.libertyminecraft.kingm.statics;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class Li_Bp implements Listener {
	@EventHandler
	public void onBp(BlockPlaceEvent e ) {
		String puuid= e.getPlayer().getUniqueId().toString();
		GFunktionen.addBSet(puuid);
		}
	

}
