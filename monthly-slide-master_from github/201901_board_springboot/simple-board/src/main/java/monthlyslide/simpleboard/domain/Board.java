package monthlyslide.simpleboard.domain;

public class Board {
    private long id;
    private String title;
    private String content;

    public Board(long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public Board(String title, String content) {
        this.id = 0;
        this.title = title;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
        return "Board{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}