package com.example.kazuaki.liarwolf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import com.example.kazuaki.liarwolf.Enum.*;
import com.example.kazuaki.liarwolf.LWUtility.*;

/**
 * Created by Kazuaki on 2015/11/16.
 */

public class LWGameScene{
 public static void main(String[] args){
  Map<String,String> query = new HashMap<String,String>();
  ArrayList<Object> tablePlayerArray = new ArrayList<Object>();

  int day = 0;

  String victim = "���܂���";
  ArrayList<Object> victimArray = new ArrayList<Object>();]
  List<Map<String,Object>> playerArray = new ArrayList<>();

  Map<String,Object> playerMap;
  //map���g����
  int i;
  String[] name = {"�͂���","�͂邫","���낫","����","����؁[","�������[","������","�܂��悵"};

  for(i=0;i<8;i++) {
   playerMap = new HashMap<>();
   playerMap.put("playerId", i);
   playerMap.put("name", name[i]);
   playerMap.put("roleId", Role.RoleVillager);
   playerMap.put("isLive", true);
   playerArray.add(playerMap);

  }



 // �������֐�
 public void initBackground{


  // background��ݒ�
  // setRole�i�V���b�t�����Ė�E������j
  void setRole;

  query.put("phase","firstNight_opening");
  void setBackground;


 }

 public void setBackground{

  // Table���̃f�[�^��������
  // ��ʂ���x�܂�����ɂ���


  // phase �ɉ���������������
  if(query.get("phase").equals("firstNight_opening") || query.get("phase").equals("nextPlayer") || query.get("phase").equals("afternoon_opening") || query.get("phase").equals("afternoon_opening2") || query.get("phase").equals("night_opening") || query.get("phase").equals("gameover") || query.get("phase").equals("winner"){


   // ��ʂ����
   /* messageSize
   *  buttonSize
   *  margin

   *  UIColor
    fontSize */
   String message = "";

    //��ʂ����I��

   if (query.get("phase").equals("firstNight_opening")){
    // refresh
    void refresh;
    // message ������
    message = "�͂��߂̖�ɂȂ�܂����B�u%@�v���񂩂�[�����܂킵�Ă��ꂼ��s�������肵�Ă��������B����ȊO�̃v���C���[�͖ڂ���Ċ�𕚂��Ă��������B",infoDic.get("players")[0]["name"]];
    /*backColor
    * fontColor
    * fontSize*/
   }
   if (query.get("phase").equals("night_opening")){
    //refresh
    //if (isFinish !=0){ //�I������
     query.put("phase","gameover");
     // setBackground
     //�߂�l���w��
    }
   }


  }


 }
 public void setRole{
  ArrayList<Object> array = new ArrayList<>();
  ArrayList<Object> roleArray = new ArrayList<>();



 }
 public void refresh{

 }
 public void isFinish{
  int point = 0;
  boolean wolfzero = true;
  // �����҂̖�E�𐔂���
  if (roleId == Role.RoleWerewolf){
   point --;
   wolfzero = false;
  } else{
   point ++;
  }

  int result = 0;
  if(wolfzero){
   result = 1; //������
  }
  if (point <=0){
   result = -1;//�l�T����
  }
  else {
   result = 0;//�Q�[�����s
  }
  //return result;

 }

 }
}
