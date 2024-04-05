import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileHandler {
    private final File file = new File("11_noegletal_pr_region_pr_aldersgruppe.csv");

    public List<Covid19Data> loadAll() {
        List<Covid19Data> data = new ArrayList<>();
        Scanner sc;
        try {
            sc = new Scanner(file, StandardCharsets.ISO_8859_1);
            sc.nextLine();  // Skip første linje

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Covid19Data dataPiece;
        while (sc.hasNext()) {
            String line = sc.nextLine();    // Split linje og læg tokens i attributter
            String[] attributes = line.split(";");
            if (attributes[0].isBlank()) {
                continue;
            }
            dataPiece = new Covid19Data(
                attributes[0],
                attributes[1],
                Integer.parseInt(attributes[2]),
                Integer.parseInt(attributes[3]),
                Integer.parseInt(attributes[4]),
                Integer.parseInt(attributes[5]),
                attributes[6]
            );
            data.add(dataPiece);

        }
        sc.close();
        return data;
    }

}
