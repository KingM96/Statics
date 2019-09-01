package de.libertyminecraft.kingm.statics;

import java.sql.Connection;
import java.sql.SQLException;

public class MySQL {
	public static String host = Main.pl.getConfig().getString("MySQL.host");
	public static String port = Main.pl.getConfig().getString("MySQL.port");
	public static String database = Main.pl.getConfig().getString("MySQL.database");
	public static String username = Main.pl.getConfig().getString("MySQL.username");
	public static String password = Main.pl.getConfig().getString("MySQL.password");
	public static Connection con;
	public static void connect() {
		if (!isConnected()) {
			try {
				con = java.sql.DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database, username, password);
				System.out.println("[SQL] Verbunden!");
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static void disconnect() {
		if (isConnected()) {
			try {
				con.close();
				System.out.println("[SQL] Getrennt!");
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static boolean isConnected() {
		return con != null;
	}
	public static Connection getConnection() {
		return con;
	}
	
	/*public static void asyncConCepper(){
		Main.sqlceeperthread=Bukkit.getScheduler().scheduleAsyncRepeatingTask(Main.plugin, new Runnable() {
			
			@SuppressWarnings("unused")
			@Override
			public void run() {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
				     Timestamp time = new Timestamp(System.currentTimeMillis());
				     Main.tZeit = sdf.format(time);
				try {
					PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT playername FROM gamestats WHERE gameserver = ? ORDER BY points DESC LIMIT 3");
					     ps.setString(1, Main.servername);
					     ResultSet rs = ps.executeQuery();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
				
				
			}
		}, 120L, 120L);
	}*/
	
}
