package me.simon.Commands;

import me.simon.Moves.GenerateMaze;
import me.simon.Moves.GenerateMaze2;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandMaze2 implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            int columns;
            int rows;
            int tileSize;
            int wallSize;
            int wallHeight;

            Player player = (Player) sender;
            String name = player.getName();

            if(args.length == 5) {
                boolean numeric = true;
                for(String arg : args) {
                    if(!isNumeric(arg)) {
                        numeric = false;
                        break;
                    }
                }
                if(numeric) {
                    columns = Integer.parseInt(args[0]);
                    rows = Integer.parseInt(args[1]);
                    tileSize = Integer.parseInt(args[2]);
                    wallSize = Integer.parseInt(args[3]);
                    wallHeight = Integer.parseInt(args[4]);
                    GenerateMaze2.Generate(player, columns, rows, tileSize, wallSize, wallHeight);
                    player.sendMessage("Sup " + name + ", trying to generate a maze hihi." );
                } else {
                    player.sendMessage("all values have to be integers");
                }
            }else {
                player.sendMessage("this command takes 5 arguments");
            }
            return true;

        }

        return false;
    }


    public static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
}
