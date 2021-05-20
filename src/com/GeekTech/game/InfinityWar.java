package com.GeekTech.game;

import com.GeekTech.players.*;

public class InfinityWar {

    private static int round = 0;

    public static void StartBattle() {
        Boss thanos = new Boss(3300, 50, "Thanos");
        CaptainAmerica captainAmerica = new CaptainAmerica(220, 25, "Captain America",
                EnumSuperAbility.SHIELD_DAMAGE);

        IronMan ironMan = new IronMan(200, 20, "Iron Man",
                EnumSuperAbility.TO_FLY);

        Hulk hulk = new Hulk(300, 35, "Hulk ",
                EnumSuperAbility.ALL_CRASH);

        Medic doc = new Medic(200, 0, "Doctor", EnumSuperAbility.TO_HEAL,10);

        Medic assistant = new Medic(230, 0, "Assistant", EnumSuperAbility.TO_HEAL,5 );

        Avenger[] avengers = {captainAmerica, ironMan, hulk, doc, assistant};
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





    private static void avengersDamage(Boss thanos,Avenger[] avengers){
        for (int i = 0; i < avengers.length; i++) {
            if(thanos.getHealth() > 0 && avengers[i].getHealth() > 0){

                thanos.setHealth(thanos.getHealth() - avengers[i].getDamage());
            }
        }
    }

    private static void thanosDamage(Boss thanos,Avenger[] avengers){
        for (int i = 0; i < avengers.length; i++) {
          if(thanos.getHealth() > 0 && avengers[i].getHealth() > 0){
              avengers[i].setHealth
              (avengers[i].getHealth() - thanos.getDamage());
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

