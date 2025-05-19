package com.zakaria.exam.dtos;

import com.zakaria.exam.enums.StatutCredit;

import java.util.Date;

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
