import java.util.List;

public class Main {

    public static void main(String[] args) {
        FileHandler fh = new FileHandler();

        //load Covid 19 data
        List<Covid19Data> data = fh.loadAll();

        // display covid 19 data
        for (Covid19Data dataPiece : data) {
            System.out.println(dataPiece);
        }
    }
}
