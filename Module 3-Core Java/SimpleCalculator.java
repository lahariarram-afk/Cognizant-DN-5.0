import java.util.*;
class SimpleCalculator {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter first number");
        int num1=sc.nextInt();
        System.out.println("Enter second number");
        int num2=sc.nextInt();
        System.out.println("Enter the operation ( + , - , * , / )");
        String op=sc.next();
        if(op.equals("+")){
            System.out.println(num1+num2);
        }else if(op.equals("-")){
            System.out.println(num1-num2);
        }else if(op.equals("*")){
            System.out.println(num1*num2);
        }else if(op.equals("/")){
            if(num2==0){
                System.out.println("Division not allowed");
            }else{
                System.out.println(num1/num2);
            }
        }else{
            System.out.println("Invalid operator");
        }
    }
}