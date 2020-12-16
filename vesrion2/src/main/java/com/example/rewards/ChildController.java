package com.example.rewards;

import com.example.rewards.data.RewardsRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChildController {
    @GetMapping("/childs")
    public String user(Model model) {

        var repo = new RewardsRepository();
        var items = repo.getChilds();

        model.addAttribute("title", "Children");
        model.addAttribute("childs", items);
        return "childs";
    }


}
