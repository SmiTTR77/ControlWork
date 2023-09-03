import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static ArrayList<Toy> toyList = new ArrayList<>();
    static ArrayList<Toy> prizeList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        mainMenu(toyList, prizeList);
    }

    public static void mainMenu(ArrayList<Toy> toyList, ArrayList<Toy> prizeList) throws IOException {
        Scanner sc = new Scanner(System.in);

        String infoMsg = """
                Меню:\s
                1. Добавить игрушку в список\s
                2. Посмотреть список игрушек\s
                3. Провести розыгрыш\s
                4. Посмотреть список призов\s
                5. Выдать приз\s
                
                0. Выход\s""";

        System.out.println("-------------------------------");
        System.out.println(infoMsg);
        System.out.println("-------------------------------");

        switch (Integer.parseInt(sc.nextLine())) {
            case 1 -> {
                addToy(toyList);
                mainMenu(toyList, prizeList);
            }
            case 2 -> {
                printAndSaveToFile(toyList, "toysList", " наименование(я)");
                mainMenu(toyList, prizeList);
            }
            case 3 -> {
                prizeDraw(toyList, prizeList);
                mainMenu(toyList, prizeList);
            }
            case 4 -> {
                printAndSaveToFile(prizeList, "prizeList", " шт");
                mainMenu(toyList, prizeList);
            }
            case 5 -> {
                getPrize(prizeList);
                mainMenu(toyList, prizeList);
            }

            case 0 -> System.exit(0);
        }
        sc.close();
    }

    public static void addToy(ArrayList<Toy> toyList) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Введите id игрушки:");
        int id = Integer.parseInt(sc.nextLine());

        System.out.println("Введите название игрушки:");
        String name = sc.nextLine();

        System.out.println("Введите количество игрушек:");
        int quantity = Integer.parseInt(sc.nextLine());

        System.out.println("Введите вес игрушки:");
        int weight = Integer.parseInt(sc.nextLine());

        toyList.add(new Toy(id, name, quantity, weight));

    }

    public static void prizeDraw(ArrayList<Toy> toyList, ArrayList<Toy> prizeList) throws IOException {
        Scanner sc = new Scanner(System.in);
        ArrayList<Toy> randomToys = new ArrayList<>();

        for (int i = 0; i < toyList.size(); i++) {
            for (int j = 0; j < toyList.get(i).weight; j++) {
                if (toyList.get(i).quantity != 0)
                    randomToys.add(toyList.get(i));
            }
        }

        System.out.println("Введите количество игрушек для розыгрыша:");
        int quantityPrize = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < quantityPrize; i++) {
            int prize = new Random().nextInt(randomToys.size());

            while (randomToys.get(prize).quantity == 0) {
                prize = new Random().nextInt(randomToys.size());
            }

            randomToys.get(prize).quantity -= 1;
            prizeList.add(randomToys.get(prize));
        }

        randomToys.clear();
    }

    public static void getPrize(ArrayList<Toy> prizeList){
        prizeList.remove(0);
        System.out.println("Приз - " + prizeList.get(0).getInfo() + " выдана!");
    }

    public static void printAndSaveToFile(ArrayList<Toy> newList, String name, String endMsg) throws IOException {
        FileWriter fw = new FileWriter("ToyStore/src/main/java/" + name + ".txt");

        for (int i = 0; i < newList.size(); i++) {
            fw.write(newList.get(i).getInfo() + "\n");
            System.out.println(newList.get(i).getInfo());
        }
        System.out.println("Всего: " + newList.size() + endMsg);

        fw.close();
    }

}