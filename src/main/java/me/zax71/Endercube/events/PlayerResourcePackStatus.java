package me.zax71.Endercube.events;

import me.clip.placeholderapi.PlaceholderAPI;
import me.zax71.Endercube.Endercube;
import me.zax71.Endercube.utils.ActionExecuter;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerResourcePackStatusEvent;

import java.util.Set;
import java.util.UUID;

import static me.zax71.Endercube.Endercube.plugin;
import static org.bukkit.event.player.PlayerResourcePackStatusEvent.Status.SUCCESSFULLY_LOADED;

public class PlayerResourcePackStatus implements Listener {

    @EventHandler
    public void onPlayerResourcePackStatusEventEvent(PlayerResourcePackStatusEvent e) {
        Player player = e.getPlayer();
        Set<UUID> messageSent = Endercube.ResourcePackLoginMessageSent;


        Boolean joinEnabled = Endercube.plugin.getConfig().getBoolean("joinMessage.enabled");

        if (joinEnabled.equals(Boolean.TRUE) && messageSent.contains(player.getUniqueId()) && e.getStatus().equals(SUCCESSFULLY_LOADED)) {

            ActionExecuter.execute("joinMessage.actions", player);
            messageSent.remove(player.getUniqueId());
        }

    }
}
