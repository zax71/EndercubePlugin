package me.zax71.ghsppadmintools.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Default;
import me.zax71.ghsppadmintools.GHSPPAdminTools;
import net.wesjd.anvilgui.AnvilGUI;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class TradeGUI extends BaseCommand {

    @Default
    @CommandPermission("GHSPP.material")
    public static void onTradeGUI(Player sender, String[] args) {
        new AnvilGUI.Builder()
                .onComplete((player, text) -> {
                    Bukkit.dispatchCommand(sender, "trade " + text);
                    return AnvilGUI.Response.close();
                })
                .text("Player Name")
                .itemLeft(new ItemStack(Material.PAPER))
                .itemRight(new ItemStack(Material.PAPER))
                .title("Who do you want to trade with?")
                .plugin(GHSPPAdminTools.plugin)
                .open(sender);
    }
}