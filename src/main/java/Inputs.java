import javafx.util.Pair;

public class Inputs {
    int Xm;
    Pair<Integer,Integer> Xn,Xxor1;
    Pair<Integer,Integer> Xxor2;
    public Inputs(){
        this.Xn = new Pair<>(0,0);this.Xxor1=new Pair<>(0,0);this.Xxor2 = new Pair<>(0,0);this.Xm=0;
    }
    public int getXm(){return Xm;}
    public Pair<Integer, Integer> getXxor1(){return Xxor1;}
    public Pair<Integer, Integer> getXxor2(){return Xxor2;}
    public void setXn(Pair<Integer,Integer> xn){this.Xn=xn;}
    public void setXm(int xm){this.Xm=xm;}
    public void setXxor1(Pair<Integer,Integer> xxor1){this.Xxor1=xxor1;}
    public void setXxor2(Pair<Integer,Integer> pair){this.Xxor2=pair;}
}
