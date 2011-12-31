package org.awesomecraft.plugins.tempop;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
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
        System.out.println("TempOp 1.1 is now enabled!");
    }
            @Override
            public boolean onCommand(CommandSender cs, Command cmnd, String alias, String[] args) {
                if(cmnd.getName().equalsIgnoreCase("tempop")) {
                if(args.length == 1 || args.length == 2) {
                final Player target = getServer().getPlayer(args[0]);
                if(target != null) {
                target.setOp(true);
                
                if(args.length == 1) {
                    target.sendMessage(ChatColor.GREEN + "You have been opped for 60 seconds.");
                    cs.sendMessage(ChatColor.GREEN + "Opped " + target.getDisplayName() + " for 60 seconds.");
                    final CommandSender sender = cs;
                    getServer().getScheduler().scheduleSyncDelayedTask(TempOp, new Runnable() {
                    
                    public void run() {
                        target.setOp(false);
                        target.sendMessage(ChatColor.RED + "You are no longer op.");
                        sender.sendMessage(ChatColor.GREEN + target.getDisplayName() + " has been de-opped.");
                    }
                }, 1200L);
                }
                else {
                    long dur = Integer.parseInt(args[1]) * 20;
                    target.sendMessage(ChatColor.GREEN + "You have been opped for " + args[1] + " seconds.");
                    final CommandSender sender = cs;
                    cs.sendMessage(ChatColor.GREEN + "Opped " + target.getDisplayName() + " for " + args[1] + "seconds.");
                    getServer().getScheduler().scheduleSyncDelayedTask(TempOp, new Runnable() {
                    
                    public void run() {
                        target.setOp(false);
                        target.sendMessage(ChatColor.RED + "You are no longer op.");
                        sender.sendMessage(ChatColor.GREEN + target.getDisplayName() + "hes been de-opped.");
                    }
                }, dur);
                }
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
