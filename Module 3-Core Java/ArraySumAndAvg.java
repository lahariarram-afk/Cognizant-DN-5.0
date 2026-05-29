import java.util.*;
class ArraySumAndAvg {
    public static void main (String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter number of elements");
        int n=sc.nextInt();
        int sum=0;
        int arr[]=new int[n];
        System.out.println("Enter the elements in an array");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
            sum+=arr[i];
        }
        System.out.println("Sum of an array = "+sum);
        System.out.println("Average of an array = "+(sum/n));
    }
}