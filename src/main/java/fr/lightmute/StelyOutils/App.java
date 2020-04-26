package fr.lightmute.StelyOutils;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class App extends JavaPlugin implements Listener{

	String prefix = "§7[§cStelyWarning§7] §c";

	public void onEnable() {
		Bukkit.getPluginManager().registerEvents(this, this);
	}
	public void onDisable() {

	}

	@SuppressWarnings("deprecation")
	@EventHandler
	public void getoutilsdurab(PlayerInteractEvent e) {
		Player player = e.getPlayer();

		if(player.getItemInHand().getType().getMaxDurability()/ 10 <= player.getItemInHand().getDurability()) {
			player.sendMessage(prefix + player.getItemInHand().getItemMeta().getDisplayName() + " devient faible !");
			player.playSound(player.getLocation(), Sound.ENTITY_ITEM_BREAK, 900.0F, 1.0F);
		}
	}
}
