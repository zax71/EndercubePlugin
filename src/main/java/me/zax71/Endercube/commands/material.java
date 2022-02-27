package me.zax71.Endercube.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Default;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandAlias("material|itemstack")
public class material extends BaseCommand {


    @Default
    @CommandPermission("GHSPP.material")
    public static void onColor(CommandSender sender, String[] args) {

        // Get the sender as a player
        Player player = Bukkit.getServer().getPlayer(sender.getName());

        // Send the itemstack of held item
        player.sendMessage(String.valueOf(player.getInventory().getItemInMainHand()));
    }
}