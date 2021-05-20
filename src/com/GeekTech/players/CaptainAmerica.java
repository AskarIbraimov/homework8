package com.GeekTech.players;

public class CaptainAmerica extends Avenger {


    public CaptainAmerica(int health, int damage, String name, EnumSuperAbility superAbility) {
        super(health, damage, name, superAbility);
    }

    @Override
    public void applySuperAbility(Boss thanos, Avenger[] avengers) {
        for (int i = 0; i < avengers.length; i++) {
         if (avengers[i].getHealth() > 0 && avengers[i] != this) {
            avengers[i].setDamage(thanos.getDamage() / 2 + avengers[i].getDamage());
         }
        }
    }
}
