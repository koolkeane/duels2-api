package com.skydrek.duels2.api;

/** Why a duel ended. */
public enum DuelEndReason {
    /** A player reached the required round wins. */
    WIN,
    /** Ended with no winner (e.g. timeout/draw). */
    DRAW,
    /** Force-ended by an admin. */
    FORCED,
    /** Ended because a participant disconnected. */
    DISCONNECT
}
