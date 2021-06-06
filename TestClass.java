package p.labs.Lab04A;

import org.testng.annotations.Test;

public class TestClass {

    @Test
    public static boolean TestFlowerBlossomed(){
        Flower flower_started = new Flower("Роза", "Английская","зеленый", "красный", "круглая", 10);
        flower_started.wither();
        Flower flower_finish = new Flower("Роза", "Английская", "зеленый", "темно красный", "круглая", 0);
        return flower_started.equals(flower_finish);
    }

    @Test
    public static boolean TestFlowerWithered(){
        Flower flower_started = new Flower("Роза", "Английская","зеленый", null, null, 0);
        flower_started.blossom("красный", "круглая", 10);
        Flower flower_finish = new  Flower("Роза", "Английская","красный", "красный", "круглая", 10);
        return flower_started.equals(flower_finish);
    }
}
