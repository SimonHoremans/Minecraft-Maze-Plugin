package me.simon.Maze;


import org.bukkit.Location;
import me.simon.General.Build;
import org.bukkit.Material;

import java.util.List;

public class DrawMazeMinecraft {
    public int columns;
    public int rows;
    public int width;
    public int depth;
    public int wallHeight;
    public Location startLocation;
    public Material material;
    public boolean[][][] mazeWalls;

    public DrawMazeMinecraft(int columns, int rows, Location startLocation, Material material, int wallHeight, boolean[][][] mazeWalls) {
        this.columns = columns;
        this.rows = rows;
        this.width = columns*2+1;
        this.depth = rows*2+1;
        this.startLocation = startLocation;
        startLocation.add(5, 0, 5);
        this.material = material;
        this.wallHeight = wallHeight;
        this.mazeWalls = mazeWalls;
    }

    public void drawMaze() {
        drawFoundation();
        drawWalls();
    }

    public void drawFoundation() {
        Location startFoundation = this.startLocation.clone();
        //draw ground
        startFoundation.add(0, -1, 0);
        Build.fill(this.material, startFoundation, this.width, 1, this.depth);
        //draw left wall
        startFoundation.add(0, 1, 0);
        Build.fill(this.material, startFoundation, 1, this.wallHeight, this.depth);
        //draw upper wall
        startFoundation.add(1, 0, 0);
        Build.fill(this.material, startFoundation, this.width-2, this.wallHeight, 1);
        //draw lower wall
        startFoundation.add(0, 0, depth-1);
        Build.fill(this.material, startFoundation, this.width-2, this.wallHeight, 1);
        //draw right wall
        startFoundation.add(width-2, 0, -(depth-1));
        Build.fill(this.material, startFoundation, 1, this.wallHeight, this.depth);
        //reset startFoundation
        startFoundation = this.startLocation.clone();
        startFoundation.add(2, 0, 2);
        for(int x = 0; x < this.columns - 1; x++){
            for(int z = 0; z < this.rows - 1; z++) {
                Location currentLocation = startFoundation.clone();
                currentLocation.add(x*2, 0, z*2);
                Build.fill(this.material, currentLocation, 1, this.wallHeight, 1);
            }
        }
    }

    public void drawWalls() {
        for(int orientationIndex = 0; orientationIndex < mazeWalls.length; orientationIndex++) {
            for(int lineIndex = 0; lineIndex < mazeWalls[orientationIndex].length; lineIndex++) {
                for(int tileIndex = 0; tileIndex < mazeWalls[orientationIndex][lineIndex].length; tileIndex++) {
                    boolean wall = !mazeWalls[orientationIndex][lineIndex][tileIndex];
                    int x;
                    int z;
                    if(orientationIndex == 0) {
                        x = 2 + tileIndex*2;
                        z = 1 + lineIndex*2;
                    } else {
                        x = 1 + lineIndex*2;
                        z = 2 + tileIndex*2;
                    }
                    if(wall) {
                        Location currentLocation = startLocation.clone();
                        currentLocation.add(x, 0, z);
                        Build.fill(this.material, currentLocation, 1, wallHeight, 1);
                    }
                }
            }
        }
    }


    public static int[] getTile(int[] coordinate) {
        return new int[]{((coordinate[0] + 1)*2 - 1), ((coordinate[1] + 1)*2 - 1)};
    }

    public static int[][] getTileWall(int[] coordinateA, int[] coordinateB) {
        int[] tileA = getTile(coordinateA);
        int[] tileB = getTile(coordinateB);

        int xA = tileA[0];
        int yA = tileA[1];

        int xB = tileB[0];
        int yB = tileB[1];

        int[][] tileWall = new int[][]{
                tileA,
                new int[]{(xA + xB)/2, (yA + yB)/2},
                tileB
        };

        return tileWall;
    }
}
