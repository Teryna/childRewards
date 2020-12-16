package com.example.rewards;

import com.example.rewards.data.RewardsRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MenuController {
    @GetMapping("/menu")
    public String user(Model model) {

        var repo = new RewardsRepository();
        var items = repo.getChilds();

        model.addAttribute("title", "Main menu");
        model.addAttribute("users", items);
        return "menu";
    }

}
