package art.kadawi.stayalive.events;

import art.kadawi.stayalive.StayAlive;
import art.kadawi.stayalive.commands.ShowDeath;
import art.kadawi.stayalive.duration.DurationFormat;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.Date;
public class OnDeathEvent implements Listener {
    private static final int[] banDurations = {5, 15, 30, 60, 120, 240, 480, 720, 1440};
    private static final DurationFormat durationFormat = new DurationFormat();
    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        int statistic = event.getPlayer().getStatistic(Statistic.DEATHS);
        Player p = event.getPlayer();
        Bukkit.getScheduler().runTask(StayAlive.instance , ()-> {
            int minutes = statistic >= banDurations.length ? banDurations[banDurations.length - 1] : banDurations[statistic];
            long duration = minutes * 60000;
            long timeDate = System.currentTimeMillis() + duration;

            String durString = durationFormat.format(duration, false);

            Date date = new Date(timeDate);
            p.banPlayer("אתה בבאן ל" + durString , date);
        });
    }

    private final NamespacedKey SHOWING_DEATHS = new NamespacedKey(StayAlive.instance, "showing_deaths");

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        if (event.getPlayer().getPersistentDataContainer().has(SHOWING_DEATHS)) {
            ShowDeath.showDeaths(event.getPlayer());
        }
    }
}
