package entities.movie;

public class Rate {
    private int idCustomer;
    private String nameCustomer;
    private String comment;
    private int starPoint;

    public Rate(int idCustomer, String nameCustomer, String comment, int starPoint) {
        this.idCustomer = idCustomer;
        this.nameCustomer = nameCustomer;
        this.comment = comment;
        this.starPoint = starPoint;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getStarPoint() {
        return starPoint;
    }

    public void setStarPoint(int starPoint) {
        this.starPoint = starPoint;
    }

    @Override
    public String toString() {
        return "Rate{" +
                "nameCustomer='" + nameCustomer + '\'' +
                ", starPoint=" + starPoint +
                ", comment='" + comment + '\'' +
                '}';
    }
}
