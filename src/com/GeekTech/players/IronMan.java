package com.GeekTech.players;

public class IronMan extends Avenger {
    int damagePoint = 0;
    public IronMan(int health, int damage, String name, EnumSuperAbility superAbility) {
        super(health, damage, name, superAbility);
    }

    @Override
    public void applySuperAbility(Boss thanos, Avenger[] avengers) {
        for (int i = 0; i < avengers.length; i++) {
        if (avengers[i].getHealth() > 0){
            avengers[i].setDamage(avengers[i].getDamage() + damagePoint++);
        }
        }
        System.out.println(" Damage up " + damagePoint++);

    }
}


