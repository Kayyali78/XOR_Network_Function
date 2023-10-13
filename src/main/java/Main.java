import java.util.Scanner;

public class Main {
    static Network[] networks;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter in the number of tics per machine cycle: ");
        int tics = scanner.nextInt();
        System.out.println("Enter in the number of network components: ");
        int numNetworks = scanner.nextInt();

        while (numNetworks<1){
            System.out.println("You must have at least one network component. Try again");
            numNetworks = scanner.nextInt();
        }
        networks = new Network[numNetworks];

        for (int i=0;i<numNetworks;i++){
            networks[i] = new Network(tics);
        }

        while (true) {
            for (Network network : networks) {
                network.takeInputs();
                for (int i = 0; i < tics; i++) {
                    network.delta(network.state);
                    network.lambda(network.inputs);
                }
            }
        }
    }
}
