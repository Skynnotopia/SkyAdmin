package fr.skynnotopia.skyadmin;

import fr.skynnotopia.skyadmin.commands.*;
import fr.skynnotopia.skyadmin.tabcompleters.*;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    public static String logPrefix = "[SkyChat] ";
    public static String messagePrefix = ChatColor.DARK_GREEN + "[SkyChat] " + ChatColor.RESET;

    @Override
    public void onEnable() {
        // Instance de la Class Config
        new Config(this);

        // Commandes
        getCommand("skyadmin").setExecutor(new CommandSkyAdmin());
        getCommand("skyadmin").setTabCompleter(new TabCompleterSkyAdmin());

        getCommand("report").setExecutor(new CommandReport());
        getCommand("report").setTabCompleter(new TabCompleterReport());

        getCommand("reports").setExecutor(new CommandReports());
        getCommand("reports").setTabCompleter(new TabCompleterReports());

        getCommand("ticket").setExecutor(new CommandTicket());
        getCommand("ticket").setTabCompleter(new TabCompleterTicket());

        getCommand("tickets").setExecutor(new CommandTickets());
        getCommand("tickets").setTabCompleter(new TabCompleterTickets());

        getCommand("warn").setExecutor(new CommandWarn());
        getCommand("warn").setTabCompleter(new TabCompleterWarn());

        getCommand("archive").setExecutor(new CommandArchive());
        getCommand("archive").setTabCompleter(new TabCompleterArchive());

        // Boucles de notification pour les nouveaux reports/tickets
        /*new BukkitRunnable() {
            public void run() {
                CommandReports.notifyReport();
                CommandTickets.notifyticket();
            }
        }.runTaskTimer(this, 20 * 60, 20 * 60);*/
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

}
