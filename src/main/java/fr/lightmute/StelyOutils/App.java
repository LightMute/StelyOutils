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
		
		if(Integer.valueOf(player.getItemInHand().getType().getMaxDurability()) - Integer.valueOf(player.getItemInHand().getDurability()) < 10 && Integer.valueOf(player.getItemInHand().getType().getMaxDurability()) - Integer.valueOf(player.getItemInHand().getDurability()) > 8) {
				player.sendActionBar(prefix + player.getItemInHand().getItemMeta().getDisplayName() + " est faible !");
				player.playSound(player.getLocation(), Sound.BLOCK_TRIPWIRE_CLICK_OFF, 900.0F, 1.0F);
		}
		player.sendMessage(Integer.valueOf(player.getItemInHand().getDurability()) + "/" + Integer.valueOf(player.getItemInHand().getType().getMaxDurability()));
	}
}
