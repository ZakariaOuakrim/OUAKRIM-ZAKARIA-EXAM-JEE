package com.zakaria.exam.web;

import com.zakaria.exam.dtos.ClientDTO;
import com.zakaria.exam.services.CreditService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class ClientRestController {
    private CreditService creditService;

    @GetMapping("/clients")
    public List<ClientDTO> getClients() {
        return creditService.listClients();
    }
    
}
