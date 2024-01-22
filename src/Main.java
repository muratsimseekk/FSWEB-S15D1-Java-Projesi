import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class Main {

   private static ArrayList<String> groceryList = new ArrayList<>();
    public static void main(String[] args) {



        int choice ;

        do {
            System.out.println("0 - Cikis yap .");
            System.out.println("1- Eleman ekle .");
            System.out.println("2- Eleman cikart .");
            Scanner scanner = new Scanner(System.in);
            System.out.print("Seçiminizi yapınız: ");
        choice = scanner.nextInt();
            switch (choice){
                case 0:
                    System.out.println("Uygulamadan cikis yapiliyor ...");
                    scanner.close();
                    break;
                case 1:
                    addItem();
                    printSorted();
                    break;
                case 2:
                    removeItems();
                    printSorted();
                    break;
            }


        }while (choice != 0);


    }
    public static void addItem(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Eklenmesini istediginiz elemanlari giriniz . ");

        String input = scanner.nextLine();
        String[] items = input.split(",");

        for (String item : items){
            if (groceryList.contains(item)){
                System.out.println(item + " listede bulunuyor .");
            }
            else {
                groceryList.add(item);
                System.out.println(item + " basariyla eklendi . ");
            }

        }
        Collections.sort(groceryList);


    }
    public static void removeItems (){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Cikarilmasini istediginiz elemanlari giriniz . ");

        String input = scanner.nextLine();
        String[] items = input.split(",");

        for (String item : items){
            if (groceryList.contains(item)){
                groceryList.remove(item);
                System.out.println(item + " basariyla cikartildi . ");
            }
            else {
                System.out.println(item + " listede bulunmuyor .");
            }

        }

    }
    public static void checkItemIsInList(){
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        if (groceryList.contains(input)){
            System.out.println( input + " grocery listesinde bulunuyor . ");
        }
        else {
            System.out.println(input + " grocery listesinde bulunmuyor . ");
        }

    }
    public static void printSorted(){
        System.out.println("Grocery Listesinin Sirlanmis Hali : ");
        Collections.sort(groceryList);
        for (String item : groceryList){
            System.out.println(item);
        }

    }
}