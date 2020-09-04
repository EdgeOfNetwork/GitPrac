package monthlyslide.simpleboard.dto;

import monthlyslide.simpleboard.domain.Board;

public class BoardDto {
    private String title;
    private String content;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Board getBoard() {
        return new Board(this.title, this.content);
    }
}
