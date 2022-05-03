package me.simon.Moves;

import me.simon.Maze.DrawMazeMinecraft;
import me.simon.Maze.DrawMazeMinecraft2;
import me.simon.Maze.MazeGenerator;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class GenerateMaze2 {
    public static void Generate(Player player, int columns, int rows, int tileSize, int wallSize, int wallHeight) {
//        int columns = 10;
//        int rows = 10;
//        int wallHeight = 3;
//        int tileSize = 2;
//        int wallSize = 5;
        Location startLocation = player.getLocation();
        Material material = Material.COBBLESTONE;
        MazeGenerator mazeGenerator = new MazeGenerator(columns, rows, new int[]{0, 0});
        mazeGenerator.generateMaze();
        mazeGenerator.generateWalls();
        DrawMazeMinecraft2 draw = new DrawMazeMinecraft2(columns, rows, startLocation, material, wallHeight, mazeGenerator.mazeWalls,
                tileSize, wallSize);
        draw.drawMaze();

    }
}
