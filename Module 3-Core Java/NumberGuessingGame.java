import java.util.*;
class NumberGuessingGame {
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        int randomNum=(int)(Math.random()*100)+1;
        System.out.println("Enter the number between 1 and 100");
        while(true){
            int num=sc.nextInt();
            if(num>randomNum){
                System.out.println("Too High");
            }else if(num<randomNum){
                System.out.println("Too Low");
            }else{
                System.out.println("Correct");
                break;

            }

        }
    }
}