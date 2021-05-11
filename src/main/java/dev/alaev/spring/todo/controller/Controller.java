package dev.alaev.spring.todo.controller;

import dev.alaev.spring.todo.entity.Docket;
import dev.alaev.spring.todo.entity.DocketInput;
import dev.alaev.spring.todo.entity.Tag;
import dev.alaev.spring.todo.formater.DateTimeDocketFormatter;
import dev.alaev.spring.todo.service.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;


@org.springframework.stereotype.Controller
public class Controller {
    public static final  Locale            LOCALE    = Locale.ENGLISH;
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm",
                                                                                   LOCALE);
    private final        Service           service;

    public Controller(Service service) {this.service = service;}

    @RequestMapping("/")
    public String showAllDocket(Model model) {

        List<Docket> allDockets = service.getAllDockets();

        allDockets = allDockets.stream().map(DateTimeDocketFormatter::new).collect(Collectors.toList());

        model.addAttribute("allDocket", allDockets);

        return "all-docket";
    }

    @RequestMapping("/addNewDocket")
    public String addNewDocket(Model model) {

        model.addAttribute("docketInput", new DocketInput());
        model.addAttribute("listOfTag", getListOfTag());

        return "docket-info";
    }

    private Map<String, String> getListOfTag() {
        List<Tag> allTag = service.getAllTags();

        Map<String, String> listOfTag = new HashMap<>();

        for (Tag tag : allTag) {
            listOfTag.put(tag.getId().toString(), tag.getName());
        }
        return listOfTag;
    }

    @RequestMapping("/saveDocket")
    public String saveDocket(@Valid @ModelAttribute("docketInput") DocketInput docketInput,
                             BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("listOfTag", getListOfTag());
            return "docket-info";
        }

        Set<Tag>  pickedTag = new HashSet<>();
        List<Tag> allTag    = service.getAllTags();

        for (String pickedTagID : docketInput.getPickedTags()) {
            for (Tag tag : allTag) {
                if (tag.getId().toString().equals(pickedTagID)) {
                    pickedTag.add(tag);
                }
            }
        }

        service.saveDocket(new Docket(docketInput.getId(),
                                      docketInput.getDescribeCase(),
                                      LocalDateTime.now(),
                                      docketInput.getDeadline().length() > 0
                                      ? LocalDateTime.parse(docketInput.getDeadline(), FORMATTER) : null,
                                      null,
                                      null, pickedTag));

        return "redirect:/";
    }

    @RequestMapping("/updateInfo")
    public String updateDocket(@RequestParam("docketId") long id, Model model) {

        Docket docket = service.getDocket(id);

        List<String> pickedTags = new ArrayList<>();

        for (Tag tag : docket.getTags()) {
            pickedTags.add(tag.getId().toString());
        }


        model.addAttribute("docketInput",
                           new DocketInput(id,
                                           docket.getDescribeCase(),
                                           docket.getDeadlineLDT() == null
                                           ? ""
                                           : docket.getDeadlineLDT().format(FORMATTER),
                                           "",
                                           pickedTags));
        model.addAttribute("listOfTag", getListOfTag());

        return "docket-info";
    }

    @RequestMapping("/deleteInfo")
    public String deleteDocket(@RequestParam("docketId") long id) {

        service.deleteDocket(id);

        return "redirect:/";
    }
}
