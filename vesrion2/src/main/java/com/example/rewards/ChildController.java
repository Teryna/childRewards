package com.example.rewards;

import com.example.rewards.data.Child;
import com.example.rewards.data.RewardsRepository;
import com.example.rewards.dto.ChildUpdateDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ChildController {
    @GetMapping("/childs")
    public String child(Model model) {

        var repo = new RewardsRepository();
        var items = repo.getChilds();

        model.addAttribute("title", "Children");
        model.addAttribute("childs", items);
        return "childs";
    }

    @GetMapping("/childs/{id}")
    public String editChild(@PathVariable int id, Model model) {
        var repo = new RewardsRepository();
        var child = repo.getChild(id);

        if(child == null) {
            child = new Child();
        }

        model.addAttribute("title", child != null ? child.getName() : "");
        model.addAttribute("child", child);
        model.addAttribute("id", id);

        return "child_edit";
    }


    @PostMapping("/childs/{id}")
    public ModelAndView saveChild(@PathVariable int id, @ModelAttribute("updateDto") ChildUpdateDto dto,
                                  Model model) {
        var repo = new RewardsRepository();
        var child = repo.getChild(id);

        if(child == null && id != 0) {
            throw new IllegalArgumentException("Item with such id not found");
        }

        if(id == 0) {
            child = new Child();
            child.setId(0);
        }

        child.setName(dto.getName());
        child.setAge(dto.getAge());

        if(id != 0) {
            repo.save(child);
        } else {
            repo.addChild(child);
        }

        return new ModelAndView("redirect:/childs");
    }

    @GetMapping("/childs/delete/{id}")
    public ModelAndView deleteChild(@PathVariable int id) {
        var repo = new RewardsRepository();
        repo.deleteChild(id);
        return new ModelAndView("redirect:/childs");
    }

    @GetMapping("/childs/confirm/{id}")
    public String confirmCarDelete(@PathVariable int id, Model model) {
        var repo = new RewardsRepository();
        var items = repo.getChilds();

        var child = repo.getChild(id);

        model.addAttribute("title", "Children");
        model.addAttribute("childs", items);
        model.addAttribute("confirmDelete", child);

        return "childs";
    }


}
