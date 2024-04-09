import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileHandler {

    // Attribute
    private final File file;

    // Constructors
    public FileHandler(File file) {
        this.file = file;
    }

    public FileHandler(String filePath) {
        this.file = new File(filePath);
    }

    // Method
    public List<Covid19Data> loadAll() {

        Scanner scanner;
        try {
            scanner = new Scanner(file, StandardCharsets.ISO_8859_1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        scanner.nextLine(); // Spring første linje over, som bare er overskrifter.
        List<Covid19Data> data = new ArrayList<>();

        while (scanner.hasNext()) {

            String line = scanner.nextLine();
            String[] attributes = line.split(";");

            if (attributes[0].isBlank()) {
                // Hvis der ikke er nogen region, så springer vi linjen over.
                continue;
            }

            Covid19Data datum = new Covid19Data(
                attributes[0],
                attributes[1],
                Integer.parseInt(attributes[2]),
                Integer.parseInt(attributes[3]),
                Integer.parseInt(attributes[4]),
                Integer.parseInt(attributes[5]),
                attributes[6]
            );

            data.add(datum);
        }

        scanner.close();
        return data;
    }
}