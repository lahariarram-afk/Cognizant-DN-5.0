class MethodOverloadingDemo {
    public static void main(String args[]) {
        System.out.println("Sum of two integers = "+add(2,2));
        System.out.println("Sum of two double values = "+add(2.2,2.2));
        System.out.println("Sum of three integers = "+add(2,2,2));


    }
    static int add(int num1,int num2){
        return num1+num2;
    }
    static double add(double num1,double num2) {
        return num1+num2;
    }
    static int add(int num1,int num2,int num3) {
        return num1+num2+num3;
    }
}