package art.kadawi.stayalive.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Statistic;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class RemoveDeathsCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (p.isOp()) {
                if(args.length == 2){
                    Player members = Bukkit.getPlayer(args[0]);
                    int amount = Integer.parseInt(args[1]);
                    int newAmount = members.getStatistic(Statistic.DEATHS) - amount;
                    if(newAmount >= 0){
                            members.setStatistic(Statistic.DEATHS , newAmount);
                            p.sendMessage(ChatColor.GREEN +  "למשתמש " +
                                    ChatColor.BOLD + members.getName() + ChatColor.RESET + "" + ChatColor.GREEN + " ירד " + amount + " באנים " );
                        }
                        else
                        {
                           p.sendMessage(ChatColor.RED + "אתה לא יכול לעשות את זה!");
                        }
                }
            }
        }
        return true;
    }
}
