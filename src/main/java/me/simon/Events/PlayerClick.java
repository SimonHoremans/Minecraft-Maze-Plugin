package me.simon.Events;

import me.simon.MazeGenerator;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;


public class PlayerClick implements Listener {

    @EventHandler
    public void OnPlayerClick(PlayerInteractEvent event) {
        if(event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            event.setCancelled(true);

            Block block = event.getClickedBlock();
            Player player = event.getPlayer();
            World world = player.getWorld();
            Vector velocity = new Vector(0, 1, 0);

            if(block != null) {
                Location location = block.getLocation().add(.5, .5, .5);
                Material material = block.getType();

//                for(int i = 1; i < 4; i++) {
//                    Location blockLocation = location.clone().add(0, i, 0);
//                    blockLocation.getBlock().setType(material);
//                }

                new BukkitRunnable() {

                    int counter = 0;

                    @Override
                    public void run() {
                        Location blockLocation = location.add(0, 1, 0);
                        blockLocation.getBlock().setType(material);

                        world.getNearbyEntities(location, 1, 1, 1,
                                entity -> entity instanceof LivingEntity).forEach(entity -> entity.setVelocity(velocity));



                        if(counter == 2) {
                            this.cancel();
                        }
                        counter ++;
                    }
                }.runTaskTimer(MazeGenerator.getInstance(), 0, 2);
            }

        }
    }
}
