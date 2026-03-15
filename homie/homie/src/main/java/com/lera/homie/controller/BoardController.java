package com.lera.homie.controller;

import com.lera.homie.model.Board;
import com.lera.homie.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.lera.homie.repository.TaskRepository;
import com.lera.homie.model.Task;
import java.util.List;
import org.springframework.ui.Model;

@Controller
public class BoardController {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private BoardRepository boardRepository;

    @PostMapping("/board/create/{circleId}")
    public String createBoard(
            @PathVariable Long circleId,
            @RequestParam String name
    ) {

        Board board = new Board();
        board.setName(name);
        board.setCircleId(circleId);

        boardRepository.save(board);

        return "redirect:/circle/" + circleId;
    }

    @GetMapping("/board/{id}")
    public String boardPage(@PathVariable Long id, Model model) {

        List<Task> tasks = taskRepository.findByBoardId(id);

        model.addAttribute("tasks", tasks);
        model.addAttribute("boardId", id);

        return "board";
    }

}
