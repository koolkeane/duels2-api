package com.skydrek.duels2.api.internal;

import org.bukkit.entity.Player;

import java.util.Collection;

/**
 * Internal API — powerful operations reused by first-party addons (team duels, etc.) so they
 * don't have to reimplement delicate logic such as inventory save/restore or kit handing.
 *
 * <p><b>NO STABILITY GUARANTEE.</b> Unlike {@link com.skydrek.duels2.api.Duels2Api}, this
 * surface may change or be removed in any release, without notice. Use at your own risk.
 *
 * <p>Obtain it via Bukkit's ServicesManager:
 * <pre>{@code
 * Duels2Internal internal = Bukkit.getServicesManager().load(Duels2Internal.class);
 * }</pre>
 */
public interface Duels2Internal {

    // ==== Inventory (same code path Duels2 uses for its own duels) ====

    /** Saves the player's current inventory so it can be restored later. No-op if already in a core duel. */
    void saveInventory(Player player);

    /** Restores a previously saved inventory. No-op if the player is in a core duel. */
    void restoreInventory(Player player);

    /** True if there's a saved inventory pending restore for this player. */
    boolean hasSavedInventory(Player player);

    // ==== Kits ====

    /** Names of all configured kits. */
    Collection<String> getKitNames();

    /** Gives a kit exactly like a normal duel does. Returns false if the kit doesn't exist. */
    boolean giveKit(Player player, String kitName);

    // ==== Arena reservation (so core duels/queue skip an arena used by an addon) ====

    /** Marks an arena as in use. Returns false if it doesn't exist or is already busy. */
    boolean reserveArena(String arenaName);

    /** Frees a previously reserved arena. */
    void releaseArena(String arenaName);

    // ==== Player busy state (blocks core duel requests/queue while in an addon match) ====

    /** Marks/unmarks a player as busy in an addon-run match. */
    void setBusy(Player player, boolean busy);

    /** True if the player is busy in an addon-run match. */
    boolean isBusy(Player player);

    // ==== Post-duel helpers (reuse the core's behaviour) ====

    /** Teleports the player out using the configured post-duel rule (LAST_LOCATION / LOBBY). */
    void postDuelTeleport(Player player);

    /** Applies the configured duel cooldown to the player. */
    void addDuelCooldown(Player player);

    /** Resets health, hunger, fire, fall distance and potion effects. */
    void clearPlayerState(Player player);
}
