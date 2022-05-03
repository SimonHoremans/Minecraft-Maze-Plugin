package me.simon.Maze;


import me.simon.General.Build;
import org.bukkit.Location;
import org.bukkit.Material;

public class DrawMazeMinecraft2 {
    public int columns;
    public int rows;
    public int width;
    public int depth;
    public int wallHeight;
    public int tileSize;
    public int wallSize;
    public Location startLocation;
    public Material material;
    public boolean[][][] mazeWalls;

    public DrawMazeMinecraft2(int columns, int rows, Location startLocation, Material material, int wallHeight, boolean[][][] mazeWalls, int tileSize, int wallSize) {
        this.columns = columns;
        this.rows = rows;
        this.width = columns*(tileSize + wallSize) + wallSize;
        this.depth = rows*(tileSize + wallSize) + wallSize;
        this.startLocation = startLocation;
        startLocation.add(5, 0, 5);
        this.material = material;
        this.wallHeight = wallHeight;
        this.mazeWalls = mazeWalls;
        this.wallSize = wallSize;
        this.tileSize = tileSize;
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
        Build.fill(this.material, startFoundation, wallSize, this.wallHeight, this.depth);
        //draw upper wall
        startFoundation.add(wallSize, 0, 0);
        Build.fill(this.material, startFoundation, this.width-2*wallSize, this.wallHeight, wallSize);
        //draw lower wall
        startFoundation.add(0, 0, depth-wallSize);
        Build.fill(this.material, startFoundation, this.width-2*wallSize, this.wallHeight, wallSize);
        //draw right wall
        startFoundation.add(width-2*wallSize, 0, -(depth-wallSize));
        Build.fill(this.material, startFoundation, wallSize, this.wallHeight, this.depth);
        //reset startFoundation
        startFoundation = this.startLocation.clone();
        int unit = wallSize + tileSize;
        startFoundation.add(unit, 0, unit);
        for(int x = 0; x < this.columns - 1; x++){
            for(int z = 0; z < this.rows - 1; z++) {
                Location currentLocation = startFoundation.clone();
                currentLocation.add(x*unit, 0, z*unit);
                Build.fill(this.material, currentLocation, wallSize, this.wallHeight, wallSize);
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
                    int width;
                    int depth;
                    int unit = this.wallSize + this.tileSize;
                    if(orientationIndex == 0) {
                        x = unit + tileIndex*unit;
                        z = wallSize + lineIndex*unit;
                        width = wallSize;
                        depth = tileSize;
                    } else {
                        x = wallSize + lineIndex*unit;
                        z = unit + tileIndex*unit;
                        width = tileSize;
                        depth = wallSize;
                    }
                    if(wall) {
                        Location currentLocation = startLocation.clone();
                        currentLocation.add(x, 0, z);
                        Build.fill(this.material, currentLocation, width, wallHeight, depth);
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
