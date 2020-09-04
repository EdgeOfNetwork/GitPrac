package monthlyslide.simpleboard.controller;

import monthlyslide.simpleboard.domain.Board;
import monthlyslide.simpleboard.dto.BoardDto;
import monthlyslide.simpleboard.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {
    @Autowired
    BoardService boardService;

    @GetMapping({"", "/list"})
        public ModelAndView list() {
        List<Board> list = boardService.list();
        ModelAndView mv = new ModelAndView("board/list");
        mv.addObject("list", list);
        return mv;
    }

    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable("id") long id) {
        ModelAndView mv = new ModelAndView("board/detail");
        Board board = boardService.detail(id);
        mv.addObject("board", board);
        return mv;
    }

    @GetMapping("/create")
    public String createForm() {
        return "/board/create";
    }

    @PostMapping("/create")
    public View create(BoardDto boardDto) {
        Board board = boardDto.getBoard();
        boardService.create(board);
        return new RedirectView("/board/list");
    }

    @GetMapping("/remove/{id}")
    public View remove(@PathVariable("id") long id) {
        boardService.remove(id);
        return new RedirectView("/board/list");
    }
}