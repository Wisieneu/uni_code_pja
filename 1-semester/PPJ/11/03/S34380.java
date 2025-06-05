public class S34380 {
    public static void main(String[] args) {
        Cat cat1 = new Cat();
        cat1.makeSound();
        Animal animal1 = new Animal("Cat"); // nadanie nazwy species nie powoduje zmiany typu
        animal1.makeSound();

        Animal animal2 = new Animal("Dog");
        Animal animal3 = new Animal("Cow");
        Animal animal4 = new Animal("Eagle");

        animal2.makeSound();
        animal3.makeSound();
        animal4.makeSound();

        Dog dog1 = new Dog();
        Cow cow1 = new Cow();
        dog1.makeSound();
        cow1.makeSound();
    }
}

class Animal {
    protected String species;

    public Animal(String species) {
        this.species = species;
    }

    public void makeSound() {
        System.out.println("Unknown");
    }
}

class Cat extends Animal {
    public Cat() {
        super("Cat");
    }

    @Override
    public void makeSound() {
        System.out.println("Meow");
    }
}

class Dog extends Animal {
    public Dog() {
        super("Dog");
    }

    @Override
    public void makeSound() {
        System.out.println("Woof");
    }
}

class Cow extends Animal {
    public Cow() {
        super("Cow");
    }

    @Override
    public void makeSound() {
        System.out.println("Moo");
    }
}