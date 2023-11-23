package entities;

public class Notification {
    private String title;
    private String content;
    private int idUserName;

    public Notification() {
    }

    public Notification(int idUserName) {
        this.idUserName = idUserName;
    }

    public Notification(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public int getIdUserName() {
        return idUserName;
    }

    public void setIdUserName(int idUserName) {
        this.idUserName = idUserName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return
                " " + title +
                        " - " + content;
    }
}
