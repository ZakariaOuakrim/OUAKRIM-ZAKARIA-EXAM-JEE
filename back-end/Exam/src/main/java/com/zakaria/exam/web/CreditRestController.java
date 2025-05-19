package com.zakaria.exam.web;

import com.zakaria.exam.dtos.CreditDTO;
import com.zakaria.exam.services.CreditService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@AllArgsConstructor
public class CreditRestController {
    private CreditService creditService;

    @GetMapping("/credits/{creditId}")
    public CreditDTO getCredit(@PathVariable Long creditId)  {
        return creditService.getCredit(creditId);
    }

    @GetMapping("/credits")
    public List<CreditDTO> listCredits() {
        return creditService.listAllCredits();
    }
}
