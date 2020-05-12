package fr.lightmute.StelyOutils;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class App extends JavaPlugin implements Listener{

	String prefix = "§7[§cStelyWarning§7] §c";
	HashMap<String, Boolean> playerspam = new HashMap<String, Boolean>();

	public void onEnable() {
		Bukkit.getPluginManager().registerEvents(this, this);
	}
	public void onDisable() {

	}

	@SuppressWarnings("deprecation")
	@EventHandler
	public void getoutilsdurab(PlayerInteractEvent e) {
		Player player = e.getPlayer();
		
		if(10 < Integer.valueOf(player.getItemInHand().getDurability()) && 5 > Integer.valueOf(player.getItemInHand().getDurability())) {
				player.sendActionBar(prefix + player.getItemInHand().getItemMeta().getDisplayName() + " est faible !");
		}
	}
}
