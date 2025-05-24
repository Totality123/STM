package proyecto_lenguajes.stm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import jakarta.annotation.security.PermitAll;

@PermitAll
@Controller
@RequestMapping("/")
public class ControllerNavigator {

    @GetMapping
    public String redireccion1() {
        return "home";
    }

    @GetMapping("/board")
    public String redireccion2() {
        return "board";
    }
    
    @GetMapping("/comment")
    public String redireccion3() {
        return "comment";
    }

    @GetMapping("/modal")
    public String redireccion4() {
        return "modal";
    }

     @GetMapping("/login")
    public String redireccion5() {
        return "login";
    }

}
