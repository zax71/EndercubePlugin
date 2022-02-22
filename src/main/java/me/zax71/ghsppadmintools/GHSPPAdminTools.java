package me.zax71.ghsppadmintools;

import co.aikar.commands.PaperCommandManager;
import me.zax71.ghsppadmintools.commands.*;
import me.zax71.ghsppadmintools.events.EntityDeath;
import me.zax71.ghsppadmintools.events.PlayerLogin;
import me.zax71.ghsppadmintools.events.PlayerSwapHandItems;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class GHSPPAdminTools extends JavaPlugin {

    public static GHSPPAdminTools plugin;
    public String prefix = ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + "GHS++" + ChatColor.DARK_GRAY + "] " + ChatColor.RESET;

    @Override
    public void onEnable() {

        // Config
        plugin = this;
        saveDefaultConfig();
        FileConfiguration config = getConfig();

        // Commands
        PaperCommandManager commandManager = new PaperCommandManager(this);
        commandManager.registerCommand(new color());
        commandManager.registerCommand(new material());
        commandManager.registerCommand(new GHSPPATCommand());
        commandManager.registerCommand(new NoName());
        commandManager.registerCommand(new Rename());
        commandManager.registerCommand(new TradeGUI());
        commandManager.registerCommand(new CenterTP());

        // Register events

        getServer().getPluginManager().registerEvents(new PlayerSwapHandItems(), this);
        getServer().getPluginManager().registerEvents(new EntityDeath(), this);
        getServer().getPluginManager().registerEvents(new PlayerLogin(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
