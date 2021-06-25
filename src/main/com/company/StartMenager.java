package main.com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class StartMenager {

    public  static void  loading() {

        Scanner input = new Scanner(System.in);

        System.out.println("=====Выбирете необходимое действие:==========");

        System.out.println("Press '1' - Регистрация");
        System.out.println("Press '2' - Авторизация");
        System.out.println("Press '3' - Смена пароля");

        System.out.println("Press '0' - Выход");

        System.out.println("=============================================");

        try {

            Byte selection = input.nextByte();

        switch (selection) {
            case (1):
                UserRegistration.registration();
                loading();
                break;

            case (2):
                Entrance.auth(false);
                break;

            case (3):
                UserPasswordManager.rightsPasswordChange(); // запрашиваем доступ на  редактирование  пароля
                loading();
                break;

            case (0):

                System.exit(0);

                break;

            default: System.out.println("---- Клавиши доступа: { '1','2','3','0'} -------");
                System.out.println("=============================================");
                loading();
                break;
        }

        } catch (InputMismatchException exception){
            System.out.println("--------Некорректный ввод данных-------------");
            System.out.println("=============================================");
            loading();

    }

    }

}
