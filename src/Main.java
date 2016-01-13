import java.util.ArrayList;

/**
 * Created by K on 01.01.2016.
 */
public class Main {
    public static void main(String[] args) {


        int [] a=new int[36];
        int k=0;

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                a[k]=j;
                k++;
            }

        }
        k=0;
        DrunkEngine.shake(a);




        Player p1=new Player();
        Player p2=new Player();
        for (int i = 0; i < a.length; i++) {
            if (i%2==0) p1.add(a[i]);
            else p2.add(a[i]);
        }
/*
        System.out.println(p1.toString()+" "+p1.getSize());
        System.out.println(p2.toString()+" "+p2.getSize());
        for (int i = 0;  p1.getSize()-1>0; i++) {
            System.out.println(p1.get());
            System.out.println(p1.toString()+" "+p1.getSize());

        }
        p1.addPlay(p2);
        System.out.println(p1);*/

        Player play=new Player();

        while ((k<1000)&&(p1.getSize()>0)&&(p2.getSize()>0)){

            int tmp1, tmp2;
            tmp1=p1.get();
            tmp2=p2.get();
            int [] b=new int[2];
            b[0]=tmp1;
            b[1]=tmp2;
            DrunkEngine.shake(b);
           play.add(b[0]);
            play.add(b[1]);
            System.out.println(p1.toString()+" "+p1.getSize());
            System.out.println(p2.toString()+" "+p2.getSize());
            System.out.println("p1:"+tmp1+" p2 :"+tmp2);


            if (tmp1>tmp2) {
                p1.addPlay(play);
                play.clear();
            }
            else if (tmp2>tmp1) {
                p2.addPlay(play);
                play.clear();
            }

            System.out.println(p1.getSize()+" "+p2.getSize());
            System.out.println(k);

            k++;


        }




    }



}

class DrunkEngine {
    Player [] players;

    static void shake(int a[]){
        int tmp, ndx;

        for (int j = 0; j < 3; j++) {

            for (int i = 0; i < a.length; i++) {
                ndx=(int)(Math.random()*a.length);
                tmp=a[ndx];
                a[ndx]=a[i];
                a[i]=tmp;
            }
        }

    }

    public DrunkEngine(Player ... p){
        for (int i = 0; i < p.length; i++) {
            players[i]=p[i];
        }
    }

    public void gO(){

        while (this.winDetector()){



        }

    }

    public boolean winDetector(){
        boolean flag=true;
        int x=0;

        for (int i = 0; i < players.length; i++) {
            if (players[i].getSize()>0) x++;
        }
        if (x<2) flag=false;

        return flag;
    }



}

class Player{
    private ArrayList cards;


    public Player(ArrayList cards) {
        this.cards = cards;

    }

    public Player(){
        this.cards=new ArrayList();
    }

    public void add(int a){
        this.cards.add(a);
    }
    public int get(){
        int tmp= (int) this.cards.get(this.cards.size()-1);
        this.cards.remove(this.cards.size()-1);
        return tmp;
    }

    public void addPlay(Player p){
        ArrayList tmp=new ArrayList();
        tmp.addAll(this.cards);
        this.cards.clear();
        this.cards.addAll(p.cards);
        this.cards.addAll(tmp);


    }

    public void clear(){
        this.cards.clear();
    }


    public int getSize(){
        return this.cards.size();
    }

    @Override
    public String toString() {
        return "Player{" +
                "cards=" + cards +
                '}';
    }
}
