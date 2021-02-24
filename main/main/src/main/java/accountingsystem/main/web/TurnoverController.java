package accountingsystem.main.web;

import accountingsystem.main.service.TurnoverService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class TurnoverController {
    private final TurnoverService turnoverService;

    public TurnoverController(TurnoverService turnoverService) {
        this.turnoverService = turnoverService;
    }
    @GetMapping
    public String listAllTurnovers(Model model){
        model.addAttribute("turnovers",turnoverService.findAll());
        return "list-turnovers";
    }



}
