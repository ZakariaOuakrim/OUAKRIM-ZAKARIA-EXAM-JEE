package com.zakaria.exam.services;

import com.zakaria.exam.dtos.*;
import com.zakaria.exam.entities.Client;
import com.zakaria.exam.entities.CreditImmobilier;
import com.zakaria.exam.entities.CreditPersonnel;
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
        return null;
    }

    @Override
    public ClientDTO updateClient(ClientDTO clientDTO) {
        return null;
    }

    @Override
    public void deleteClient(Long clientId) {

    }

    @Override
    public List<ClientDTO> listClients() {
        return List.of();
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
        return null;
    }

    @Override
    public List<CreditDTO> listCreditsByClient(Long clientId) {
        return List.of();
    }

    @Override
    public List<CreditDTO> listAllCredits() {
        return List.of();
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
