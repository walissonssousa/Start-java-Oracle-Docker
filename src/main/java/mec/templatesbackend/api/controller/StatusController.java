package mec.templatesbackend.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatusController {
    @GetMapping(path = "/api/status")
    public String check(){
        return "conectou no banco com sucesso!";
    }
}
