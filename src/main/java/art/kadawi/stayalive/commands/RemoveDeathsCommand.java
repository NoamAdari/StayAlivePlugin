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
        if (args.length != 2) return false;
        if (!(sender instanceof Player p) || !p.isOp()) return true;
        Player members = Bukkit.getPlayer(args[0]);
        int amount = Integer.parseInt(args[1]);
        int newAmount = members.getStatistic(Statistic.DEATHS) - amount;
        if (newAmount < 0) {
            p.sendMessage(ChatColor.RED + "אתה לא יכול לעשות את זה!");
            return true;
        }
        members.setStatistic(Statistic.DEATHS , newAmount);
        p.sendMessage(ChatColor.GREEN +  "למשתמש " +
                ChatColor.BOLD + members.getName() + ChatColor.RESET + "" + ChatColor.GREEN + " ירד " + amount + " באנים! " );
        return true;
    }
}
