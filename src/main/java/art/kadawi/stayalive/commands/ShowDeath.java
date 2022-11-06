package art.kadawi.stayalive.commands;

import art.kadawi.stayalive.StayAlive;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.Statistic;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ShowDeath implements CommandExecutor {
    private static final Map<UUID, BukkitTask> tasks = new HashMap<>();
    private final NamespacedKey SHOWING_DEATHS = new NamespacedKey(StayAlive.instance, "showing_deaths");
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player){
            Player p = (Player) sender;
            if (tasks.containsKey(p.getUniqueId())) {
                tasks.remove(p.getUniqueId()).cancel();
                p.getPersistentDataContainer().remove(SHOWING_DEATHS);
            } else {
                showDeaths(p);
                p.getPersistentDataContainer().set(SHOWING_DEATHS, PersistentDataType.BYTE, (byte)1);
            }
        }
        return true;
    }

    public static void showDeaths(Player p) {
        if (tasks.containsKey(p.getUniqueId())) return;
        BukkitTask task = new BukkitRunnable() {
            @Override
            public void run() {
                Player target = Bukkit.getPlayer(p.getUniqueId());
                if (target != null) {
                    int statistic = target.getStatistic(Statistic.DEATHS);
                    target.sendActionBar("your deaths - " + statistic);
                }
            }
        }.runTaskTimer(StayAlive.instance, 5, 5);
        tasks.put(p.getUniqueId(), task);
    }
}
