package de.libertyminecraft.kingm.statics;

import java.io.File;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;


public class Main extends JavaPlugin {
	public static Main pl;
	public static HashMap<String, Integer> Pmin = new HashMap<String, Integer>();
	public static HashMap<String, Integer> Ph = new HashMap<String, Integer>();
	public static HashMap<String, Integer> Pbset = new HashMap<String, Integer>();
	public static HashMap<String, Integer> Pbreak = new HashMap<String, Integer>();
	public static HashMap<String, Integer> Pd = new HashMap<String, Integer>();
	public static int s = 0;
	public static int sqlceeperthread;
	public FileConfiguration config;
	@Override
	public void onEnable() {
		loadConfig();

     	this.getServer().getPluginManager().registerEvents(new Li_BB(), this);
     	this.getServer().getPluginManager().registerEvents(new Li_Bp(), this);
     	this.getServer().getPluginManager().registerEvents(new Li_Death(), this);
     	this.getServer().getPluginManager().registerEvents(new Li_Join(), this);
     	this.getServer().getPluginManager().registerEvents(new Li_Leave(), this);
     	pl=this;
     	this.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
			
			@Override
			public void run() {
				MySQL.connect();
			     try {
					PreparedStatement ps = MySQL.getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS Statics (uuid VARCHAR(64) NOT NULL , bp INT NOT NULL , bb INT NOT NULL, ph INT NOT NULL , pm INT NOT NULL , pde INT NOT NULL , PRIMARY KEY (uuid))");
					ps.executeUpdate();
					} catch (SQLException e1) {

					System.out.println(pl.getName()+"Keine verbindung zum Mysql Server plugin wird gestoppt!");
					}
				
			}
		},40L);
		
     
     	this.getServer().getPluginManager().registerEvents(new Li_BB(), this);
     	this.getServer().getPluginManager().registerEvents(new Li_Bp(), this);
     	this.getServer().getPluginManager().registerEvents(new Li_Death(), this);
     	this.getServer().getPluginManager().registerEvents(new Li_Join(), this);
     	this.getServer().getPluginManager().registerEvents(new Li_Leave(), this);
     	Timer.timer();
		System.out.println(this.getName()+" Geladen");
		

	}
	
	@Override
	public void onDisable() {
		for (Player p : Main.pl.getServer().getOnlinePlayers()) {
			String uuid = p.getUniqueId().toString();
			try {
				PreparedStatement ps = MySQL.getConnection().prepareStatement("INSERT OR REPLACE INTO Statics (uuid,bp,bb,ph,pm,pde) VALUES (?,?,?,?,?,?)");
				ps.setString(1, uuid);
				ps.setInt(2, GFunktionen.getBlockset(uuid));
				ps.setInt(3, GFunktionen.getBlockbreakc(uuid));
				ps.setInt(4, GFunktionen.getOnTimeH(uuid));
				ps.setInt(5, GFunktionen.getOnTimeM(uuid));
				ps.setInt(6, GFunktionen.getDeathc(uuid));
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		System.out.println(this.getName()+" GeStoppt");
	}

	public void loadConfig()
	   {
	     this.config = getConfig();
	     this.config.options().copyDefaults(true);
	     if (new File("plugins/Statics/config.yml").exists()) {
	    	 System.out.println(this.getName() + "config.yml geladen.");
	     		} else {
	     			saveDefaultConfig();
       System.out.println(this.getName() + "config.yml erstellt und geladen.");
     }
   }

}
