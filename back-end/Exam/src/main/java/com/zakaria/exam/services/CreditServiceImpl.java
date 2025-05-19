package com.zakaria.exam.services;

import com.zakaria.exam.dtos.*;
import com.zakaria.exam.entities.*;
import com.zakaria.exam.enums.StatutCredit;
import com.zakaria.exam.mappers.CreditMapperImpl;
import com.zakaria.exam.repositories.ClientRepository;
import com.zakaria.exam.repositories.CreditRepository;
import com.zakaria.exam.repositories.RemboursementRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class CreditServiceImpl implements CreditService{
    private final ClientRepository clientRepository;
    private final CreditRepository creditRepository;
    private final RemboursementRepository remboursementRepository;
    private CreditMapperImpl dtoMapper;


    @Override
    public ClientDTO saveClient(ClientDTO clientDTO) {
        log.info("Saving new Client");
        Client client = dtoMapper.fromClientDTO(clientDTO);
        Client savedClient = clientRepository.save(client);
        return dtoMapper.fromClient(savedClient);
    }

    @Override
    public ClientDTO getClient(Long clientId) {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Client not found"));
        return dtoMapper.fromClient(client);
    }

    @Override
    public ClientDTO updateClient(ClientDTO clientDTO) {
        Client client = dtoMapper.fromClientDTO(clientDTO);
        Client savedClient = clientRepository.save(client);
        return dtoMapper.fromClient(savedClient);
    }

    @Override
    public void deleteClient(Long clientId) {
        clientRepository.deleteById(clientId);
    }

    @Override
    public List<ClientDTO> listClients() {
        List<Client> clients = clientRepository.findAll();
        List<ClientDTO> clientDTOS = clients.stream()
                .map(dtoMapper::fromClient)
                .collect(Collectors.toList());
        return clientDTOS;
    }

    @Override
    public List<ClientDTO> searchClients(String keyword) {
        return List.of();
    }

    @Override
    public CreditPersonnelDTO saveCreditPersonnel(CreditPersonnelDTO creditPersonnelDTO) {
        Client client = clientRepository.findById(creditPersonnelDTO.getClientId()).orElse(null);

        CreditPersonnel creditPersonnel = new CreditPersonnel();
        creditPersonnel.setDateDemande(new Date());
        creditPersonnel.setStatut(creditPersonnel.getStatut());
        creditPersonnel.setMontant(creditPersonnelDTO.getMontant());
        creditPersonnel.setDureeRemboursement(creditPersonnelDTO.getDureeRemboursement());
        creditPersonnel.setTauxInteret(creditPersonnelDTO.getTauxInteret());
        creditPersonnel.setMotif(creditPersonnelDTO.getMotif());
        creditPersonnel.setClient(client);

        CreditPersonnel savedCreditPersonnel = creditRepository.save(creditPersonnel);
        return dtoMapper.fromCreditPersonnel(savedCreditPersonnel);
    }

    @Override
    public CreditImmobilierDTO saveCreditImmobilier(CreditImmobilierDTO creditImmobilierDTO) {
        Client client = clientRepository.findById(creditImmobilierDTO.getClientId()).orElse(null);

        CreditImmobilier creditImmobilier = new CreditImmobilier();
        creditImmobilier.setDateDemande(new Date());
        creditImmobilier.setStatut(creditImmobilierDTO.getStatut());
        creditImmobilier.setMontant(creditImmobilierDTO.getMontant());
        creditImmobilier.setDureeRemboursement(creditImmobilierDTO.getDureeRemboursement());
        creditImmobilier.setTauxInteret(creditImmobilierDTO.getTauxInteret());
        creditImmobilier.setTypeBien(creditImmobilierDTO.getTypeBien());
        creditImmobilier.setClient(client);

        CreditImmobilier savedCreditImmobilier = creditRepository.save(creditImmobilier);
        return dtoMapper.fromCreditImmobilier(savedCreditImmobilier);
    }

    @Override
    public CreditProfessionnelDTO saveCreditProfessionnel(CreditProfessionnelDTO creditProfessionnelDTO) {
        return null;
    }

    @Override
    public CreditDTO getCredit(Long creditId) {
        Credit credit = creditRepository.findById(creditId)
                .orElseThrow(() -> new RuntimeException("Credit not found"));
        if (credit instanceof CreditPersonnel) {
            return dtoMapper.fromCreditPersonnel((CreditPersonnel) credit);
        } else if (credit instanceof CreditImmobilier) {
            return dtoMapper.fromCreditImmobilier((CreditImmobilier) credit);
        } else if (credit instanceof CreditProfessionnel) {
            return dtoMapper.fromCreditProfessionnel((CreditProfessionnel) credit);
        } else {
            return dtoMapper.fromCredit(credit);
        }
    }

    @Override
    public List<CreditDTO> listCreditsByClient(Long clientId) {
        return List.of();
    }

    @Override
    public List<CreditDTO> listAllCredits() {
        List<Credit> credits = creditRepository.findAll();
        List<CreditDTO> creditDTOS = credits.stream().map(credit -> {
            if (credit instanceof CreditPersonnel) {
                CreditPersonnel creditPersonnel = (CreditPersonnel) credit;
                return dtoMapper.fromCreditPersonnel(creditPersonnel);
            } else if (credit instanceof CreditImmobilier) {
                CreditImmobilier creditImmobilier = (CreditImmobilier) credit;
                return dtoMapper.fromCreditImmobilier(creditImmobilier);
            } else {
                CreditProfessionnel creditProfessionnel = (CreditProfessionnel) credit;
                return dtoMapper.fromCreditProfessionnel(creditProfessionnel);
            }
        }).collect(Collectors.toList());
        return creditDTOS;
    }

    @Override
    public RemboursementDTO saveRemboursement(RemboursementDTO remboursementDTO) {
        return null;
    }

    @Override
    public List<RemboursementDTO> listRemboursementsByCredit(Long creditId) {
        return List.of();
    }

    @Override
    public List<RemboursementDTO> listAllRemboursements() {
        return List.of();
    }
}
