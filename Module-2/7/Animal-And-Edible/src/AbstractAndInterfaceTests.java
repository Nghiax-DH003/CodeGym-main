import animal.Animal;
import animal.Chicken;
import animal.Tiger;
import edible.Edible; // Import interface Edible
import edible.Fruit; // Import lớp trừu tượng Fruit
import edible.Orange; // Import lớp Orange
import edible.Apple;  // Import lớp Apple

public class AbstractAndInterfaceTests {
    public static void main(String[] args) {
        // Kiểm thử các lớp Animal và makeSound()
        System.out.println("--- Kiểm thử Animal và makeSound() ---");
        Animal[] animals = new Animal[2];
        animals[0] = new Tiger() {
            @Override
            public String howToEat() {
                return "";
            }
        };
        animals[1] = new Chicken();
        for (Animal animal : animals) {
            System.out.println(animal.makeSound());
        }

        System.out.println("\n------------------------------------\n");

        // Kiểm thử các lớp Edible và howToEat()
        System.out.println("--- Kiểm thử Edible và howToEat() ---");

        // Tạo đối tượng Chicken (là Animal và Edible)
        Chicken chicken = new Chicken();
        System.out.println("Chicken nói: " + chicken.makeSound());
        System.out.println("Chicken ăn được: " + chicken.howToEat());

        // Tạo đối tượng Orange (là Fruit và Edible)
        Orange orange = new Orange();
        System.out.println("Cam ăn được: " + orange.howToEat());

        // Tạo đối tượng Apple (là Fruit và Edible)
        Apple apple = new Apple();
        System.out.println("Táo ăn được: " + apple.howToEat());

        // Có thể tạo một mảng Edible
        Edible[] edibles = new Edible[3];
        edibles[0] = new Chicken();
        edibles[1] = new Orange();
        edibles[2] = new Apple();

        System.out.println("\n--- Duyệt qua mảng Edible ---");
        for (Edible edibleItem : edibles) {
            System.out.println(edibleItem.howToEat());
        }

        // Kiểm tra instanceOf
        System.out.println("\n--- Kiểm tra instanceof ---");
        if (chicken instanceof Animal) {
            System.out.println("chicken là một Animal.");
        }
        if (chicken instanceof Edible) {
            System.out.println("chicken là một Edible.");
        }
        if (orange instanceof Fruit) {
            System.out.println("orange là một Fruit.");
        }
        if (orange instanceof Edible) {
            System.out.println("orange là một Edible.");
        }
    }
}