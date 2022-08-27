package me.zax71.Endercube.events;

import me.clip.placeholderapi.PlaceholderAPI;
import me.zax71.Endercube.Endercube;
import me.zax71.Endercube.utils.ActionExecuter;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.List;

import static me.zax71.Endercube.Endercube.plugin;

public class PlayerQuit implements Listener {

    @EventHandler
    public void onPlayerQuitEvent(PlayerQuitEvent e) {
        Player player = e.getPlayer();

        Boolean quitEnabled = plugin.getConfig().getBoolean("quitMessage.enabled");
        List<?> commands = plugin.getConfig().getList("quitMessage.actions.commands");
        String broadcast = plugin.getConfig().getString("quitMessage.actions.broadcast");

        if (quitEnabled.equals(Boolean.TRUE)) {
            e.quitMessage(null);

            // Execute commands
            if (commands != null) {
                for (int i = 0; i < commands.size(); i++) {
                    // Get the current working command as a variable
                    String currentCommand = String.valueOf(commands.get(i));
                    if (!currentCommand.equals("")) {
                        // Phrase it with PAPI
                        String papiCommand = PlaceholderAPI.setPlaceholders(player, currentCommand);

                        // Send the commands
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), papiCommand);
                    }

                }
            }

            // Phrase and send broadcast
            if (broadcast != null) {
                broadcast = PlaceholderAPI.setPlaceholders(player, broadcast);
                Component broadcastComponent = MiniMessage.miniMessage().parse(broadcast);
                plugin.getServer().broadcast(broadcastComponent);
            }

        }
    }
}
