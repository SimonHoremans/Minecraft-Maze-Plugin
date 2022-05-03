package me.simon.Events;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {
    @EventHandler
    public void OnPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        World world = player.getWorld();
        Location location = player.getLocation();

        Location pigLocation = location.add(0, 4, 0);

        for(int i = 0; i < 100; i++) {
            world.spawnEntity(pigLocation.add(i, 0, 0), EntityType.PIG);
        }
    }
}
