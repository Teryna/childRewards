package com.example.rewards;

import com.example.rewards.data.RewardsRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProfileController {
    @GetMapping("/profile")
    public String profile(Model model) {

        var repo = new RewardsRepository();
        var items = repo.getProfileTasks();

        model.addAttribute("title", "Profile");
        model.addAttribute("profile", items);
        return "profile";
    }
}
