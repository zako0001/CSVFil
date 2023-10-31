public class TourWinner {

    private int year;
    private String country;
    private String name;

    public TourWinner(int year, String country, String name) {
        this.year = year;
        this.country = country;
        this.name = name;
    }

    @Override
    public String toString() {
        return "TourWinner{" +
                "year=" + year +
                ", country='" + country + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
