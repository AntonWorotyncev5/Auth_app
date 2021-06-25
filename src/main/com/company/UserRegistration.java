package main.com.company;

import java.util.Scanner;
import java.util.UUID;


public class UserRegistration implements DataBase{


    public static void registration(){

        Scanner input = new Scanner(System.in);

        User user = new User();

        System.out.println("=============================================");

        System.out.println("Регистрация...");

        System.out.printf("login:");

        user.setLogin(input.nextLine());


        String password = null;

        boolean formatRequired ;

        do {

            System.out.printf("password:");
            password = input.nextLine();

             formatRequired = !(Entrance.checkAllRepeated(password));

            if( formatRequired == false){

                System.out.printf("--Password sequence to be unique--%n");
            }

        } while (Entrance.correctPassword(password) == false||formatRequired == false);

        user.setPassword(password);

        System.out.printf("Место рождения (город):");

        user.setPlaceOfBirth(input.nextLine());

        System.out.printf("Номер телефона:");

        user.setPhoneNumber(input.nextLine());

        user.setId(UUID.randomUUID().toString());

        System.out.printf("Сохранить? (Press Enter)");

        if (input.nextLine().isEmpty()) {

            DataBase.users.add(user);

        System.out.println("Пользователь добавлен");

        System.out.printf("id = %s (Необходим авторизации)", user.getId()); // id для входа , записать


            }

        System.out.println();
        System.out.println("=============================================");


    }


}
