package me.zax71.Endercube.events;

import me.zax71.Endercube.Endercube;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

import java.util.List;

public class PlayerLogin implements Listener {

    @EventHandler
    public void onPlayerLoginEvent(PlayerLoginEvent e) {

        // Get config values and the player
        Boolean enabled = Endercube.plugin.getConfig().getBoolean("ipKick.enabled");
        String kickMessage = Endercube.plugin.getConfig().getString("ipKick.kickMessage");
        Boolean debugEnabled = Endercube.plugin.getConfig().getBoolean("ipKick.debugEnabled");
        Player player = e.getPlayer();
        String ip = e.getHostname(); // IP that the player joined on

        // Are debug messages enabled?
        if (debugEnabled.equals(Boolean.TRUE)) {
            Endercube.plugin.getLogger().info("Player joined on the IP of: " + ip);
        }

        // Is it enabled in the config?
        if (enabled.equals(Boolean.TRUE)) {


            List<?> kickList = Endercube.plugin.getConfig().getList("ipKick.kickList"); // List of blocked IP's

            // NPE's are annoying
            if (kickList != null) {

                // Loop through the list of blocked IP's
                for (int i = 0; i < kickList.size(); i++) {
                    String currentIP = String.valueOf(kickList.get(i)); // Get the current IP

                    // If the IP the player joined on is the same as one on our block list...
                    if(ip.equalsIgnoreCase(currentIP)) {
                        e.disallow(PlayerLoginEvent.Result.KICK_OTHER, MiniMessage.miniMessage().parse(kickMessage)); // Kick them with the predefined message

                        Endercube.plugin.getLogger().info("Disallowed " + player.getName() + " from joining due to using the wrong IP");
                    }
                }
            } else {
                // Nag the user about the NPE
                Endercube.plugin.getLogger().warning("ipKick.kickList in config is empty! Either fill it or set ipKick.enabled to false");
            }

        }
    }
}