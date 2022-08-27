package me.zax71.Endercube.utils;

import me.clip.placeholderapi.PlaceholderAPI;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.title.Title;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.*;

import static me.zax71.Endercube.Endercube.plugin;

public class ActionExecuter {

    public static void execute(String path, Player player) {
        // Get values from config
        String broadcast = plugin.getConfig().getString(path + ".broadcast");
        String title = plugin.getConfig().getString(path + ".title");
        String subtitle = plugin.getConfig().getString(path + ".subtitle");
        String actionbar = plugin.getConfig().getString(path + ".actionbar");

        List<?> commands = plugin.getConfig().getList(path + ".commands");
        List<String> commandsString = new ArrayList<>();

        for (int i = 0; i < commands.size(); i++) {
            commandsString.add((String) commands.get(i));
        }

        // Phrase with placeholderAPI
        broadcast = PlaceholderAPI.setPlaceholders(player, broadcast);
        title = PlaceholderAPI.setPlaceholders(player, title);
        subtitle = PlaceholderAPI.setPlaceholders(player, subtitle);
        actionbar = PlaceholderAPI.setPlaceholders(player, actionbar);

        for (int i = 0; i < commandsString.size(); i++) {
            commandsString.set(i, PlaceholderAPI.setPlaceholders(player, commandsString.get(i)));
        }

        // Make components

        Component broadcastComponent = MiniMessage.miniMessage().parse(broadcast);
        Component titleComponent = MiniMessage.miniMessage().parse(title);
        Component subtitleComponent = MiniMessage.miniMessage().parse(subtitle);
        Component actionbarComponent = MiniMessage.miniMessage().parse(actionbar);

        // Execute
        plugin.getServer().broadcast(broadcastComponent);

        final Title combinedTitle = Title.title(titleComponent, subtitleComponent);
        player.showTitle(combinedTitle);

        player.sendActionBar(actionbarComponent);


        for (int i = 0; i < commandsString.size(); i++) {
            if (!commandsString.get(i).equals("")) {
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), commandsString.get(i));
            }
        }
    }
}
