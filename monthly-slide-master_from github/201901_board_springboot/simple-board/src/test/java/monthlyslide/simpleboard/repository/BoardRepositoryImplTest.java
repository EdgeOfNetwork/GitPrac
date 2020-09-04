package monthlyslide.simpleboard.repository;

import monthlyslide.simpleboard.domain.Board;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@JdbcTest
@Import(BoardRepositoryImpl.class)
public class BoardRepositoryImplTest {
    @Autowired
    private BoardRepository repository;

    @Test
    public void count() {
        assertThat(repository.count()).isEqualTo(0);
    }

    @Test
    public void save() {
        Board board = new Board("제목", "내용");
        repository.save(board);
        assertThat(repository.count()).isEqualTo(1);
    }

    @Test
    public void findAll() {
        List<Board> list = saveAndGetBoards();
        assertThat(list.size()).isEqualTo(1);
    }

    @Test
    public void delete() {
        List<Board> list = saveAndGetBoards();
        repository.delete(list.get(0).getId());
        long count = repository.count();
        assertThat(count).isEqualTo(0);
    }

    private List<Board> saveAndGetBoards() {
        save();
        return repository.findAll();
    }

    @Test
    public void findById() {
        List<Board> list = saveAndGetBoards();
        Board board = repository.findById(list.get(0).getId());
        assertThat(board.getTitle()).isEqualTo("제목");
        assertThat(board.getContent()).isEqualTo("내용");
    }
}