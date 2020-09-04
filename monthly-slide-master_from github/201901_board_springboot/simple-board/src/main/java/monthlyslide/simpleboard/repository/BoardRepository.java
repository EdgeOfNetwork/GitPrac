package monthlyslide.simpleboard.repository;

import monthlyslide.simpleboard.domain.Board;

import java.util.List;

public interface BoardRepository {
    long count();
    void save(Board board);
    void delete(Long id);
    Board findById(Long id);
    List<Board> findAll();
}
