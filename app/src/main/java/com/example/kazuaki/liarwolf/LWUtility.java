package com.example.kazuaki.liarwolf;

import java.util.HashMap;
import java.util.Map;
import com.example.kazuaki.liarwolf.Enum.*;
import android.widget.Button;
/**
 * Created by Kazuaki on 2015/11/16.
 */
public class LWUtility {
    public static void main(String[] args) {
        public static Map<String, String> getCardinfofromId ( int cardId){
            Map<String, Object> infoDic = new HashMap<String, Object>();
            String name = "name";
            String explain = "explain";
            String detailExplain = "���ɂȂ�";
            boolean hasTable = false; //��̃A�N�V�����Ńe�[�u�������邩
            boolean hasTableFirst = false;//����̃A�N�V�����Ńe�[�u�������邩
            String tableString = "";// ��̃A�N�V�����Ńe�[�u���ɕ\�����镶����
            String tableStringFirst = "";// ����̃A�N�V�����Ńe�[�u���ɕ\�����镶����

            Role role = Role.RoleVillager;


            switch (role) {
                case RoleVillager: //RoleVillager
                    name = "���l";
                    hasTable = false;
                    explain = "���l�͓���Ȕ\�͂������Ȃ������̈�ʐl�ł����A���̃Q�[���̎�l���ł�����܂��B���̑��l�����\�͂����������Ԃ����Ƌ��͂��Đl�T�����Y���A�S�ł����܂��傤�B";
                    break;

                case RoleWerewolf://RoleWerewolf
                    name = "�l�T";
                    hasTable = true;
                    hasTableFirst = true;
                    tableString = "";//������
                    tableStringFirst = "";//������
                    explain = "�l�T�͖��Ӗڂ��o�܂��A���̐l�Ԃ���l���I��ŋ򂢎E���Ă����܂��B�l�T���m�ŋ��͂��Đl�Ԃ��򂢐s�����A����S�ł����Ă��܂��܂��傤�B";
                    break;

                default:
                    break;
            }
            // infoDic�ɃL�[�ƒl��ݒ�
            infoDic.put("name", name);
            infoDic.put("explain", explain);
            infoDic.put("hasTable", hasTable);
            infoDic.put("hasTableFirst", hasTableFirst);
            infoDic.put("tableString", tableString);
            infoDic.put("tableStringFirst", tableStringFirst);

            return infoDic;

        }
    }

}
