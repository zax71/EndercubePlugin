package me.zax71.ghsppadmintools.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Default;
import me.zax71.ghsppadmintools.GHSPPAdminTools;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

@CommandAlias("rename|setName")
public class Rename extends BaseCommand {

    @Default
    @CommandPermission("GHSPP.rename")
    public static void onRename(CommandSender sender, String[] args) {
        // Get the sender as a player
        Player player = Bukkit.getServer().getPlayer(sender.getName());
        String argsPlain = "";
        if(args[0] != null) {

            for (int i = 0; i < args.length; i++) {
                argsPlain = argsPlain.concat(args[i] + " ");
            }
            ItemStack item = player.getInventory().getItemInMainHand();

            ItemMeta itemMeta = item.getItemMeta();
            itemMeta.displayName(MiniMessage.miniMessage().parse(argsPlain));

            // Set the items meta to the one defined above
            player.getInventory().getItemInMainHand().setItemMeta(itemMeta);
        } else {
            player.sendMessage(GHSPPAdminTools.plugin.prefix + ChatColor.AQUA + "Must supply the text to be renamed to");
        }

    }
}
