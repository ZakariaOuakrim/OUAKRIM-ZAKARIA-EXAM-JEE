package com.zakaria.exam.dtos;

import com.zakaria.exam.enums.StatutCredit;
import lombok.Data;

import java.util.Date;
@Data
public class CreditDTO {
    private Long id;
    private Date dateDemande;
    private StatutCredit statut;
    private Date dateAcception;
    private double montant;
    private int dureeRemboursement;
    private double tauxInteret;
    private Long clientId;
}
