package Session10;

class Animal {
    protected String name;

    public void makeSound() {
        System.out.println("Some animal sound");
    }
}

class Dog extends Animal {
    public Dog(String name) {
        this.name = name;
    }
}

public class AnimalToDogInheritance {
    public static void main(String[] args) {
        Dog d = new Dog("Buddy");
        d.makeSound();
    }
}
