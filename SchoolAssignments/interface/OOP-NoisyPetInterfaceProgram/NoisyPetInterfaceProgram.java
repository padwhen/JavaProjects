/**
 * NoisyPetInterfaceProgram
 */
interface NoisyPet {
    public void makeSound();
    public void play();
}

class Cat implements NoisyPet{
    @Override
    public void play() {
        System.out.println("Cat is playing with the ball of yarn.");
    }
    @Override
    public void makeSound() {
        System.out.println("Cat says meow!");
    }
}

class Dog implements NoisyPet {
    @Override
    public void play() {
        System.out.println("Dog is fetching the ball");
    }
    @Override
    public void makeSound() {
        System.out.println("Dog says woof, woof!");
    }
}

class Parrot implements NoisyPet {
    @Override
    public void play() {
        System.out.println("Parrot is flying around.");
    }
    @Override
    public void makeSound() {
        System.out.println("Parrot says 'Polly wants a cracker'");
    }
}

public class NoisyPetInterfaceProgram {
    public static void main(String[] args) {
        NoisyPet[] pets = new NoisyPet[3];
        pets[0] = new Cat();
        pets[1] = new Dog();
        pets[2] = new Parrot();
        for (NoisyPet pet : pets) {
            pet.makeSound();
        }
        for (NoisyPet pet : pets) {
            pet.play();
        }
    }
}