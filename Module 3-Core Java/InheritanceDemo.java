class Animal{
    void makeSound() {
        System.out.println("Animal makes sound");
    }
}
class Dog extends Animal{
    void makeSound(){
        System.out.println("Dog makes Bark sound");
    }
}
class InheritanceDemo {
    public static void main(String args[]){
        Animal ani=new Animal();
        ani.makeSound();

        Dog dog=new Dog();
        dog.makeSound();
    }
}