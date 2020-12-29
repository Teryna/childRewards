package com.example.rewards;

import com.example.rewards.data.RewardsRepository;
import com.example.rewards.data.Task;
import com.example.rewards.dto.TaskUpdateDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TaskController {
    @GetMapping("/tasks/{id}")
    public String task(@PathVariable int id,Model model) {

        var repo = new RewardsRepository();
        var items = repo.getChildTasks(id);

        model.addAttribute("title", "Tasks");
        model.addAttribute("tasks", items);
        return "tasks";
    }


    @GetMapping("/task/{id}")
    public String editTask(@PathVariable int id, Model model) {
        var repo = new RewardsRepository();
        var task = repo.getTask(id);

        if(task == null) {
            task = new Task();
        }

        model.addAttribute("title", task != null ? task.getTitle() : "");
        model.addAttribute("task", task);
        model.addAttribute("id", id);

        return "task_edit";
    }

    @PostMapping("/task/{id}")
    public ModelAndView saveTask(@PathVariable int id, @ModelAttribute("updateDto") TaskUpdateDto dto,
                                 Model model) {
        var repo = new RewardsRepository();
        var task = repo.getTask(id);

        if(task == null && id != 0) {
            throw new IllegalArgumentException("Item with such id not found");
        }

        if(id == 0) {
            task = new Task();
            task.setId(0);
        }

        task.setTitle(dto.getTitle());
        task.setPoints(dto.getPoints());
        task.setItDone(dto.isItDone());

        if(id != 0) {
            repo.save(task);
        } else {
            repo.addTask(task);
        }

        return new ModelAndView("redirect:/tasks/{id}");
    }

    @GetMapping("/task/delete/{id}")
    public ModelAndView deleteTask(@PathVariable int id) {
        var repo = new RewardsRepository();
        repo.deleteTask(id);
        return new ModelAndView("redirect:/tasks");
    }

    @GetMapping("/task/confirm/{id}")
    public String confirmTaskDelete(@PathVariable int id, Model model) {
        var repo = new RewardsRepository();
        var items = repo.getTasks();

        var task = repo.getTask(id);

        model.addAttribute("title", "Tasks");
        model.addAttribute("tasks", items);
        model.addAttribute("confirmDelete", task);

        return "tasks";
    }
}