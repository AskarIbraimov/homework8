package com.GeekTech.players;

public abstract class Avenger extends GameEntity implements SuperAblity{

    private EnumSuperAbility superAbility;

    public Avenger(int health, int damage, String name, EnumSuperAbility superAbility) {
        super(health, damage, name);
        this.superAbility = superAbility;
    }
}
