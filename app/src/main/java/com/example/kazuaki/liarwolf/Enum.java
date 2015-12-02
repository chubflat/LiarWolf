package com.example.kazuaki.liarwolf;

/**
 * Created by Kazuaki on 2015/11/28.
 */
public class Enum {

    /**
     * Enumクラスです。
     *
     */
    public enum Role {
        RoleVillager,
        RoleWerewolf;
    }

    /**
     * switch文を使って、Enumの比較をしています。
     */
    public static void main(String arg[]) {
        Role role = Role.RoleVillager;


        switch (role) {
            case RoleVillager:
                System.out.println("村人");
                break;
            case RoleWerewolf:
                System.out.println("人狼");
                break;
            default:
                System.out.println("Other!!");
                break;
        }
    }
}

