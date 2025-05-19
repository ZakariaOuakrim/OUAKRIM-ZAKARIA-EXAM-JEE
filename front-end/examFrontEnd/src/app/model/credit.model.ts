export interface Credit {
    id: number;
    dateDemande: Date;
    statut: 'EN_ATTENTE' | 'ACCEPTE' | 'REFUSE'; 
    dateAcception: Date;
    montant: number;
    dureeRemboursement: number;
    tauxInteret: number;
    clientId: number;
  }
  