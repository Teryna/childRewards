package com.example.rewards;

import com.example.rewards.data.RewardsRepository;
import com.example.rewards.data.ScheduleManager;
import com.example.rewards.dto.ChildUpdateDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

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

    @PostMapping("/schedule/{id}")
    public ModelAndView savePosition(@PathVariable int id, @ModelAttribute("testResult") ChildUpdateDto updateDto) {

        return new ModelAndView("redirect:/schedule/"+id);
    }
}
