package com.zakaria.exam;

import com.zakaria.exam.dtos.ClientDTO;
import com.zakaria.exam.dtos.CreditImmobilierDTO;
import com.zakaria.exam.dtos.CreditPersonnelDTO;
import com.zakaria.exam.entities.*;
import com.zakaria.exam.enums.StatutCredit;
import com.zakaria.exam.enums.TypeBien;
import com.zakaria.exam.enums.TypeRemboursement;
import com.zakaria.exam.repositories.ClientRepository;
import com.zakaria.exam.repositories.CreditRepository;
import com.zakaria.exam.repositories.RemboursementRepository;
import com.zakaria.exam.services.CreditService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

@SpringBootApplication
public class ExamApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExamApplication.class, args);
    }


    @Bean
    CommandLineRunner commandLineRunner(CreditService creditService) {
        return args -> {
            // Step 1: Add dummy Clients
            Stream.of("Zakaria", "Imane", "Mohamed").forEach(name -> {
                ClientDTO clientDTO = new ClientDTO();
                clientDTO.setNom(name);
                clientDTO.setEmail(name + "@gmail.com");
                creditService.saveClient(clientDTO);
            });

            // Step 2: List of created clients
            List<ClientDTO> clients = creditService.listClients();

            // Step 3: Create dummy Credit for each client
            clients.forEach(client -> {
                // Create CreditPersonnel
                CreditPersonnelDTO creditPersonnelDTO = new CreditPersonnelDTO();
                creditPersonnelDTO.setMontant(Math.random() * 100000);
                creditPersonnelDTO.setDureeRemboursement(12); // 12 months or years
                creditPersonnelDTO.setTauxInteret(5.5);
                creditPersonnelDTO.setClientId(client.getId());
                creditPersonnelDTO.setMotif("Personal Loan");

                // Save CreditPersonnel
                creditService.saveCreditPersonnel(creditPersonnelDTO);

                // Create CreditImmobilier
                CreditImmobilierDTO creditImmobilierDTO = new CreditImmobilierDTO();
                creditImmobilierDTO.setMontant(Math.random() * 200000);
                creditImmobilierDTO.setDureeRemboursement(24);
                creditImmobilierDTO.setTauxInteret(3.2);
                creditImmobilierDTO.setClientId(client.getId());
                creditImmobilierDTO.setTypeBien(TypeBien.APPARTEMENT);

                // Save CreditImmobilier
                creditService.saveCreditImmobilier(creditImmobilierDTO);
            });
        };
    }

    //@Bean
    CommandLineRunner start(ClientRepository clientRepository,
                            CreditRepository creditRepository,
                            RemboursementRepository remboursementRepository) {
        return args -> {
            // Creating clients
            List<Client> clients = List.of(
                    new Client(null, "Zakaria", "zakaria@gmail.com", null),
                    new Client(null, "Fatima", "fatima@gmail.com", null),
                    new Client(null, "Omar", "omar@gmail.com", null)
            );
            clientRepository.saveAll(clients);

            // Creating credits
            for (Client client : clientRepository.findAll()) {
                CreditPersonnel creditPersonnel = new CreditPersonnel();
                creditPersonnel.setClient(client);
                creditPersonnel.setDateDemande(new Date());
                creditPersonnel.setStatut(StatutCredit.EN_COURS);
                creditPersonnel.setMontant(50000);
                creditPersonnel.setDureeRemboursement(24);
                creditPersonnel.setTauxInteret(4.5);
                creditPersonnel.setMotif("Achat de voiture");
                creditRepository.save(creditPersonnel);

                CreditImmobilier creditImmobilier = new CreditImmobilier();
                creditImmobilier.setClient(client);
                creditImmobilier.setDateDemande(new Date());
                creditImmobilier.setStatut(StatutCredit.ACCEPTE);
                creditImmobilier.setDateAcception(new Date());
                creditImmobilier.setMontant(200000);
                creditImmobilier.setDureeRemboursement(120);
                creditImmobilier.setTauxInteret(3.2);
                creditImmobilier.setTypeBien(TypeBien.MAISON);
                creditRepository.save(creditImmobilier);

                CreditProfessionnel creditProfessionnel = new CreditProfessionnel();
                creditProfessionnel.setClient(client);
                creditProfessionnel.setDateDemande(new Date());
                creditProfessionnel.setStatut(StatutCredit.REJETE);
                creditProfessionnel.setMontant(150000);
                creditProfessionnel.setDureeRemboursement(36);
                creditProfessionnel.setTauxInteret(5.0);
                creditProfessionnel.setMotif("Achat matériel");
                creditProfessionnel.setRaisonSociale("Tech Solutions SARL");
                creditRepository.save(creditProfessionnel);
            }

            // Creating remboursements
            for (Credit credit : creditRepository.findAll()) {
                for (int i = 0; i < 3; i++) {
                    Remboursement r = new Remboursement();
                    r.setCredit(credit);
                    r.setDate(new Date());
                    r.setMontant(credit.getMontant() / credit.getDureeRemboursement());
                    r.setType(i == 2 ? TypeRemboursement.REMBOURSEMENT_ANTICIPE : TypeRemboursement.MENSUALITE);
                    remboursementRepository.save(r);
                }
            }
        };
    }
}
