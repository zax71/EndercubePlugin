package me.zax71.Endercube.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Default;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

@CommandAlias("color|colour")
public class color extends BaseCommand {

        @Default
        @CommandPermission("endercube.color")
        public static void onColor(CommandSender sender, String[] args) {

            sender.sendMessage(ChatColor.RED + "====================================");
            sender.sendMessage(ChatColor.WHITE + "&0 = " + ChatColor.BLACK + "Black     "+ChatColor.WHITE + "&1 = " + ChatColor.DARK_BLUE + "Dark Blue");
            sender.sendMessage(ChatColor.WHITE + "&2 = " + ChatColor.DARK_GREEN + "Dark Green     "+ChatColor.WHITE + "&3 = " + ChatColor.DARK_AQUA + "Dark Aqua");
            sender.sendMessage(ChatColor.WHITE + "&4 = " + ChatColor.DARK_RED + "Dark Red     "+ChatColor.WHITE + "&5 = " + ChatColor.DARK_PURPLE + "Dark Purple");
            sender.sendMessage(ChatColor.WHITE + "&6 = " + ChatColor.GOLD + "Gold     "+ChatColor.WHITE + "&7 = " + ChatColor.GRAY + "Gray");
            sender.sendMessage(ChatColor.WHITE + "&8 = " + ChatColor.DARK_GRAY + "Dark Gray     "+ChatColor.WHITE + "&9 = " + ChatColor.BLUE + "Blue");
            sender.sendMessage(ChatColor.WHITE + "&a = " + ChatColor.GREEN + "Green     "+ChatColor.WHITE + "&b = " + ChatColor.AQUA + "Aqua");
            sender.sendMessage(ChatColor.WHITE + "&c = " + ChatColor.RED + "Red     "+ChatColor.WHITE + "&d = " + ChatColor.LIGHT_PURPLE + "Light Purple");
            sender.sendMessage(ChatColor.WHITE + "&e = " + ChatColor.YELLOW + "Yellow     "+ChatColor.WHITE + "&f = " + ChatColor.WHITE + "White");
            sender.sendMessage(ChatColor.RED + "====================================");
        }

}
