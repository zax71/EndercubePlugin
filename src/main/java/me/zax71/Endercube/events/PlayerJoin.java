package me.zax71.Endercube.events;


import me.zax71.Endercube.Endercube;
import me.zax71.Endercube.utils.ActionExecuter;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.geysermc.floodgate.api.FloodgateApi;

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
        UUID playerUUID = player.getUniqueId();

        if (joinEnabled.equals(Boolean.TRUE)) {

            // Set the vanilla join message to null, letting us use our own
            e.joinMessage(null);

            // Does the user want to wait for the RP to load
            if (resourcePack.equals(Boolean.TRUE)) {

                // Are they a bedrock user?
                if (FloodgateApi.getInstance().isFloodgatePlayer(playerUUID)) {
                    ActionExecuter.execute("joinMessage.actions", player);
                } else {
                    // Add the players UUID to our hashmap, so we can read it later when the pack loads
                    Set<UUID> messageSent = Endercube.ResourcePackLoginMessageSent;
                    messageSent.add(playerUUID);
                }
            // No waiting for the RP
            } else {
                ActionExecuter.execute("joinMessage.actions", player);
            }
        }
    }
}
