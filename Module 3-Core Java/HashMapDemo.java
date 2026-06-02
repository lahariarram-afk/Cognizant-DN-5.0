import java.util.*;
class HashMapDemo{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        HashMap<Integer,String> map=new HashMap<>();
        System.out.println("Enter the number of elements");
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            System.out.println("Enter Student ID: ");
            int id= sc.nextInt();
            System.out.println("Enter the student name:");
            String name=sc.next();
            map.put(id,name);
        }
        System.out.println("Student details");
        for(Map.Entry<Integer,String> entry: map.entrySet()){
            System.out.println("ID : "+entry.getKey()+", Name: "+entry.getValue());
        }
        System.out.println("Retrieve details based on id\n enter id");
        int searchid=sc.nextInt();
        if(map.containsKey(searchid)){
            System.out.println("Student found: "+map.get(searchid));
        }else{
            System.out.println("No student found with ID "+searchid);
        }
    }
}