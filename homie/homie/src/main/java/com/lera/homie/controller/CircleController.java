package com.lera.homie.controller;

import com.lera.homie.model.Circle;
import com.lera.homie.repository.CircleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import java.util.List;
import com.lera.homie.repository.BoardRepository;
import com.lera.homie.model.Board;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class CircleController {

    @Autowired
    private BoardRepository boardRepository;
    @Autowired
    private CircleRepository circleRepository;

    @PostMapping("/circle/create")
    public String createCircle(@RequestParam String name) {

        Circle circle = new Circle();
        circle.setName(name);

        circleRepository.save(circle);

        System.out.println("CIRCLE CREATED: " + name);

        return "redirect:/dashboard";
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {

        List<Circle> circles = circleRepository.findAll();

        model.addAttribute("circles", circles);

        return "dashboard";
    }

    @GetMapping("/circle/{id}")
    public String circlePage(@PathVariable Long id, Model model) {

        List<Board> boards = boardRepository.findByCircleId(id);

        model.addAttribute("boards", boards);
        model.addAttribute("circleId", id);

        return "circle";
    }

}
