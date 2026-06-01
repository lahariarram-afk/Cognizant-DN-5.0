interface Playable {
    void play();
}
class Guitar implements Playable {
    public void play(){
        System.out.println("Playing the guitar ");
    }
}

class Piano implements Playable {
    public void play(){
        System.out.println("playing the piano");
    }
}
class InterfaceDemo {
    public static void main(String args[]){
        Guitar g1=new Guitar();
        g1.play();

        Piano p1=new Piano();
        p1.play();
    }
}
