import java.util.*;
class ArrayListDemo {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        ArrayList<String> list=new ArrayList<>();
        System.out.println("Enter number of elements in an array");
        int n=sc.nextInt();
        System.out.println("Enter elements in an array");
        for(int i=0;i<n;i++){
            list.add(sc.next());
        }
        for(String str:list){
            System.out.print(str+" ");
        }
    }
}