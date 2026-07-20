package com.skydrek.duels2.api.events;

import com.skydrek.duels2.api.ArenaView;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

/**
 * Fired when a duel begins (players teleported, kit given, before the countdown).
 */
public class DuelStartEvent extends Event {

    private static final HandlerList HANDLERS = new HandlerList();

    private final ArenaView arena;
    private final Player challenger;
    private final Player receiver;
    private final String kitType;

    public DuelStartEvent(ArenaView arena, Player challenger, Player receiver, String kitType) {
        this.arena = arena;
        this.challenger = challenger;
        this.receiver = receiver;
        this.kitType = kitType;
    }

    public ArenaView getArena() { return arena; }
    public Player getChallenger() { return challenger; }
    public Player getReceiver() { return receiver; }

    /** Kit type name: OWN_INVENTORY, RANDOM_KIT or SELECTED_KIT. */
    public String getKitType() { return kitType; }

    @NotNull
    @Override
    public HandlerList getHandlers() { return HANDLERS; }

    public static HandlerList getHandlerList() { return HANDLERS; }
}
