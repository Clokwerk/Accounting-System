package accountingsystem.main.web.api;

import accountingsystem.main.model.Turnover;
import accountingsystem.main.model.User;
import accountingsystem.main.service.TurnoverService;
import accountingsystem.main.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/api/turnover")
public class TurnoverRESTController {
    private final TurnoverService turnoverService;
    private final UserService userService;
    public TurnoverRESTController(TurnoverService turnoverService, UserService userService){
        this.turnoverService=turnoverService;
        this.userService=userService;
    }
    @GetMapping("/getByDate")

    public List<Turnover> getTurnoverByDate(@RequestParam String date,@RequestParam Long userID){
        DateTimeFormatter formatDate= DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate newDate=LocalDate.parse(date,formatDate);
        User user=this.userService.findAll().stream().filter(x->x.getId()==userID).findFirst().get();
        if(user == null){
return null;
        }
        List<Turnover> turnovers=this.turnoverService.findByDateAndUser(newDate,user);
        return turnovers;
    }
}
