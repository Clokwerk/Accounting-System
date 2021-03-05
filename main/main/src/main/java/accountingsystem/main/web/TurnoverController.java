package accountingsystem.main.web;

import accountingsystem.main.service.TestPDFExporter;
import accountingsystem.main.service.TurnoverService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
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

    @GetMapping("/turnover/export/pdf")
    public void exportToPDF(HttpServletResponse response) throws IOException {
        response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=turnover_" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);

        TestPDFExporter exporter = new TestPDFExporter();
        exporter.export(response);
    }



}
