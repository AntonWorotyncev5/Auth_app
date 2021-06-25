package main.com.company;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static main.com.company.Entrance.auth;

public class UserPasswordManager  {


  public static void  editingPassword(String loginOrId) {


      User foundUser = DataBase.users.stream().filter(user -> user.getLogin().equals(loginOrId)||user.getId()
              .equals(loginOrId)).findFirst().get();


      Scanner input = new Scanner(System.in);


      System.out.println("----------Сброс пароля-----------------------");

      System.out.println("=============================================");

      System.out.println("------------User_info:-----------------------");

      System.out.println("=============================================");

      System.out.printf("user_id:  %s %n", foundUser.getId());

      System.out.printf("user_login:  %s %n", foundUser.getLogin());


      // проверка пароля на корректность
      // проверка на отсутствие повторяющихся символов

      String password = null;

      Boolean formatRequired ;

      do {

          System.out.printf("new password:");
          password = input.nextLine();

          formatRequired =!(Entrance.checkAllRepeated(password));

          if( formatRequired == false){

              System.out.printf("--Password sequence to be unique--%n");
          }


      } while (Entrance.correctPassword(password) == false || formatRequired == false);

    System.out.printf("Пароль успешно сохранен %n");

         foundUser.setPassword(password);

  }


    public static void rightsPasswordChange(){
        auth(true);

    }}
