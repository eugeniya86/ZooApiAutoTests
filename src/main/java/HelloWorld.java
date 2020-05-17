import pets.Animal;
import pets.Cat;

public class HelloWorld {
    public static String HELLO_WORLD = "name";

    public static void helloWorld() {
        System.out.println(HELLO_WORLD);
    }

    public static void testAnimal(Animal animal) {
        if (animal.isWild()) {
            System.out.println("дикое");
        } else {
            System.out.println("домашнее");
        }
    }
}
