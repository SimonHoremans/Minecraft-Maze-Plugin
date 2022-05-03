package me.simon;

import me.simon.Commands.CommandFill;
import me.simon.Commands.CommandMaze;
import me.simon.Commands.CommandMaze2;
import org.bukkit.plugin.java.JavaPlugin;

public final class MazeGenerator extends JavaPlugin {

    private static MazeGenerator instance;


    @Override
    public void onEnable() {
        instance = this;
        System.out.println("sup");
//        getServer().getPluginManager().registerEvents(new PlayerJoin(), this);
//        getServer().getPluginManager().registerEvents(new PlayerClick(), this);
        this.getCommand("maze").setExecutor(new CommandMaze());
        this.getCommand("maze2").setExecutor(new CommandMaze2());
        this.getCommand("fill").setExecutor(new CommandFill());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static MazeGenerator getInstance() {
        return instance;
    }
}
