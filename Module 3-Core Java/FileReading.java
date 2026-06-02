
import java.io.*;

class FileReading {
    public static void main(String args[]){
        try {
            BufferedReader reader=new BufferedReader(new FileReader("output.txt"));
            String line;
            System.out.println("Contents of output.txt");
            while ((line = reader.readLine())!=null){
                System.out.println(line);
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("error");
            e.printStackTrace();
        }
    }
}