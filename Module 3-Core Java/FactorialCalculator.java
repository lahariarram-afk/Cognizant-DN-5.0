import java.util.*;
class FactorialCalculator {
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the non-Negative Integer");
        int num=sc.nextInt();
        long fact=1;
        for(int i=2;i<=num;i++){
            fact*=i;
        }
        System.out.println("Factorial of "+num+" = "+fact);
    }
}