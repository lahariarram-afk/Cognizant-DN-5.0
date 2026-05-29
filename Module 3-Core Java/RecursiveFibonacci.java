import java.util.*;
class RecursiveFibonacci {
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the positive integer");
        int n=sc.nextInt();
        System.out.println("Fibonacci of "+n+ " = "+fib(n));
    }
    static int fib(int n){
        if(n==0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        return fib(n-1)+fib(n-2);
        
    }
}