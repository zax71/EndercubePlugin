package me.zax71.Endercube.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.*;
import me.zax71.Endercube.Endercube;
import me.zax71.Endercube.utils.CentredMessage;
import me.zax71.Endercube.utils.ColorMessage;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;

@CommandAlias("shop")
@CommandPermission("Endercube.cmd.shop")
public class Shop extends BaseCommand {

    @Subcommand("help")
    @CommandPermission("Endercube.cmd.shop.help")
    public class ShopHelp extends BaseCommand {

        @HelpCommand
        @Default
        @CommandPermission("Endercube.cmd.shop.help")
        public static void onShopHelp(Player sender, String[] args) {
            final TextComponent shopHelpMessage = Component.text("Welcome to the Endercube shop. This is the help command, choose your option from the list below and enter it with ")
                    .color(NamedTextColor.GRAY)
                    .append(
                            Component.text("/shop help <number>\n\n")
                                    .color(NamedTextColor.GRAY)
                                    .decoration(TextDecoration.BOLD, true)
                    )

                    .append(
                            Component.text("(1) ")
                                    .color(NamedTextColor.GRAY)
                                    .decoration(TextDecoration.BOLD, true)
                    )
                    .append(
                            Component.text("General Help ")

                                    .color(NamedTextColor.GRAY)
                    )

                    .append(
                            Component.text("(2) ")
                                    .color(NamedTextColor.GRAY)
                                    .decoration(TextDecoration.BOLD, true)
                    )
                    .append(
                            Component.text("Visiting ")

                                    .color(NamedTextColor.GRAY)
                    )

                    .append(
                            Component.text("(3) ")
                                    .color(NamedTextColor.GRAY)
                                    .decoration(TextDecoration.BOLD, true)
                    )
                    .append(
                            Component.text("Shop Creation ")

                                    .color(NamedTextColor.GRAY)
                    );
            sender.sendMessage(CentredMessage.generate("&8&m     &r&8[&l&3Shop Help&8]&m     &r"));
            sender.sendMessage(shopHelpMessage);
        }

        @Subcommand("1")
        @CommandPermission("Endercube.cmd.shop.help.1")
        public static void onShopHelp1(Player sender, String[] args) {
            sender.sendMessage(CentredMessage.generate("&8&m     &r&8[&l&3Shop Help&8]&m     &r"));

            sender.sendMessage(ColorMessage.color("&7&l/shop warp&r&7 - Teleports you to the shop world"));
            sender.sendMessage(ColorMessage.color("&7&l/shop claim&r&7 - Claims the plot you are standing on"));
            sender.sendMessage(ColorMessage.color("&7&l/shop claim auto&r&7 - Finds the closest plot and claims it"));
        }

        @Subcommand("2")
        @CommandPermission("Endercube.cmd.shop.help.2")
        public static void onShopHelp2(Player sender, String[] args) {
            sender.sendMessage(CentredMessage.generate("&8&m     &r&8[&l&3Shop Help&8]&m     &r"));
            sender.sendMessage(ColorMessage.color("&7&l/shop warps&r&7 - Main Warps menu"));
            sender.sendMessage(ColorMessage.color("&7&l/shop warps create <name>&r&7 - Create a warp"));
            sender.sendMessage(ColorMessage.color("&7&l/shop warps delete <name>&r&7 - Delete a warp"));
            sender.sendMessage(ColorMessage.color("&7&l/shop warps rename <old name> <new name>&r&7 - Rename a warp"));
            sender.sendMessage(ColorMessage.color("&7&l/shop warps rate <rating> <name> &r&7 - Rate a warp"));
        }

        @Subcommand("3")
        @CommandPermission("Endercube.cmd.shop.help.3")
        public static void onHelp3(Player sender, String[] args) {
            sender.sendMessage(CentredMessage.generate("&8&m     &r&8[&l&3Shop Help&8]&m     &r"));

            final TextComponent shopCreateHelpMessage = Component.text("To create a shop, press ")
                    .append(
                            Component.keybind("key.sneak")
                                    .decoration(TextDecoration.BOLD, true)
                    )
                    .append(Component.text(" + "))
                    .append(
                            Component.keybind("key.use")
                                    .decoration(TextDecoration.BOLD, true)
                    )
                    .append(Component.text(" on a chest while holding an item to create a shop."));

            sender.sendMessage(shopCreateHelpMessage);


        }
    }


    @Subcommand("warp")
    @CommandPermission("Endercube.cmd.shop.warp")
    public static void onShopWarp(Player sender, String[] args) {
        Location shopSpawn = Bukkit.getWorld("survivalShop").getSpawnLocation();

        sender.teleport(shopSpawn);

        sender.sendMessage(Endercube.plugin.prefix + ChatColor.DARK_AQUA + "Teleported to the shop spawn");
    }

    @Subcommand("warps")
    @CommandPermission("Endercube.cmd.shop.warps")
    public class shopWarps extends BaseCommand {

        @Default
        public static void onShopWarpsMenu(Player sender, String[] args) {
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pwarp open");
            sender.sendMessage(Endercube.plugin.prefix + "Opened warp menu");
        }

        @Subcommand("create|set")
        @CommandPermission("Endercube.cmd.shop.warps.create")
        public static void onShopWarpsCreate(Player sender, String[] args) {
            if (args.length == 1) {
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pwarp set " + args[0]);
                sender.sendMessage(Endercube.plugin.prefix + "Created warp " + args[0]);
            } else {
                sender.sendMessage(Endercube.plugin.prefix + "see /shop help 2 for command syntax");
            }

        }

        @Subcommand("delete|remove")
        @CommandPermission("Endercube.cmd.shop.warps.delete")
        public static void onShopWarpsDelete(Player sender, String[] args) {
            if (args.length == 1) {
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pwarp remove " + args[0]);
                sender.sendMessage(Endercube.plugin.prefix + "Removed warp " + args[0]);
            } else {
                sender.sendMessage(Endercube.plugin.prefix + "see /shop help 2 for command syntax");
            }

        }

        @Subcommand("rename")
        @CommandPermission("Endercube.cmd.shop.warps.rename")
        public static void onShopWarpsRename(Player sender, String[] args) {
            if (args.length == 2) {
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pwarp rename " + args[0] + " " + args[1]);
                sender.sendMessage(Endercube.plugin.prefix + "Renamed warp " + args[0] + " to " + args[1]);
            } else {
                sender.sendMessage(Endercube.plugin.prefix + "see /shop help 2 for command syntax");
            }

        }

        @Subcommand("rate|score")
        @CommandCompletion("@range:0-5 @nothing")
        @CommandPermission("Endercube.cmd.shop.warps.rate")
        public static void onShopWarpsRate(Player sender, String[] args) {
            if (args.length == 2) {
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pwarp rate " + args[1] + " " + args[0]);
                sender.sendMessage(Endercube.plugin.prefix + "Rated warp " + args[1] + " at " + args[0]);
            } else {
                sender.sendMessage(Endercube.plugin.prefix + "see /shop help 2 for command syntax");
            }

        }

    }

    @Subcommand("claim")
    @CommandPermission("Endercube.cmd.shop.claim")
    public class shopClaim extends BaseCommand {

        @Default
        @CommandPermission("Endercube.cmd.shop.claim")
        public static void onShopClaim(Player sender, String[] args) {
            if (sender.getWorld() == Bukkit.getWorld("survivalShop")) {
                Bukkit.dispatchCommand(sender, "p claim");
            }
        }

        @Subcommand("auto")
        @CommandPermission("Endercube.cmd.shop.claim.auto")
        public static void onShopClaimAuto(Player sender, String[] args) {
            if (sender.getWorld() == Bukkit.getWorld("survivalShop")) {
                Bukkit.dispatchCommand(sender, "p auto");
            }
        }
    }
}
