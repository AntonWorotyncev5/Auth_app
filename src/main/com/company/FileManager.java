package main.com.company;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileManager {

    public static void loadingFileMenu() {

        final String nameFile = "notes.txt";

        Scanner input = new Scanner(System.in);

        System.out.println("=============================================");

        System.out.println("Выбирете необходимое действие:");

        System.out.println ("Press '1' - Запись в файл");
        System.out.println("Press '2' - Чтение файла");

        System.out.println("Press '0' - Выход");

        System.out.println("=============================================");


        Byte selection = input.nextByte();


        switch (selection) {
            case (1):
                openFileForRecording(nameFile);
                loadingFileMenu();

                break;

            case (2):
                openFileForReading(nameFile);
                loadingFileMenu();

                break;

            case (0):

                System.exit(0);

            default:

                System.out.println("---- Клавиши доступа: { '1','2','0'} -------");
                System.out.println("=============================================");

                break;
        }
    }

    public  static void openFileForRecording(String name_file) {

        Scanner input = new Scanner(System.in);

        try (FileWriter writer = new FileWriter(name_file, true)) // открываем и добавляем файл
        // (!не перезаписываем весь,  добавляем введенное из консоли)

        {

            System.out.println("(**Recording mode**)"); // режим записи , набираем в консоли
            System.out.println(name_file+":");

            writer.write(input.nextLine());

            writer.flush(); // очищаем поток

        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
    }


        public static void openFileForReading (String name_file){


            try (FileReader reader = new FileReader(name_file)) {

                System.out.println("(**Reading mode**)"); // режим чтения файла
                System.out.println(name_file + ":");

                int c;

                while ((c = reader.read()) != -1) {

                    System.out.print((char) c);
                }

                System.out.println();

            } catch (IOException ex) {

                System.out.println(ex.getMessage());
            }
        }
    }


