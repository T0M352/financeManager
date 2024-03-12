package tomaszmorgas.financemanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping("showLoginPage")
    public String showLoginPage(){
        return "plain-login";
    }

    @GetMapping("/access-denied")
        public String showAccesDenied(){
            return "access-denied";
        }


}
