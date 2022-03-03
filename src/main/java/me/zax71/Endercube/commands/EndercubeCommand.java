package me.zax71.Endercube.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.*;
import me.zax71.Endercube.Endercube;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

@CommandAlias("EC|Endercube")
public class EndercubeCommand extends BaseCommand {

    @Subcommand("reload")
    @CommandPermission("GHSPP.cmd.reload")
    public static void onECReload(CommandSender sender, String[] args) {
        Endercube.plugin.reloadConfig();
        sender.sendMessage(Endercube.plugin.prefix + ChatColor.AQUA + "Config Successfully Reloaded");
    }

    @Default
    @HelpCommand
    @CommandPermission("GHSPP.cmd.help")
    public static void onECHelp(CommandSender sender, String[] args) {
        sender.sendMessage("/EC reload - Reloads the plugin");
        sender.sendMessage("/colour - Shows a list of bukkit colour codes");
        sender.sendMessage("/material - Shows the Bukkit item name of the item you are holding");
    }
}
