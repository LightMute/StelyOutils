package fr.lightmute.StelyOutils;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;

import net.md_5.bungee.event.EventHandler;

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
Bukkit.broadcastMessage("ok");
		if(player.getItemInHand().getType().getMaxDurability()/ 2 <= player.getItemInHand().getDurability() && player.getItemInHand().getType().getMaxDurability() / 3 > player.getItemInHand().getDurability()) {
			player.sendMessage(prefix + player.getItemInHand().getItemMeta().getDisplayName() + " devient faible !");
			player.playSound(player.getLocation(), Sound.ENTITY_ITEM_BREAK, 900.0F, 1.0F);
		}else if(player.getItemInHand().getType().getMaxDurability()/ 3 <= player.getItemInHand().getDurability() && player.getItemInHand().getType().getMaxDurability() / 4 > player.getItemInHand().getDurability()) {
			player.sendMessage(prefix + player.getItemInHand().getItemMeta().getDisplayName() + " devient trés faible !");
			player.playSound(player.getLocation(), Sound.ENTITY_ITEM_BREAK, 900.0F, 1.0F);
		}else if(player.getItemInHand().getType().getMaxDurability() / 4 <= player.getItemInHand().getDurability()) {
			player.sendMessage(prefix + player.getItemInHand().getItemMeta().getDisplayName() + " va cassé !");
			player.playSound(player.getLocation(), Sound.ENTITY_ITEM_BREAK, 900.0F, 1.0F);
		}
	}
}
