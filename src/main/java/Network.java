import javafx.util.Pair;

import java.util.Scanner;

public class Network {
    int ticks = 0;
    State state = new State();
    Outputs outputs = new Outputs();
    Inputs inputs = new Inputs();

    public Network(int tics){
        this.ticks = tics;
    }

    public void takeInputs(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter bit inputs: ");
        char[] keys = scanner.nextLine().toCharArray();
        int x = keys[0];
        int y = keys[1];
        inputs.setXn(new Pair<>(x,y));
        inputs.setXxor1(new Pair<>(x,y));
    }
    private int XOR(int b1, int b2){
        if (b1 == b2){
            return 0;
        } else {
            return 1;
        }
    }

    public void delta(State state1){
        outputs.setYxor1(state1.getSxor1());
        outputs.setYxor2(state1.getSxor2());
        outputs.setYm(state1.getSmem().getKey());
        outputs.setYn(state1.getSxor2());
        System.out.println("-------------delta start----------------------");
        System.out.println("XOR1 output: "+outputs.getYxor1());
        System.out.println("Network and XOR2 output: "+outputs.getYxor2());
        System.out.println("Memory output: "+outputs.getYm());
        System.out.println("-------------delta end----------------------");
        couple(outputs);
    }

    private void couple(Outputs outputs1){
        inputs.setXxor2(new Pair<>(outputs1.getYxor1(),outputs.getYm()));
        inputs.setXm(outputs.getYxor2());
    }

    public void lambda(Inputs inputs1){
        Pair<Integer,Integer> pairXOR1 = inputs1.getXxor1();
        int newXOR1 = XOR(pairXOR1.getKey(), pairXOR1.getValue());
        System.out.println("-------------lambda start----------------------");
        if (newXOR1 != state.getSxor1()){
            System.out.println("State of XOR1 changed from "+state.getSxor1()+" to "+newXOR1);
        }
        state.setSxor1(newXOR1);
        Pair<Integer,Integer> pairXOR2 = inputs1.getXxor2();
        int newXOR2 = XOR(pairXOR2.getKey(), pairXOR2.getValue());
        if (newXOR2 != state.getSxor2()){
            System.out.println("State of XOR2 changed from "+state.getSxor2()+" to "+newXOR2);
        }
        state.setSxor2(newXOR2);
        Pair<Integer,Integer> newMemState = new Pair<>(state.getSmem().getValue(),inputs1.getXm());
        System.out.println("Memory state changed from "+state.getSmem()+" to "+newMemState);
        System.out.println("-------------lambda end----------------------");
        state.setSmem(newMemState);
    }
}
