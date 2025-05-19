package com.zakaria.exam.mappers;

import com.zakaria.exam.dtos.*;
import com.zakaria.exam.entities.*;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class CreditMapperImpl {
    public ClientDTO fromClient(Client client) {
        ClientDTO dto = new ClientDTO();
        BeanUtils.copyProperties(client, dto);
        return dto;
    }

    public Client fromClientDTO(ClientDTO dto) {
        Client client = new Client();
        BeanUtils.copyProperties(dto, client);
        return client;
    }

    public CreditDTO fromCredit(Credit credit) {
        if (credit instanceof CreditPersonnel) {
            return fromCreditPersonnel((CreditPersonnel) credit);
        } else if (credit instanceof CreditImmobilier) {
            return fromCreditImmobilier((CreditImmobilier) credit);
        } else if (credit instanceof CreditProfessionnel) {
            return fromCreditProfessionnel((CreditProfessionnel) credit);
        } else {
            CreditDTO dto = new CreditDTO();
            BeanUtils.copyProperties(credit, dto);
            if (credit.getClient() != null)
                dto.setClientId(credit.getClient().getId());
            return dto;
        }
    }

    public Credit fromCreditDTO(CreditDTO dto) {
        // Not recommended to use this unless you know the exact subtype
        Credit credit = new Credit();
        BeanUtils.copyProperties(dto, credit);
        return credit;
    }

    public CreditPersonnelDTO fromCreditPersonnel(CreditPersonnel credit) {
        CreditPersonnelDTO dto = new CreditPersonnelDTO();
        BeanUtils.copyProperties(credit, dto);
        if (credit.getClient() != null)
            dto.setClientId(credit.getClient().getId());
        return dto;
    }

    public CreditPersonnel fromCreditPersonnelDTO(CreditPersonnelDTO dto) {
        CreditPersonnel credit = new CreditPersonnel();
        BeanUtils.copyProperties(dto, credit);
        return credit;
    }

    public CreditImmobilierDTO fromCreditImmobilier(CreditImmobilier credit) {
        CreditImmobilierDTO dto = new CreditImmobilierDTO();
        BeanUtils.copyProperties(credit, dto);
        if (credit.getClient() != null)
            dto.setClientId(credit.getClient().getId());
        return dto;
    }

    public CreditImmobilier fromCreditImmobilierDTO(CreditImmobilierDTO dto) {
        CreditImmobilier credit = new CreditImmobilier();
        BeanUtils.copyProperties(dto, credit);
        return credit;
    }

    public CreditProfessionnelDTO fromCreditProfessionnel(CreditProfessionnel credit) {
        CreditProfessionnelDTO dto = new CreditProfessionnelDTO();
        BeanUtils.copyProperties(credit, dto);
        if (credit.getClient() != null)
            dto.setClientId(credit.getClient().getId());
        return dto;
    }

    public CreditProfessionnel fromCreditProfessionnelDTO(CreditProfessionnelDTO dto) {
        CreditProfessionnel credit = new CreditProfessionnel();
        BeanUtils.copyProperties(dto, credit);
        return credit;
    }

    public RemboursementDTO fromRemboursement(Remboursement remboursement) {
        RemboursementDTO dto = new RemboursementDTO();
        BeanUtils.copyProperties(remboursement, dto);
        if (remboursement.getCredit() != null)
            dto.setCreditId(remboursement.getCredit().getId());
        return dto;
    }

    public Remboursement fromRemboursementDTO(RemboursementDTO dto) {
        Remboursement remboursement = new Remboursement();
        BeanUtils.copyProperties(dto, remboursement);
        return remboursement;
    }
}
