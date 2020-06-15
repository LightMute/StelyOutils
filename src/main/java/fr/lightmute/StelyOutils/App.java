package fr.lightmute.StelyOutils;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemDamageEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class App extends JavaPlugin implements Listener{

	String prefix = "§7[§5StelyOutils§7] §c";
	HashMap<String, Boolean> playerspam = new HashMap<String, Boolean>();

	public void onEnable() {
		Bukkit.getPluginManager().registerEvents(this, this);
	}
	public void onDisable() {

	}

	@SuppressWarnings("deprecation")
	@EventHandler
	public void getoutilsdurab(PlayerItemDamageEvent e) {
		Player player = e.getPlayer();

		if(player.getItemInHand() != null) {

			if(Integer.valueOf(e.getItem().getType().getMaxDurability()) - Integer.valueOf(e.getItem().getDurability()) < 10 && Integer.valueOf(e.getItem().getType().getMaxDurability()) - Integer.valueOf(e.getItem().getDurability()) > 5) {
				player.sendActionBar(prefix + "Ton outils va casser !");
				player.playSound(player.getLocation(), Sound.BLOCK_TRIPWIRE_CLICK_OFF, 900.0F, 1.0F);
			}else if(Integer.valueOf(e.getItem().getType().getMaxDurability()) - Integer.valueOf(e.getItem().getDurability()) < 25 && Integer.valueOf(e.getItem().getType().getMaxDurability()) - Integer.valueOf(e.getItem().getDurability()) > 20) {
				player.sendActionBar(prefix + "Ton outils est abîmé");
				player.playSound(player.getLocation(), Sound.BLOCK_TRIPWIRE_CLICK_OFF, 900.0F, 1.0F);
			}
		}
	}
}
