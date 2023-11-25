package entities.movie;

public class Bill {
    private int idUser;
    private int movieId;
    private String movieName;
    private String number;
    private double price;

    public Bill(int idUser ,int movieId, String movieName, String number, double price) {
        this.idUser = idUser;
        this.movieId = movieId;
        this.movieName = movieName;
        this.number = number;
        this.price = price;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
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
        return "HÓA ĐƠN [" +
                "Tên Phim: " + movieName +
                " | Số ghế: " + number +
                " | Giá vé: " + price +
                ']';
    }
}
