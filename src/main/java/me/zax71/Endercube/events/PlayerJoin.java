package me.zax71.Endercube.events;


import me.zax71.Endercube.Endercube;
import me.zax71.Endercube.utils.ActionExecuter;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.Set;
import java.util.UUID;

import static me.zax71.Endercube.Endercube.plugin;

public class PlayerJoin implements Listener {

    @EventHandler
    public void onPlayerJoinEvent(PlayerJoinEvent e) {
        // Get config values

        Boolean joinEnabled = plugin.getConfig().getBoolean("joinMessage.enabled");
        Boolean resourcePack = plugin.getConfig().getBoolean("joinMessage.resourcePack");

        Player player = e.getPlayer();

        if (joinEnabled.equals(Boolean.TRUE)) {
            if (resourcePack.equals(Boolean.FALSE)) {

                e.joinMessage(null);
                ActionExecuter.execute("joinMessage.actions", player);
            } else {
                e.joinMessage(null);
                Set<UUID> messageSent = Endercube.ResourcePackLoginMessageSent;
                messageSent.add(player.getUniqueId());
            }
        }
    }
}
