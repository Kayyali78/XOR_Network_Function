import javafx.util.Pair;

public class State {
    int Sxor1,Sxor2;
    Pair<Integer, Integer> Smem;

    public State(){
        this.Sxor1=0;this.Sxor2=0;this.Smem = new Pair<>(0,0);
    }
    public int getSxor1(){return Sxor1;}
    public int getSxor2(){return Sxor2;}
    public Pair<Integer,Integer> getSmem(){return Smem;}
    public void setSxor1(int x) {this.Sxor1 = x;}
    public void setSxor2(int x) {this.Sxor2 = x;}
    public void setSmem(Pair<Integer,Integer> newPair){this.Smem = newPair;}
}
