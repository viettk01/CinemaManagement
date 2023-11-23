package entities.movie;

public class Bill {

    private String movieName;
    private String number;
    private double price;

    public Bill(String movieName, String number, double price) {
        this.movieName = movieName;
        this.number = number;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }


    @Override
    public String toString() {
        return "Bill[" +
                "Tên Phim: " + movieName +
                " number: " + number +
                " price: " + price +
                ']';
    }
}
