package me.simon.Moves;

import me.simon.Maze.DrawMazeMinecraft;
import me.simon.Maze.MazeGenerator;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class GenerateMaze {
    public static void Generate(Player player) {
        int columns = 100;
        int rows = 100;
        int wallHeight = 2;
        Location startLocation = player.getLocation();
        Material material = Material.COBBLESTONE;
        MazeGenerator mazeGenerator = new MazeGenerator(columns, rows, new int[]{0, 0});
        mazeGenerator.generateMaze();
        mazeGenerator.generateWalls();
        DrawMazeMinecraft draw = new DrawMazeMinecraft(columns, rows, startLocation, material, wallHeight, mazeGenerator.mazeWalls);
        draw.drawMaze();
//        MazeGenerator mazeGenerator = new MazeGenerator(500, 500, new int[]{0, 0});
//        mazeGenerator.generateMaze();
//        for(int i = 0; i < mazeGenerator.maze.size(); i++) {
//            System.out.println(i);
//            int[][] step = mazeGenerator.maze.get(i);
//            int[][] tiles = DrawMazeMinecraft.getTileWall(step[0], step[1]);
//
//            int tileStart;
//
//            if(i == 0) {
//                tileStart = 0;
//            } else {
//                tileStart = 1;
//            }
//
//            for(int k = tileStart; k < 3; k++) {
//                int[] tile = tiles[k];
//                Location location = startLocation.clone();
//                location.add(new Vector(tile[0], 10, tile[1]));
//                location.getBlock().setType(material);
//            }
//
//        }
    }
}
