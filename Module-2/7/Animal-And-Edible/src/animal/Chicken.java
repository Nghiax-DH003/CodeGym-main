package animal;

import edible.Edible;

public class Chicken extends Animal implements Edible { // Chicken kế thừa từ Animal
    @Override
    public String makeSound() {
        return "Chicken: cluck-cluck!"; // Triển khai cụ thể phương thức makeSound()
    }

    @Override
    public String howToEat(){
        return "Could be fried";
    }
}