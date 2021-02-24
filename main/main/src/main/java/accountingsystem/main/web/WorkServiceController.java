package accountingsystem.main.web;

import accountingsystem.main.service.WorkServicesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/workservice")
public class WorkServiceController {
private final WorkServicesService workServicesService;

    public WorkServiceController(WorkServicesService workServicesService) {
        this.workServicesService = workServicesService;
    }

    @GetMapping
    public String listAllServices(Model model)
    {
        model.addAttribute("services",workServicesService.findAll());
        return "list-services";
    }


}
