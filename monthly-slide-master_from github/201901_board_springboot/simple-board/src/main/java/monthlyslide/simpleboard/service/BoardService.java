package monthlyslide.simpleboard.service;

import monthlyslide.simpleboard.domain.Board;

import java.util.List;

public interface BoardService {
    void create(Board board);
    List<Board> list();
    Board detail(Long id);
    void remove(Long id);
}
