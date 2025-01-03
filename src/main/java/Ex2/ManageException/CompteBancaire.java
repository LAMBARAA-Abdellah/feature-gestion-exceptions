package Ex2.ManageException;

public class CompteBancaire {
    private String numeroCompte;
    private double solde;
    private String nomTitulaire;

    public CompteBancaire(String numeroCompte, String nomTitulaire, double soldeInitial) {
        this.numeroCompte = numeroCompte;
        this.nomTitulaire = nomTitulaire;
        this.solde = soldeInitial;
    }

    public String getNumeroCompte() {
        return numeroCompte;
    }

    public double getSolde() {
        return solde;
    }

    public String getNomTitulaire() {
        return nomTitulaire;
    }

    public void deposer(double montant) {
        if (montant > 0) {
            solde += montant;
        }
    }

    public void retirer(double montant) throws FondsInsuffisantsException {
        if (montant > solde) {
            throw new FondsInsuffisantsException("Fonds insuffisants pour le retrait.");
        }
        solde -= montant;
    }

    public void transfererVers(CompteBancaire autreCompte, double montant) throws FondsInsuffisantsException, CompteInexistantException {
        if (autreCompte == null) {
            throw new CompteInexistantException("Compte destinataire inexistant.");
        }
        retirer(montant);
        autreCompte.deposer(montant);
    }

    @Override
    public String toString() {
        return "CompteBancaire{" +
                "numeroCompte='" + numeroCompte + '\'' +
                ", solde=" + solde +
                ", nomTitulaire='" + nomTitulaire + '\'' +
                '}';
    }
}
