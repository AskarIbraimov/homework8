package com.GeekTech.game;

import com.GeekTech.players.*;

public class InfinityWar {

    private static int round = 0;

    public static void StartBattle() {
        Boss thanos = new Boss(4000, 100, "Thanos");

        CaptainAmerica captainAmerica = new CaptainAmerica(220, 25, "Captain America",
                EnumSuperAbility.SHIELD_DAMAGE);

        IronMan ironMan = new IronMan(350, 20, "Iron Man",
                EnumSuperAbility.TO_FLY);

        Hulk hulk = new Hulk(160, 1, "Hulk ",
                EnumSuperAbility.ALL_CRASH);

        Medic doc = new Medic(350, 0, "Doctor", EnumSuperAbility.TO_HEAL,10);

        Medic assistant = new Medic(450, 0, "Assistant", EnumSuperAbility.TO_HEAL,5 );

        Avenger thor = new Thor(250,0,"Thor",EnumSuperAbility.TO_STUN,50);

        Tank tank = new Tank(500,5,"Tank",EnumSuperAbility.FACE_BLOCK);

        Witcher witcher = new Witcher(350,0,"Witcher",EnumSuperAbility.SECOND_LIFE);

        Avenger[] avengers = {captainAmerica, ironMan, hulk, doc, assistant,thor,tank,witcher};
        System.out.println("___The_Infinity_War_Started___");

        while (!isGameFinished(thanos, avengers)){
            round(thanos,avengers);
        }

        printStatistics(thanos, avengers);
    }

    private static void round(Boss thanos, Avenger[] avengers) {
        round++;
        System.out.println("________ROUND " + round + "_______ _");
        thanosDamage(thanos, avengers);
        avengersDamage(thanos, avengers);
        applySuperAbility(thanos,avengers);
        printStatistics(thanos,avengers);
    }

    private static void applySuperAbility(Boss thanos, Avenger[] avengers) {
        for (int i = 0; i < avengers.length; i++) {
        if (thanos.getHealth() > 0 && avengers[i].getHealth() > 0){
            avengers[i].applySuperAbility(thanos,avengers);
        }
        }
    }

    private static boolean isGameFinished(Boss thanos, Avenger[] avengers) {
        if (thanos.getHealth() <= 0) {
            System.out.println("Avengers Won");
            return true;
        }
        boolean allAvengersDead = true;
        for (Avenger avenger : avengers) {
            if (avenger.getHealth() > 0) {
                allAvengersDead = false;
                break;
            }

        }
        if (allAvengersDead) {
            System.out.println("Thanos Won!!!");
        }
            return allAvengersDead;
        }





    private static void avengersDamage(
            Boss thanos, Avenger[] avengers){
        for (int i = 0; i < avengers.length; i++) {
            if (thanos.getHealth() > 0 &&
                    avengers[i].getHealth() > 0){
                thanos.setHealth(thanos.getHealth() -
                        avengers[i].getDamage());
            }
        }
    }

    private static void thanosDamage(
            Boss thanos, Avenger[] avengers){
        if (thanos.isStunned()){
            thanos.setStunned(false);
            return;
        }
        for (int i = 0; i < avengers.length; i++) {
            if (thanos.getHealth() > 0 &&
                    avengers[i].getHealth() > 0){
                avengers[i].setHealth(avengers[i].getHealth()
                        - thanos.getDamage());
            }
        }
    }

    private static void printStatistics(Boss thanos,Avenger[] avengers){
        System.out.println(thanos.getName() + ": " + thanos.getHealth() + " damage "
                + thanos.getDamage());

        for (int i = 0; i < avengers.length; i++) {
            System.out.println(avengers[i].getName() + ": " + avengers[i].getHealth() + " damage " +
                    avengers[i].getDamage());
        }


    }
}

