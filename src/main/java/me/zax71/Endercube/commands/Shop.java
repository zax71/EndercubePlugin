package me.zax71.Endercube.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.Default;
import co.aikar.commands.annotation.HelpCommand;
import co.aikar.commands.annotation.Subcommand;
import me.zax71.Endercube.utils.CentredMessage;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandAlias("shop")
public class Shop extends BaseCommand {

    @Subcommand("help")
    @HelpCommand
    @Default
    public static void onShopHelp(Player sender, String[] args) {
        sender.sendMessage(CentredMessage.generate("§m               "));
    }
}
