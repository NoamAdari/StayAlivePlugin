package art.kadawi.stayalive.commands;

import com.google.common.eventbus.DeadEvent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.Statistic;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class ClearDeathCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (args.length != 1) return false;
        if (!(sender instanceof Player p) || !p.isOp()) return true;
        OfflinePlayer t = Bukkit.getOfflinePlayer(args[0]);
        t.setStatistic(Statistic.DEATHS, 0);
        p.sendMessage(ChatColor.GREEN + " למשתמש " + ChatColor.BOLD + t.getName() + ChatColor.RESET + ChatColor.GREEN + " ירד הבאנים! ");
        return true;
    }
}
