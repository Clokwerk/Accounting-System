package accountingsystem.main.web.api;

import accountingsystem.main.factory.CompanyFactory;
import accountingsystem.main.model.Company;
import accountingsystem.main.model.Product;
import accountingsystem.main.model.Turnover;
import accountingsystem.main.model.WorkService;
import accountingsystem.main.resource.response.CompanyTotalTurnover;
import accountingsystem.main.service.CompanyService;
import accountingsystem.main.service.ProductService;
import accountingsystem.main.service.TurnoverService;
import accountingsystem.main.service.WorkServicesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/turnover")
public class RestTurnoverController {
    private final TurnoverService turnoverService;
    private final CompanyService companyService;
    private final WorkServicesService workServicesService;
    private final ProductService productService;
    public RestTurnoverController(TurnoverService turnoverService, CompanyService companyService, WorkServicesService workServicesService,ProductService productService) {
        this.turnoverService = turnoverService;
        this.companyService = companyService;
        this.workServicesService=workServicesService;
        this.productService=productService;
    }

    @GetMapping("/getTotalTurnover/{companyId}")
    public ResponseEntity<CompanyTotalTurnover> getTotalTurnover(@PathVariable Long companyId){
        Double totalTurnOver = this.turnoverService.getTotalTurnover(companyId);
        Company company = this.companyService.findById(companyId).orElseThrow(RuntimeException::new);
        CompanyTotalTurnover companyTotalTurnover = CompanyFactory.createCompanyTotalTurnover(
                companyId,
                company.getName(),
                totalTurnOver);
        return ResponseEntity.ok(companyTotalTurnover);
    }
    @PostMapping("/addTurnover")
    public ResponseEntity addTurnover( @RequestParam String date,
                                       @RequestParam Long price,
                                       @RequestParam Integer numberProducts,
                                       @RequestParam Long sumProfit,
                                       @RequestParam List<Long> workServiceIds,
                                       @RequestParam List<Long> productsIds,
                                       @RequestParam Long companyId){
        DateTimeFormatter formatter= DateTimeFormatter.ofPattern("yyy-MM-dd HH:mm");
        LocalDateTime newDate=LocalDateTime.parse(date,formatter);
        List<WorkService> workServices= workServiceIds.stream().
                map(x->this.workServicesService.findById(x)).
                collect(Collectors.toList());
        List<Product> products=productsIds.stream().
                map(x->this.productService.findById(x)).
                collect(Collectors.toList());
        Company company=this.companyService.findById(companyId).orElse(null);
        if(company==null){
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
        Turnover newTurnover=this.turnoverService.save(newDate,price,numberProducts,sumProfit,workServices,products,company);
        if(newTurnover == null){
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
            //change return status code if needed
        }
        return new ResponseEntity<>(HttpStatus.OK);


    }
    @DeleteMapping("/deleteTurnover")
    public ResponseEntity<Long> deleteTurnover(@RequestParam Long Id){
        Turnover deletedTurnover=this.turnoverService.deleteById(Id);
        if(deletedTurnover == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(Id, HttpStatus.OK);
    }



}
