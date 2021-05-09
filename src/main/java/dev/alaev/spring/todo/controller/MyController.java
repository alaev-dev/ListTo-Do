package dev.alaev.spring.todo.controller;

import dev.alaev.spring.todo.entity.Docket;
import dev.alaev.spring.todo.entity.DocketInput;
import dev.alaev.spring.todo.formater.ShortDateTimeDocket;
import dev.alaev.spring.todo.service.DocketService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class MyController {

    private final DocketService docketService;

    public MyController(DocketService docketService) {this.docketService = docketService;}

    @RequestMapping("/")
    public String showAllDocket(Model model) {

        List<Docket> allDockets = docketService.getAllDockets();

        allDockets = allDockets.stream().map(ShortDateTimeDocket::new).collect(Collectors.toList());

        model.addAttribute("allDocket", allDockets);

        return "all-docket";
    }

    @RequestMapping("/addNewDocket")
    public String addNewDocket(Model model) {

        DocketInput docketInput = new DocketInput();
        model.addAttribute("docketInput", docketInput);

        return "docket-info";
    }

    @RequestMapping("/saveDocket")
    public String saveDocket(@ModelAttribute("docket") Docket docket) {


        docketService.saveDocket(docket);

        return "redirect:/";
    }
}
