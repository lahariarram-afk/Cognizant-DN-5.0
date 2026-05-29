import java.util.*;
class StringReversal {
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a String");
        String str=sc.next();
        String rev="";
        for(int i=str.length()-1;i>=0;i--){
            rev+=str.charAt(i);
        }
        System.out.println("Reversed string = "+rev);
    }
}

//stringBuilder

// import java.util.*;

// class StringReversal {
//     public static void main(String args[]) {
//         Scanner sc = new Scanner(System.in);
//         System.out.println("Enter a string:");
//         String str = sc.nextLine();
//         String reversed = new StringBuilder(str).reverse().toString();
//         System.out.println("Reversed String: " + reversed);
//     }
// }