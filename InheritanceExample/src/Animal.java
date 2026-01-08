public class Animal {
    void makeSound(){
        System.out.println("Animal Sounds");
    }
}

class Dog extends Animal{
    @Override
    void makeSound(){
        System.out.println("bark bark");
    }
}

class Cat extends Animal{
    @Override
    void makeSound(){
        System.out.println("meow meow");
    }
}

class Main{
    static void main() {
        Animal animal = new Animal();
        animal.makeSound();

        Animal dog =new Dog();
        dog.makeSound();

        Animal cat = new Cat();
        cat.makeSound();
    }

}
