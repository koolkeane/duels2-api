package com.skydrek.duels2.api.events;

import com.skydrek.duels2.api.ArenaView;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

/**
 * Fired when an arena becomes free again after a duel: players and spectators are out,
 * the victory grace has ended and the arena is back to WAITING. Ideal for cleanup/regen.
 */
public class ArenaFreedEvent extends Event {

    private static final HandlerList HANDLERS = new HandlerList();

    private final ArenaView arena;

    public ArenaFreedEvent(ArenaView arena) {
        this.arena = arena;
    }

    public ArenaView getArena() { return arena; }

    @NotNull
    @Override
    public HandlerList getHandlers() { return HANDLERS; }

    public static HandlerList getHandlerList() { return HANDLERS; }
}
