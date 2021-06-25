package main.com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Entrance {

    public static void auth( Boolean editingProperties ) {  // если в авторизация совершена
                                                             // с целью редактирования пароля
                                                             //  editingProperties = true
        Scanner in = new Scanner(System.in);

        System.out.println("=============================================");

        System.out.println("Аутентификация.. ");

        System.out.println("Введите логин или (ID):");

        String login = in.nextLine();

        String password;

        do {

            System.out.println("Введите пароль:");
            password = in.nextLine();

            System.out.println("=============================================");

         } while (correctPassword(password) == false);

       boolean accessRights = AccessManager.dataСhecking(password,login); // отправляем на аутентификацию

        if (accessRights == true && editingProperties == false) { // если аутеинтифакация успешно пройдена
                                                                 // без параметра редактирования
                FileManager.loadingFileMenu(); // допускаем пользователя к меню работы с файлом

        }


            if (accessRights == true && editingProperties == true) {    // если аутеинтифакация успешно пройдена
                                                            // c параметром редактирования
                UserPasswordManager.editingPassword(login); // допускаем пользователя к смене пароля

        } else {

            System.out.println("-------Отказано в доступе---------");

        }

}

    public static boolean isAlpha(String name) {
        return name.matches("[a-zA-Z]+");
    }


    public static boolean correctPassword(String password) {

        Boolean correct = false;

        int StandardPasswordLength = 6;

        try {

            if ((isAlpha(password) == false) || (password.length() != StandardPasswordLength))
                throw new Exception("-- incorrect password (" + " Requirements: " +
                        "password.length = 6, " +
                        "only Latin letters are used in any case) --" );
            else correct = true;


        } catch (Exception exception) {

            System.out.println(exception.getMessage());

        }

        return correct;
    }


    public static boolean checkAllRepeated(String input) {

        boolean answer = true;

        Map<Character, Integer> unique = new HashMap<>();
        for(Character aChar : input.toCharArray()){
            if(unique.get(aChar) != null) {unique.put(aChar, unique.get(aChar) + 1);}
            else { unique.put(aChar, 1); }
        }
        if( unique.containsValue(1)) answer = false;
            return answer ;
        }

    }



