package com.example.rewards;

import com.example.rewards.data.RewardsRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TaskController {
    @GetMapping("/tasks")
    public String task(Model model) {

        var repo = new RewardsRepository();
        var items = repo.getTasks();

        model.addAttribute("title", "Tasks");
        model.addAttribute("tasks", items);
        return "tasks";
    }
}
