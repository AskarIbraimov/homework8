package com.GeekTech.players;

public class Witcher extends Avenger{
    boolean dead = false;

    public Witcher(int health, int damage, String name, EnumSuperAbility superAbility) {
        super(health, damage, name, superAbility);
    }



    @Override
    public void applySuperAbility(Boss thanos, Avenger[] avengers) {

        for (int i = 0; i < avengers.length; i++) {
          if (avengers[i].getHealth() <= 0) {
              dead = true;
          }
          if (dead && this.getHealth() > 0) {
              avengers[i].setHealth(avengers[i].getHealth() + this.getHealth());
              this.setHealth(0);
              this.setDamage(0);
          }
        }
    }
}
