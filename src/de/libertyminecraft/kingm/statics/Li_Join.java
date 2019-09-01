package de.libertyminecraft.kingm.statics;

import java.io.File;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class Li_Join implements Listener {
	private static File file = new File("plugins/"+Main.pl.getName(), "config.yml");
	   public static FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
	public static void getPlayerstats(String uuid) {
		try {
			PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT bp, bb, ph, pm, pde FROM Statics WHERE uuid = ?");
			ps.setString(1, uuid);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Main.Pbreak.put(uuid, rs.getInt("bb"));
				Main.Pbset.put(uuid, rs.getInt("bp"));
				Main.Ph.put(uuid, rs.getInt("ph"));
				Main.Pmin.put(uuid, rs.getInt("pm"));
				Main.Pd.put(uuid, rs.getInt("pde"));

			}
		
		}catch (SQLException ee)
		{
			

			}
	}
	public static boolean enteredInStats(String uuid) {
		if(Main.pl.getConfig().getInt("joinlist."+uuid)== 1) {
			return true;
		}else {
			Main.pl.getConfig().set("joinlist."+uuid,1);
			try {
				Main.pl.getConfig().save(file);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			return false;
		}
			
	}
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player player = (Player) e.getPlayer();
		String tuuid = player.getUniqueId().toString();
		if(enteredInStats(tuuid)) {
			getPlayerstats(tuuid);
		}else {
			
			try {
				PreparedStatement ps = MySQL.getConnection().prepareStatement("INSERT OR REPLACE INTO Statics (uuid,bp,bb,ph,pm,pde) VALUES (?,?,?,?,?,?)");
				ps.setString(1, tuuid);
				ps.setInt(2, 0);
				ps.setInt(3, 0);
				ps.setInt(4, 0);
				ps.setInt(5, 0);
				ps.setInt(6, 0);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			getPlayerstats(tuuid);

		}
	
		Scb.createScoreboard(e.getPlayer());	
	}		
}	
	


