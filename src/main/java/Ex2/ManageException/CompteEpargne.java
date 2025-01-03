package Ex2.ManageException;

public class CompteEpargne extends CompteBancaire{
    private double tauxInteret;
    public CompteEpargne(String numeroCompte, String nomTitulaire, double soldeInitial, double tauxInteret) {
        super(numeroCompte, nomTitulaire, soldeInitial);
        this.tauxInteret = tauxInteret;
    }

    public void appliquerInteret() {
        double interet = getSolde() * tauxInteret / 100;
        deposer(interet);
    }
}