package art.kadawi.stayalive.events;

import art.kadawi.stayalive.StayAlive;
import art.kadawi.stayalive.commands.ShowDeath;
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


    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        int statistic = event.getPlayer().getStatistic(Statistic.DEATHS);
        Player p = event.getPlayer();
        Bukkit.getScheduler().runTask(StayAlive.instance , ()-> {
            long timeDate = System.currentTimeMillis();

            switch (statistic){
                case 0:
                    timeDate = timeDate + 300000;
                    Date date = new Date(timeDate);
                    p.banPlayer("אתה בבאן ל5 דקות" , date);
                        break;
                case 1:
                    timeDate = timeDate + 900000;
                    date = new Date(timeDate);
                    p.banPlayer("אתה בבאן ל15 דקות" , date);
                        break;
                case 2:
                    timeDate = timeDate + 1800000;
                    date = new Date(timeDate);
                    p.banPlayer("אתה בבאן ל30 דקות" , date);
                    break;
                case 3:
                    timeDate = timeDate + 3600000;
                    date = new Date(timeDate);
                    p.banPlayer("אתה בבאן לשעה" , date);
                    break;
                case 4:
                    timeDate = timeDate + 7200000;
                    date = new Date(timeDate);
                    p.banPlayer("אתה בבאן לשעתיים" , date);
                    break;
                case 5:
                    timeDate = timeDate + 14400000;
                    date = new Date(timeDate);
                    p.banPlayer("אתה בבאן ל4 שעות " , date);
                    break;
                case 6:
                    timeDate = timeDate + 28800000;
                    date = new Date(timeDate);
                    p.banPlayer("אתה בבאן ל8 שעות " , date);
                    break;
                case 7:
                    timeDate = timeDate + 43200000;
                    date = new Date(timeDate);
                    p.banPlayer("אתה בבאן ל12 שעות " , date);
                    break;
                case 8:
                    timeDate = timeDate + 86400000;
                    date = new Date(timeDate);
                    p.banPlayer("אתה בבאן ל24 שעות " , date);
                    break;


            }
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
