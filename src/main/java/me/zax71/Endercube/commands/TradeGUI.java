package me.zax71.Endercube.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandCompletion;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Default;
import me.zax71.Endercube.Endercube;
import net.wesjd.anvilgui.AnvilGUI;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

@CommandAlias("tradegui")
public class TradeGUI extends BaseCommand {

    @Default
    @CommandPermission("endercube.tradeGUI")
    @CommandCompletion("@players")
    public static void onTradeGUI(Player sender, String[] args) {

        // Define empty player object
        Player player = null;

        // If there are no arguments...
        if (args.length == 0) {
            // ...set senderPlayer to the sender
            player = sender;
            // if there are arguments
        } else {
            // if the player is online
            if (Bukkit.getOnlinePlayers().toString().toLowerCase().contains(args[0].toLowerCase())) {
                player = Bukkit.getPlayer(args[0]);
            } else {
                Endercube.plugin.getLogger().warning("/tradeGUI must be used with online players");
            }
        }
        if (player != null) {
            new AnvilGUI.Builder()
                    .onComplete((completePlayer, text) -> {
                        Bukkit.dispatchCommand(completePlayer, "trade " + text);
                        return AnvilGUI.Response.close();
                    })
                    .text("Player Name")
                    .itemLeft(new ItemStack(Material.PAPER))
                    .title("Player to trade with")
                    .plugin(Endercube.plugin)
                    .open(player);
        } else {
            Endercube.plugin.getLogger().warning("/tradeGUI must be used with online players");
        }

    }
}
