package me.zax71.Endercube.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandCompletion;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Subcommand;
import me.zax71.Endercube.Endercube;
import me.zax71.Endercube.utils.ColorMessage;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandAlias("SendParse")
public class SendParse extends BaseCommand {

    @Subcommand("legacy")
    @CommandPermission("endercube.cmd.SendParse.legacy")
    @CommandCompletion("@players @nothing")
    public static void onSendParseLegacy(CommandSender sender, String[] args) {
        if(args.length >= 2) {

            Player player = null;

            // if the player is online
            if (Bukkit.getOnlinePlayers().toString().toLowerCase().contains(args[0].toLowerCase())) {
                player = Bukkit.getPlayer(args[0]);
            } else {
                Endercube.plugin.getLogger().warning("/sendParse must be used with online players");
            }

            if (player != null) {
                StringBuilder message = new StringBuilder();
                for(int i=1;i < args.length;i++) {
                    message.append(args[i]).append(" ");
                }
                player.sendMessage(ColorMessage.color(message.toString()));

            }
        } else {
            sender.sendMessage(Endercube.plugin.prefix + "Usage: /SendParse legacy <player> <text>");
        }


    }
}
