package art.kadawi.stayalive;

import art.kadawi.stayalive.commands.ClearDeathCommand;
import art.kadawi.stayalive.commands.RemoveDeathsCommand;
import art.kadawi.stayalive.commands.SetTimerCommand;
import art.kadawi.stayalive.commands.ShowDeath;
import art.kadawi.stayalive.events.OnDeathEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class StayAlive extends JavaPlugin {

    public static Plugin instance;

    @Override
    public void onEnable() {
        instance = this;
        // Register Events
        getServer().getPluginManager().registerEvents(new OnDeathEvent(), this);
        // Register Commands
        getCommand("ClearDeaths").setExecutor(new ClearDeathCommand());
        getCommand("RemoveDeaths").setExecutor(new RemoveDeathsCommand());
        getCommand("SetBanTime").setExecutor(new SetTimerCommand());
        getCommand("ShowDeaths").setExecutor(new ShowDeath());
    }
    
}
