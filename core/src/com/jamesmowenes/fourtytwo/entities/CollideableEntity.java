package com.jamesmowenes.fourtytwo.entities;

public abstract class CollideableEntity extends Entity {
    /**
     * What to do when this entity collides with the player
     * @param player the current player
     */
    public abstract void onPlayerCollide(Player player);
}
