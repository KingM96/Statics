package de.libertyminecraft.kingm.statics;

import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

public class Scb {
	 public static void createScoreboard(Player player)
	 {
		 String uuid = player.getUniqueId().toString();
	 ScoreboardManager sm = player.getServer().getScoreboardManager();
	 Scoreboard board = sm.getNewScoreboard();
	 Objective score = board.registerNewObjective("aaa", "bbb", "Stats");
	 score.setDisplayName("§6Stats");
	 score.setDisplaySlot(org.bukkit.scoreboard.DisplaySlot.SIDEBAR);
	  
	 Score punkte = score.getScore("§e" + GFunktionen.getOnTimeH(uuid) + "§a Online Zeit§6");
	 Score kd = score.getScore("§e" + GFunktionen.getDeathc(uuid)+ " §a Tode");
	 Score lz1=score.getScore("                ");
	 Score lz2=score.getScore("");
	 Score ranking =score.getScore("§e"+GFunktionen.getBlockbreakc(uuid) +"§aAbgebaut");
	 Score p1=score.getScore("§e"+GFunktionen.getBlockset(uuid) +"§aGesetzt");


	 kd.setScore(7);
	 punkte.setScore(6);
	 lz1.setScore(5);
	 lz2.setScore(4);
	 ranking.setScore(3);
	 p1.setScore(2);

	 player.setScoreboard(board);
	 }
	 


}
