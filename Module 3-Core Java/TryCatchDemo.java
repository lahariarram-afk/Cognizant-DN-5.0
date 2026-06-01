import java.util.*;
class TryCatchDemo {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n1=sc.nextInt();
        int n2=sc.nextInt();
        try {
            int res=n1/n2;
            System.out.println("The Result is "+res);
        } catch ( ArithmeticException e) {
            System.out.println("It is not divided becoz the 2nd interger is 0");
        }
        
    }
}