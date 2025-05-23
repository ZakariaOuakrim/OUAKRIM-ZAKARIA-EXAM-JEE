package com.zakaria.exam.entities;

import com.zakaria.exam.enums.TypeRemboursement;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Remboursement {
    @Id
    @GeneratedValue
    private Long id;
    private Date date;
    private double montant;

    @Enumerated(EnumType.STRING)
    private TypeRemboursement type;

    @ManyToOne
    private Credit credit;
}
