package de.libertyminecraft.kingm.statics;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class Li_Death implements Listener{
	@EventHandler
	public void onDeath(PlayerDeathEvent e) {
		if(e.getEntity() instanceof Player) {
			String UUID = e.getEntity().getUniqueId().toString();
			GFunktionen.addDeathc(UUID);
		}
	}

}
