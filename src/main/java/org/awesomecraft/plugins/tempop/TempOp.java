package org.awesomecraft.plugins.tempop;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * 
 * @author Will Wright
 * @version 1.6
 * @since 2011-12-30
 */

public class TempOp extends JavaPlugin {
    private Plugin TempOp = this;
    public void onDisable() {
        System.out.println(this + " is now disabled!");
    }
    public void onEnable() {
        System.out.println(this + " is now enabled!");
    }
            @Override
            public boolean onCommand(CommandSender cs, Command cmnd, String alias, String[] args) {
                if(cmnd.getName().equalsIgnoreCase("tempop")) {
                if(args.length == 1) {
                final Player target = getServer().getPlayer(args[0]);
                if(target != null) {
                target.setOp(true);
                target.sendMessage(ChatColor.GREEN + "You have been temporarily opped for 1 minute.");
                getServer().getScheduler().scheduleSyncDelayedTask(TempOp, new Runnable() {
                    public void run() {
                        target.setOp(false);
                        target.sendMessage(ChatColor.RED + "You are no longer op.");
                    }
                }, 1200L);
                return true;
                } else {
                    cs.sendMessage(ChatColor.RED + "Player not found!");
                }
                
                } else {
                    cs.sendMessage(ChatColor.RED + "Usage: /tempop <user>");
                }
                
                return false;
            }
                return false;
            }
            
}
