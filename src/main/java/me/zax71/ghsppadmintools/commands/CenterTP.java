package me.zax71.ghsppadmintools.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Default;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

@CommandAlias("CenterTP|center|TPMid")
public class CenterTP extends BaseCommand {

    @Default
    @CommandPermission("GHSPP.CenterTP")
    public static void onColor(Player sender, String[] args) {
        double senderX = sender.getLocation().getBlockX() + 0.5;
        double senderY = sender.getLocation().getBlockY();
        double senderZ = sender.getLocation().getBlockZ() + 0.5;
        World senderWorld = sender.getWorld();

        Location senderLocation = new Location(senderWorld, senderX, senderY, senderZ, 0, 0);

        sender.teleport(senderLocation);
    }
}
