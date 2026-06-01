class Car {
    String make;
    String model;
    int year;

    Car(String make,String model,int year) {
        this.make=make;
        this.model=model;
        this.year=year;
    }
    void displayDetails(){
        System.out.println("Car Information");
        System.out.println("Make:"+make);
        System.out.println("Model:"+model);
        System.out.println("Year:"+year);
    }
}
class ClassObjectCreation {
    public static void main(String args[]){
        Car car1=new Car("Toyota", "Corolla", 2020);
        Car car2 = new Car("Honda", "Civic", 2022);
        car1.displayDetails();
        car2.displayDetails();
    }
}
