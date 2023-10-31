import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {
    private final File file = new File("tour_winners.csv");

    public ArrayList<TourWinner> loadAllWinners() {
        ArrayList<TourWinner> winners = new ArrayList();
        Scanner sc = null;
        try {
            sc = new Scanner(file);
            sc.nextLine();  // Skip første linje

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        TourWinner winner = null;
        while (sc.hasNext()) {
            String line = sc.nextLine();    // Split linje og læg tokens i attributter
            String[] attributes = line.split(",");
            winner = new TourWinner(
                    (Integer.parseInt(attributes[0])), // year
                    (attributes[1]), // country
                    attributes[2] // tour winner name
            );

            winners.add(winner);

        }
        sc.close();
        return winners;
    }

}
