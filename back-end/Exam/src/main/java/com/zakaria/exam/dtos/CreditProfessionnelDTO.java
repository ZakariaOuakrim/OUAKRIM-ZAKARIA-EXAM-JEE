package com.zakaria.exam.dtos;

import lombok.Data;

@Data
public class CreditProfessionnelDTO extends CreditDTO{
    private String motif;
    private String raisonSociale;
}
