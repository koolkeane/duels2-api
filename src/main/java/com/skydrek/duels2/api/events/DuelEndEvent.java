package com.skydrek.duels2.api.events;

import com.skydrek.duels2.api.ArenaView;
import com.skydrek.duels2.api.DuelEndReason;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Fired when a duel ends (outcome decided). The arena may still
 * be occupied during the victory celebration.
 */
public class DuelEndEvent extends Event {

    private static final HandlerList HANDLERS = new HandlerList();

    private final ArenaView arena;
    private final Player winner;
    private final Player loser;
    private final DuelEndReason reason;

    public DuelEndEvent(ArenaView arena, @Nullable Player winner, @Nullable Player loser, DuelEndReason reason) {
        this.arena = arena;
        this.winner = winner;
        this.loser = loser;
        this.reason = reason;
    }

    public ArenaView getArena() { return arena; }

    /** Winner, or null when there is none (draw/forced/disconnect). */
    @Nullable
    public Player getWinner() { return winner; }

    /** Loser, or null when there is none. */
    @Nullable
    public Player getLoser() { return loser; }

    public DuelEndReason getReason() { return reason; }

    @NotNull
    @Override
    public HandlerList getHandlers() { return HANDLERS; }

    public static HandlerList getHandlerList() { return HANDLERS; }
}
