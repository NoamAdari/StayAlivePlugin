package art.kadawi.stayalive.events;

import com.sun.source.tree.BreakTree;
import net.kyori.adventure.bossbar.BossBar;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerShearEntityEvent;


public class LeftMessage implements Listener {

    @EventHandler
    public void LeftMessag(PlayerShearEntityEvent e){

        Player player = e.getPlayer();
        Entity entity = e.getEntity();

        if(entity.getType() == EntityType.SHEEP ){
            Bukkit.broadcastMessage(ChatColor.YELLOW + "Kadwawi left the game");
            Bukkit.broadcastMessage(ChatColor.RED + "אה ויניב לך תתקן את החוות שאלקרים");
            Bukkit.broadcastMessage(ChatColor.GREEN + "(אה ויניב תגיד אם אני עושה טאב זה מוסיף תיק?)");
        }


    }

}
