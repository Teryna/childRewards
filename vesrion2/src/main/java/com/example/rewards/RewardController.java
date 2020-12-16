package com.example.rewards;

import com.example.rewards.data.RewardsRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RewardController {
    @GetMapping("/rewards")
    public String task(Model model) {

        var repo = new RewardsRepository();
        var items = repo.getRewards();

        model.addAttribute("title", "Rewards");
        model.addAttribute("rewards", items);
        return "rewards";
    }
}
