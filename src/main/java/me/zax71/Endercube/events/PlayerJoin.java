package me.zax71.Endercube.events;

import me.zax71.Endercube.Endercube;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {

    @EventHandler
    public void onPlayerJoinEvent(PlayerJoinEvent e) {
        // Get config values

        Boolean joinEnabled = Endercube.plugin.getConfig().getBoolean("joinMessage.enabled");
        String joinMessage = Endercube.plugin.getConfig().getString("joinMessage.message");

        if (joinEnabled.equals(Boolean.TRUE)) {
            if (joinMessage != null) {
                e.joinMessage(MiniMessage.miniMessage().parse(joinMessage));
            } else {
                Endercube.plugin.getLogger().warning("joinMessage.message is blank, put something in there!");
            }
        }
    }
}
