import p.labs.Lab04A.*;

import java.util.Scanner;

public class Lab04A {
    public static void main(String[] args) {
        if(Test()) {
            System.out.println("Тест пройден");
            program();
        }
        else System.out.println("Тест провален");
    }

    public static boolean Test(){
        TestClass t = new TestClass();
        if(t.TestFlowerBlossomed() & t.TestFlowerWithered())
            return true;
        return false;
    }

    public static void program(){
        Flower flower1 = new Flower();
        flower1.setColor_bud("зеленый");
        flower1.setName("Лилия");
        flower1.setSort("Садовая");
        Flower flower2 = new Flower("Роза", "Английская", "зеленый", "красный", "круглая", 10);
        boolean b = true;
        while (b) {
            switch (menu()) {
                case 1: {
                    System.out.println(flower1);
                    System.out.println(flower2);
                    break;
                }
                case 2: {
                    flowerBlossomed(flower1);
                    break;
                }
                case 3: {
                    flowerWithered(flower2);
                    break;
                }
                case 4: {
                    b = false;
                    break;
                }
            }
        }
    }

    public static int menu(){
        Scanner in = new Scanner(System.in);
        String[] menu = new String[] {"Меню: ", "1. Цветы", "2. Расцвести",
                "3. Завять", "4. Выход" };
        System.out.println();
        for(int i = 0; i < 5; i++)
            System.out.println(menu[i]);
        int choice = in.nextInt();
        return choice;
    }

    public static void flowerBlossomed(Flower flower){
        String color = "голубой";
        String form = "круг";
        int n = 5;
        if(flower.blossom(color, form, n))
            System.out.println("Цветок расцвел");
        else
            System.out.println("Цветок уже расцвел");
        System.out.println(flower);
    }

    public static void flowerWithered(Flower flower){
        if(flower.wither())
            System.out.println("Цветок завял");
        else
            System.out.println("Цветок еще не расцвел");
        System.out.println(flower);
    }

}
