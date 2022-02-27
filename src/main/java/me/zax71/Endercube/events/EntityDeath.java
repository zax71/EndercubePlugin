package me.zax71.Endercube.events;

import me.zax71.Endercube.Endercube;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.EnderDragon;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

import java.util.Objects;
import java.util.Random;

public class EntityDeath implements Listener {

    @EventHandler
    public void onEntityDeathEvent(EntityDeathEvent e) {
        // Is it an ender dragon?
        if (e.getEntity() instanceof EnderDragon) {
            Location eggSpot = ((EnderDragon) e.getEntity()).getDragonBattle().getEndPortalLocation().add(0, 5, 0);
            if (eggSpot.getBlock().getType().equals(Material.AIR)) {
                Random random = new Random();

                int randomValue = random.nextInt(5);
                if (randomValue == 1) {
                    eggSpot.getBlock().setType(Material.DRAGON_EGG);
                    Objects.requireNonNull(e.getEntity().getKiller()).sendMessage(Endercube.plugin.prefix + "You killed the dragon! Here is your special dragon egg that is only a 1 in 5 chance :)");
                } else {
                    Objects.requireNonNull(e.getEntity().getKiller()).sendMessage(Endercube.plugin.prefix + "You killed the dragon! But you didn't get the 1 in 5 chance of an egg :(");
                }
            }
        }
    }
}
