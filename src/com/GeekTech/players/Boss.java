package com.GeekTech.players;

public class Boss extends GameEntity{
    private boolean isStunned = false;

    public Boss(int health, int damage, String name) {
        super(health, damage, name);
    }

    public boolean isStunned(){
        return isStunned;
    }
    public void setStunned(boolean stunned){
        isStunned = stunned;
    }
    }

