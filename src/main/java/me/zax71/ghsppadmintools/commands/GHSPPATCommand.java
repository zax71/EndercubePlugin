package me.zax71.ghsppadmintools.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.*;
import me.zax71.ghsppadmintools.GHSPPAdminTools;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

@CommandAlias("GHSPPAT|GHSPP|GHSPPAdminTools")
public class GHSPPATCommand extends BaseCommand {

    @Subcommand("reload")
    @CommandPermission("GHSPP.cmd.reload")
    public static void onGHSPPReload(CommandSender sender, String[] args) {
        GHSPPAdminTools.plugin.reloadConfig();
        sender.sendMessage(GHSPPAdminTools.plugin.prefix + ChatColor.AQUA + "Config Successfully Reloaded");
    }

    @Default
    @HelpCommand
    @CommandPermission("GHSPP.cmd.help")
    public static void onGHSPPHelp(CommandSender sender, String[] args) {
        sender.sendMessage("/GHSPP reload - Reloads the plugin");
        sender.sendMessage("/colour - Shows a list of bukkit colour codes");
        sender.sendMessage("/material - Shows the Bukkit item name of the item you are holding");
    }
}
