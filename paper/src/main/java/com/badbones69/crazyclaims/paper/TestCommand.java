package com.badbones69.crazyclaims.paper;

import com.badbones69.crazyclaims.paper.api.config.LangFile;
import com.google.inject.Inject;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class TestCommand implements CommandExecutor {

    @Inject private LangFile langFile;

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        System.out.println(langFile.getFile().getString("test-string"));

        return false;
    }
}