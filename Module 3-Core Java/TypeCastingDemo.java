class TypeCastingDemo {
    public static void main(String args[]) {

        //Double -> Int
        double DoubleNum=2.356;
        int IntNum=(int)DoubleNum;
        System.out.println("Before:"+DoubleNum);
        System.out.println("After Typecasting from double to int:"+IntNum);

        //Int -> Double
        int IntNum2=289;
        double DoubleNum2=IntNum2;
        System.out.println("Before:"+IntNum);
        System.out.println("After Typecasting from int to double:"+DoubleNum2);

    }
}