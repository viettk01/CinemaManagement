package entities.movie;

public class Ticket {

    private TicketStatus status;
    private int userId;

    public Ticket(TicketStatus status) {
        this.status = status;
    }

    public Ticket() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public TicketStatus getStatus() {
        return status;
    }

    public void setStatus(TicketStatus status) {
        this.status = status;
    }


    @Override
    public String toString() {
        return  "" + status;
    }
}
