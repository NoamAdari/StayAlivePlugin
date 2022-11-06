package art.kadawi.stayalive.commands;

import art.kadawi.stayalive.StayAlive;
import org.bukkit.Bukkit;
import org.bukkit.Statistic;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.jetbrains.annotations.NotNull;

public class ShowDeath implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player){
            Player p = (Player) sender;
            int statistic = p.getStatistic(Statistic.DEATHS);
            Bukkit.getScheduler().runTaskTimer(StayAlive.instance, new BukkitRunnable() {
                @Override
                public void run() {
                    p.sendActionBar("your deaths - " + statistic);
                }
            }, 5 , 5);

        }
        return true;
    }
}
