package monthlyslide.simpleboard.service;

import monthlyslide.simpleboard.domain.Board;
import monthlyslide.simpleboard.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {
    @Autowired
    BoardRepository repository;

    @Override
    public void create(Board board) {
        repository.save(board);
    }

    @Override
    public List<Board> list() {
        return repository.findAll();
    }

    @Override
    public Board detail(Long id) {
        return repository.findById(id);
    }

    @Override
    public void remove(Long id) {
        repository.delete(id);
    }
}
