package me.zax71.Endercube;

import co.aikar.commands.PaperCommandManager;
import me.zax71.Endercube.commands.*;
import me.zax71.Endercube.events.EntityDeath;
import me.zax71.Endercube.events.PlayerJoin;
import me.zax71.Endercube.events.PlayerLogin;
import me.zax71.Endercube.events.PlayerSwapHandItems;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class Endercube extends JavaPlugin {

    public static Endercube plugin;
    public String prefix = ChatColor.DARK_GRAY + "[" + ChatColor.DARK_AQUA + "Endercube" + ChatColor.DARK_GRAY + "] " + ChatColor.RESET;

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
        commandManager.registerCommand(new EndercubeCommand());
        commandManager.registerCommand(new NoName());
        commandManager.registerCommand(new Rename());
        commandManager.registerCommand(new TradeGUI());
        commandManager.registerCommand(new CenterTP());
        commandManager.registerCommand(new Shop());
        commandManager.registerCommand(new SendParse());

        // Register events

        getServer().getPluginManager().registerEvents(new PlayerSwapHandItems(), this);
        getServer().getPluginManager().registerEvents(new EntityDeath(), this);
        getServer().getPluginManager().registerEvents(new PlayerLogin(), this);
        getServer().getPluginManager().registerEvents(new PlayerJoin(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
