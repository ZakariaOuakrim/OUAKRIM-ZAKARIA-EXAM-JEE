package com.zakaria.exam.entities;

import com.zakaria.exam.enums.StatutCredit;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Credit {
    @Id
    @GeneratedValue
    private Long id;

    private Date dateDemande;

    @Enumerated(EnumType.STRING)
    private StatutCredit statut;

    private Date dateAcception;
    private double montant;
    private int dureeRemboursement; // in months or years
    private double tauxInteret;

    @ManyToOne
    private Client client;

    @OneToMany(mappedBy = "credit")
    private List<Remboursement> remboursements;
}
