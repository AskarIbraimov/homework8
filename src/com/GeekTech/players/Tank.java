package com.GeekTech.players;

public class Tank extends Avenger{
    public Tank(int health, int damage, String name, EnumSuperAbility superAbility) {
        super(health, damage, name, superAbility);
    }

    @Override
    public void applySuperAbility(Boss thanos, Avenger[] avengers) {
        if (this.getHealth() >0){
            for (int i = 0; i < avengers.length; i++) {
               if (avengers[i].getHealth() > 0 ){
                   avengers[i].setHealth(avengers[i].getHealth() + thanos.getDamage() /5);
                   this.setHealth(this.getHealth() - thanos.getDamage() / 5);
               }
            }
        }



    }
}
