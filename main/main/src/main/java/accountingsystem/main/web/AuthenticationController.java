package accountingsystem.main.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ResolvableType;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/auth")
public class AuthenticationController {
    @GetMapping(value = "/login")
    public String getLoginPage(){
        return "login";
    }
    @GetMapping(value = "/logout")
    public String getLogout(HttpServletRequest request){
        request.getSession().invalidate();
        return "redirect:/auth/login";
    }


}
