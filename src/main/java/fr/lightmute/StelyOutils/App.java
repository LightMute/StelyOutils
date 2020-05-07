package fr.lightmute.StelyOutils;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
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

		if(!playerspam.containsKey(player.getName())) {
			playerspam.put(player.getName(), true);
		}

		if(Integer.valueOf(player.getItemInHand().getDurability()) <= 0) {
			playerspam.replace(player.getName(), true);
		}
		
		if((Integer.valueOf(player.getItemInHand().getType().getMaxDurability())/ 4) < Integer.valueOf(player.getItemInHand().getDurability()) && (Integer.valueOf(player.getItemInHand().getType().getMaxDurability())/ 5) > Integer.valueOf(player.getItemInHand().getDurability())) {
			if(playerspam.get(player.getName()).equals(true)){
				player.sendActionBar(prefix + player.getItemInHand().getItemMeta().getDisplayName() + " est faible !");
				player.playSound(player.getLocation(), Sound.ENTITY_ITEM_BREAK, 900.0F, 1.0F);
				playerspam.replace(player.getName(), false);
			}
		}
	}
}
