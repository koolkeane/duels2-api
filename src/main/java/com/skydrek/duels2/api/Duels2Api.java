package com.skydrek.duels2.api;

import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;

import java.util.Collection;

/**
 * Public API of Duels2, meant for addons and third-party plugins.
 */
public interface Duels2Api {

    /**
     * Compatibility level of this API surface (independent of the release version).
     * Addons declare the minimum they need in {@code addon.yml} as {@code api-version}.
     * Bumped only when the surface changes in a way addons must know about.
     */
    int API_VERSION = 1;

    /** Arena by name, or null if it doesn't exist. */
    ArenaView getArena(String name);

    /** All registered arenas (any state). */
    Collection<ArenaView> getArenas();

    /** True if the player is currently in a duel. */
    boolean isInDuel(Player player);

    /** Arena of the player's active duel, or null if not dueling. */
    ArenaView getArenaOf(Player player);

    /** The Duels2 plugin instance (for scheduling, etc.). */
    Plugin getPlugin();

    /** Registers a Bukkit listener under the Duels2 plugin (for addons that aren't plugins). */
    void registerListener(Listener listener);

    /**
     * Registers a runtime command (addons have no plugin.yml of their own).
     * If {@code executor} also implements {@link org.bukkit.command.TabCompleter} it is used
     * for tab completion.
     */
    void registerCommand(String name, CommandExecutor executor);
}
