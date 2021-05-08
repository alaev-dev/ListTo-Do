package dev.alaev.spring.todo.controller;

import dev.alaev.spring.todo.dao.DocketDAO;
import dev.alaev.spring.todo.entity.Docket;
import dev.alaev.spring.todo.formater.ShortDateTimeDocket;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class MyController {

    private final DocketDAO docketDAO;

    public MyController(DocketDAO docketDAO) {this.docketDAO = docketDAO;}

    @RequestMapping("/")
    @Transactional
    public String showAllDocket(Model model) {

        List<Docket> allDockets = docketDAO.getAllDockets();

        allDockets = allDockets.stream().map(ShortDateTimeDocket::new).collect(Collectors.toList());

        model.addAttribute("allDocket", allDockets);

        return "all-docket";
    }
}
