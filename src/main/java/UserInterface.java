import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class UserInterface {

    private final List<Covid19Data> data;

    public UserInterface() {

        FileHandler fh = new FileHandler("11_noegletal_pr_region_pr_aldersgruppe.csv");
        data = fh.loadAll();
    }

    public void start() {

        System.out.println("""
                
                ---Covid-19 data---
                
                Vis data sorteret efter
                    1) region
                    2) aldersgruppe
                    3) primært region, sekundært aldersgruppe
                    4) primært aldersgruppe, sekundært region
                
                0) Afslut uden at vise data
                """);

        menu();
    }

    private void menu() {

        System.out.print("Indtast menuvalg: ");

        switch ((new Scanner(System.in)).nextLine()) {
            case "0": return;
            case "3": data.sort(Comparator.comparing(Covid19Data::ageInterval));
            case "1": data.sort(Comparator.comparing(Covid19Data::region)); break;
            case "4": data.sort(Comparator.comparing(Covid19Data::region));
            case "2": data.sort(Comparator.comparing(Covid19Data::ageInterval)); break;
            default: {
                System.out.println("Kunne ikke genkende indtastede. Prøv igen.");
                menu();
                return;
            }
        }

        data.forEach(System.out::println);
    }
}