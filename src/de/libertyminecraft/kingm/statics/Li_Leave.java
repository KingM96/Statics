package de.libertyminecraft.kingm.statics;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class Li_Leave implements Listener {
	@EventHandler
	public void onLeave(PlayerQuitEvent e) {
		String uuid = e.getPlayer().getUniqueId().toString();
		try {
			PreparedStatement ps = MySQL.getConnection().prepareStatement("REPLACE INTO Statics (uuid,name,bp,bb,ph,pm,pde) VALUES (?,?,?,?,?,?,?)");
			ps.setString(1, uuid);
			ps.setString(2, e.getPlayer().getName());
			ps.setInt(3, GFunktionen.getBlockset(uuid));
			ps.setInt(4, GFunktionen.getBlockbreakc(uuid));
			ps.setInt(5, GFunktionen.getOnTimeH(uuid));
			ps.setInt(6, GFunktionen.getOnTimeM(uuid));
			ps.setInt(7, GFunktionen.getDeathc(uuid));
			ps.executeUpdate();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
