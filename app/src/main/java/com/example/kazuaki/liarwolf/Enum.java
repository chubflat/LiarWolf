package com.example.kazuaki.liarwolf;

/**
 * Created by Kazuaki on 2015/11/28.
 */
public class Enum {

    /**
     * Enum�N���X�ł��B
     *
     */
    public enum Role {
        RoleVillager,
        RoleWerewolf;
    }

    /**
     * switch�����g���āAEnum�̔�r�����Ă��܂��B
     */
    public static void main(String arg[]) {
        Role role = Role.RoleVillager;


        switch (role) {
            case RoleVillager:
                System.out.println("���l");
                break;
            case RoleWerewolf:
                System.out.println("�l�T");
                break;
            default:
                System.out.println("Other!!");
                break;
        }
    }
}

