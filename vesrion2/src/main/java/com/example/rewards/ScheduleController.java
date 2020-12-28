package com.example.rewards;

import com.example.rewards.data.RewardsRepository;
import com.example.rewards.data.ScheduleManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@Controller
public class ScheduleController {
    @GetMapping("/schedule/{id}")
    public String schedule(@PathVariable int id, Model model) {

        var repo = new RewardsRepository();
        model.addAttribute("child", repo.getChild(id));

        var scheduleManager = new ScheduleManager();

        model.addAttribute("childResults", scheduleManager.getChildResults(id));

        return "schedule";
    }
}
