package me.simon.Commands;

import me.simon.Moves.GenerateMaze;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandMaze implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;
            String name = player.getName();

            player.sendMessage("Sup " + name + ", trying to generate a maze hihi." );
            GenerateMaze.Generate(player);
            return true;

        }

        return false;
    }
}
