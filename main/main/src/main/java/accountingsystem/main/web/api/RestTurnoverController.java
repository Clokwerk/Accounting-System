package accountingsystem.main.web.api;

import accountingsystem.main.factory.CompanyFactory;
import accountingsystem.main.model.Company;
import accountingsystem.main.resource.CompanyTotalTurnover;
import accountingsystem.main.service.CompanyService;
import accountingsystem.main.service.TurnoverService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/turnover")
public class RestTurnoverController {
    private final TurnoverService turnoverService;
    private final CompanyService companyService;

    public RestTurnoverController(TurnoverService turnoverService, CompanyService companyService) {
        this.turnoverService = turnoverService;
        this.companyService = companyService;
    }

    @GetMapping("/{companyId}")
    public ResponseEntity<CompanyTotalTurnover> getTotalTurnover(@PathVariable Long companyId){
        Double totalTurnOver = this.turnoverService.getTotalTurnover(companyId);
        Company company = this.companyService.findById(companyId).orElseThrow(RuntimeException::new);
        CompanyTotalTurnover companyTotalTurnover = CompanyFactory.createCompanyTotalTurnover(
                companyId,
                company.getName(),
                totalTurnOver);
        return ResponseEntity.ok(companyTotalTurnover);

    }



}
