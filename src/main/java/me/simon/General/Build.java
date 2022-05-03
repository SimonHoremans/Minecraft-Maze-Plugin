package me.simon.General;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.util.Vector;

public class Build {
    public static void fill(Material material, Location startLocation, int width, int height, int depth) {
        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                for(int z = 0; z < depth; z++) {
                    Location locationClone = startLocation.clone();
                    locationClone.add(new Vector(x, y, z));
                    locationClone.getBlock().setType(material);
                }
            }
        }
    }
}
