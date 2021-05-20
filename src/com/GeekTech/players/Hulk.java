package com.GeekTech.players;

import java.util.Random;

public class Hulk extends Avenger {
    public Hulk(int health, int damage, String name, EnumSuperAbility superAbility) {
        super(health, damage, name, superAbility);

    }
    Random random = new Random();
    int randomNumber = random.nextInt(3)+2;



    @Override
    public void applySuperAbility(Boss thanos, Avenger[] avengers) {
        if (this.getHealth() >0 ){
            this.setDamage(this.getDamage() * randomNumber);
        }

    }
}


