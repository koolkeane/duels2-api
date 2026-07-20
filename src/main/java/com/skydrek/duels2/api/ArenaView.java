package com.skydrek.duels2.api;

import org.bukkit.Location;
import org.bukkit.World;

/**
 */
public interface ArenaView {

    /** Arena name (unique id). */
    String getName();

    /** World the arena lives in (from its corners), or null if undefined. */
    World getWorld();

    /** First region corner, or null if not set. */
    Location getCorner1();

    /** Second region corner, or null if not set. */
    Location getCorner2();

    /** True while a duel is currently running in this arena. */
    boolean isInGame();

    /** True if the arena is fully defined, not in game and not disabled. */
    boolean isAvailable();
}
