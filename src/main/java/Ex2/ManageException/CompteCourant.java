package Ex2.ManageException;

public class CompteCourant extends CompteBancaire{
    private double decouvertAutorise;

    public CompteCourant(String numeroCompte, String nomTitulaire, double soldeInitial, double decouvertAutorise) {
        super(numeroCompte, nomTitulaire, soldeInitial);
        this.decouvertAutorise = decouvertAutorise;
    }

    @Override
    public void retirer(double montant) throws FondsInsuffisantsException {
        if (getSolde() - montant < -decouvertAutorise) {
            throw new FondsInsuffisantsException("Fonds insuffisants pour le retrait avec le découvert autorisé.");
        }
        super.deposer(-montant);
    }
}
