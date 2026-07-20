package com.skydrek.duels2.api.events;

import com.skydrek.duels2.api.ArenaView;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

/**
 * Fired when an arena is created or saved to disk. Useful for addons that need to snapshot
 * an arena's clean state (e.g. ArenaRegen captures it on the first save = creation).
 */
public class ArenaSavedEvent extends Event {

    private static final HandlerList HANDLERS = new HandlerList();

    private final ArenaView arena;

    public ArenaSavedEvent(ArenaView arena) {
        this.arena = arena;
    }

    public ArenaView getArena() { return arena; }

    @NotNull
    @Override
    public HandlerList getHandlers() { return HANDLERS; }

    public static HandlerList getHandlerList() { return HANDLERS; }
}
