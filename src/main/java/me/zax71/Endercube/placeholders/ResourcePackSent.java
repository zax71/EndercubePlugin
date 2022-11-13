package me.zax71.Endercube.placeholders;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import me.zax71.Endercube.Endercube;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Set;
import java.util.UUID;

public class ResourcePackSent extends PlaceholderExpansion {
    @Override
    public String onPlaceholderRequest(Player player, @NotNull String params) {

        // %Endercube_resourcePackSent% placeholder
        if(params.equals("resourcePackSent")) {
            String returnData = "";
            Set<UUID> packAccepted = Endercube.ResourcePackAccepted;

            if (packAccepted.contains(player.getUniqueId())) {
                returnData = "True";
            } else {
                returnData = "False";
            }

            return returnData;
        }
        // Not an expansion
        return null;
    }

    @Override
    public @NotNull String getAuthor() {
        return "Zax71";
    }

    @Override
    public @NotNull String getIdentifier() {
        return "Endercube";
    }

    @Override
    public @NotNull String getVersion() {
        return "${project.version}";
    }

    @Override
    public boolean canRegister() {
        return true;
    }

    @Override
    public boolean persist() {
        return true;
    }
}
