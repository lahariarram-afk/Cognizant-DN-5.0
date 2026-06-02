import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
class FileWriting {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        try {
            FileWriter writer=new FileWriter("output.txt");
            writer.write(str);
            writer.close();
            System.out.println("Data has been written to output.txt");
        } catch (IOException e) {
            System.out.println("error");
            e.printStackTrace();
        }

    }
}