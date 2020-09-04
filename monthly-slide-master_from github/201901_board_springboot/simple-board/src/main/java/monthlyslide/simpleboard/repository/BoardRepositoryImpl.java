package monthlyslide.simpleboard.repository;

import monthlyslide.simpleboard.domain.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class BoardRepositoryImpl implements BoardRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public long count() {
        return jdbcTemplate.queryForObject("select count(*) from simple_board", Long.class);
    }

    @Override
    public void save(Board board) {
        jdbcTemplate.update("INSERT INTO SIMPLE_BOARD(TITLE, CONTENT) VALUES (?, ?)", board.getTitle(), board.getContent());
    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update("DELETE SIMPLE_BOARD WHERE ID = ?", id);
    }

    @Override
    public Board findById(Long id) {
        return jdbcTemplate.queryForObject("SELECT ID, TITLE, CONTENT FROM SIMPLE_BOARD WHERE ID = ?", new RowMapper<Board>() {
            @Override
            public Board mapRow(ResultSet resultSet, int i) throws SQLException {
                long id = resultSet.getLong("ID");
                String title = resultSet.getString("TITLE");
                String content = resultSet.getString("CONTENT");
                return new Board(id, title, content);
            }
        }, id);
    }

    @Override
    public List<Board> findAll() {
        return jdbcTemplate.query("SELECT ID, TITLE, CONTENT FROM SIMPLE_BOARD", new RowMapper<Board>() {
            @Override
            public Board mapRow(ResultSet resultSet, int i) throws SQLException {
                long id = resultSet.getLong("ID");
                String title = resultSet.getString("TITLE");
                String content = resultSet.getString("CONTENT");
                return new Board(id, title, content);
            }
        });
    }
}
