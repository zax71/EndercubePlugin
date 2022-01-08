package me.zax71.ghsppadmintools.events;

import me.clip.placeholderapi.PlaceholderAPI;
import me.zax71.ghsppadmintools.GHSPPAdminTools;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;

import java.util.List;

public class PlayerSwapHandItems implements Listener {

    @EventHandler
    public void onPlayerSwapHandItemsEvent(PlayerSwapHandItemsEvent e) {

        // Get the player
        Player p = e.getPlayer();

        // Cancel the event
        e.setCancelled(true);

        // Get the values from config
        List<?> commands = GHSPPAdminTools.plugin.getConfig().getList("commands");



        if (commands != null) {
            // Iterate through the list
            for (int i = 0; i < commands.size(); i++) {

                // Get the current working command as a variable
                String currentCommand = String.valueOf(commands.get(i));

                // Phrase it with PAPI
                String papiCommand = PlaceholderAPI.setPlaceholders(p, currentCommand);

                // Send the commands
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), papiCommand);
            }
        } else {
            GHSPPAdminTools.plugin.getLogger().severe("No commands are in config.yml, add at least one!");
        }
    }
}
