package me.simon.Commands;

import me.simon.General.Build;

import me.simon.Moves.GenerateMaze;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandFill implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;
            String name = player.getName();
            Build.fill(Material.RED_WOOL, player.getLocation(), 2, 1, 1000);
            player.sendMessage("Sup " + name + ", filling space hihi." );

            return true;

        }

        return false;
    }
}
