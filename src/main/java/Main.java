import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        FileHandler fh = new FileHandler();

        //load tour winners
        ArrayList<TourWinner> winners = fh.loadAllWinners();

        // display tour winners
        for (TourWinner winner: winners) {
            System.out.println(winner);
        }
    }
}
