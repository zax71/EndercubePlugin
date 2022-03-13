package me.zax71.Endercube.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Default;
import me.zax71.Endercube.Endercube;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

@CommandAlias("NoName|clearName")
public class NoName extends BaseCommand {

    @Default
    @CommandPermission("endercube.noname")
    public static void onNoName(CommandSender sender, String[] args) {

        // Get the sender as a player
        Player player = Bukkit.getServer().getPlayer(sender.getName());


        ItemStack item = player.getInventory().getItemInMainHand();

        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.displayName(Component.text(""));

        // Set the items meta to the one defined above
        player.getInventory().getItemInMainHand().setItemMeta(itemMeta);




    }
}
