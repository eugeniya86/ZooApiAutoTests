import pets.Cat;
import pets.Fish;
import pets.Wolf;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.print("кошка ");
        HelloWorld.testAnimal(new Cat());

        System.out.print("волк ");
        HelloWorld.testAnimal(new Wolf());

        System.out.print("рыбка ");
        HelloWorld.testAnimal(new Fish());
    }
}
