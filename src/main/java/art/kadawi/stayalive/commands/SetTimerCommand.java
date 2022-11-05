package art.kadawi.stayalive.commands;

import org.bukkit.BanEntry;
import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Date;

public class SetTimerCommand implements CommandExecutor {


    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (p.isOp()) {
                if(args.length == 2){
                    long timeDate = System.currentTimeMillis();
                    int amount = Integer.parseInt(args[1]);
                    long minutes = amount*60000 + timeDate;
                    BanEntry banEntry = Bukkit.getBanList(BanList.Type.NAME).getBanEntry(args[0]);
                    if(banEntry == null)
                        return true;
                    banEntry.setExpiration(new Date(minutes));
                    banEntry.save();
                }
            }
        }
        return true;
    }
}
