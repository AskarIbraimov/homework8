package com.GeekTech.players;

import java.util.Random;

public class Thor extends Avenger{
    private static final Random random = new Random();
    private final int chanceToStun;

    public Thor(int health, int damage, String name, EnumSuperAbility superAbility, int chanceToStun) {
        super(health, damage, name, superAbility);
        this.chanceToStun = chanceToStun;
    }

    @Override
    public void applySuperAbility(Boss thanos, Avenger[] avengers) {
        int randomNumber = random.nextInt(101);

        if (randomNumber <= chanceToStun){
            thanos.setStunned(true);
            System.out.println("Thanos stunned");
        }


        }

    }

