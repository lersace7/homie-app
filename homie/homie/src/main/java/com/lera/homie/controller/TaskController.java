package com.lera.homie.controller;

import com.lera.homie.model.Task;
import com.lera.homie.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @PostMapping("/task/create/{boardId}")
    public String createTask(
            @PathVariable Long boardId,
            @RequestParam String title
    ) {

        Task task = new Task();
        task.setTitle(title);
        task.setBoardId(boardId);

        taskRepository.save(task);

        return "redirect:/board/" + boardId;
    }

}