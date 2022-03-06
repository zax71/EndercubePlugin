package me.zax71.Endercube.utils;

import org.bukkit.ChatColor;

public class ColorMessage {
    public String color(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }
}
