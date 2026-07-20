package com.skydrek.duels2.api;

/**
 * Entry point of a Duels2 addon. Implement this and declare the class in {@code addon.yml}:
 */
public interface Duels2Addon {

    /** Called when the addon is loaded. Register listeners/commands via the given API. */
    void onEnable(Duels2Api api);

    /** Called when the addon is unloaded. Optional. */
    default void onDisable() {}
}
