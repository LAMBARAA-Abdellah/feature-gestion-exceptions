package Ex2.ManageException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<CompteBancaire> comptes = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Ajouter un compte");
            System.out.println("2. Supprimer un compte");
            System.out.println("3. Effectuer un dépôt");
            System.out.println("4. Effectuer un retrait");
            System.out.println("5. Transférer de l'argent");
            System.out.println("6. Afficher les comptes");
            System.out.println("7. Quitter");
            System.out.print("Choisissez une option: ");

            int choix = scanner.nextInt();
            scanner.nextLine(); // Consomme la nouvelle ligne

            try {
                switch (choix) {
                    case 1: // Ajouter un compte
                        System.out.print("Type de compte (1: Courant, 2: Épargne): ");
                        int type = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Numéro de compte: ");
                        String numero = scanner.nextLine();
                        System.out.print("Nom du titulaire: ");
                        String titulaire = scanner.nextLine();
                        System.out.print("Solde initial: ");
                        double solde = scanner.nextDouble();

                        if (type == 1) {
                            System.out.print("Découvert autorisé: ");
                            double decouvert = scanner.nextDouble();
                            comptes.add(new CompteCourant(numero, titulaire, solde, decouvert));
                        } else if (type == 2) {
                            System.out.print("Taux d'intérêt: ");
                            double taux = scanner.nextDouble();
                            comptes.add(new CompteEpargne(numero, titulaire, solde, taux));
                        } else {
                            System.out.println("Type de compte invalide.");
                        }
                        break;

                    case 2: // Supprimer un compte
                        System.out.print("Numéro de compte à supprimer: ");
                        String numeroSupprimer = scanner.nextLine();
                        boolean removed = comptes.removeIf(compte -> compte.getNumeroCompte().equals(numeroSupprimer));
                        if (removed) {
                            System.out.println("Compte supprimé.");
                        } else {
                            throw new CompteInexistantException("Le compte source n'existe pas.");
                        }
                        break;

                    case 3: // Effectuer un dépôt
                        System.out.print("Numéro de compte: ");
                        String numeroDepot = scanner.nextLine();
                        System.out.print("Montant à déposer: ");
                        double montantDepot = scanner.nextDouble();

                        CompteBancaire compteDepot = findCompte(comptes, numeroDepot);
                        if (compteDepot != null) {
                            compteDepot.deposer(montantDepot);
                            System.out.println("Dépôt effectué. Nouveau solde: " + compteDepot.getSolde());
                        } else {
                            throw new CompteInexistantException("Le compte source n'existe pas.");
                        }
                        break;

                    case 4: // Effectuer un retrait
                        System.out.print("Numéro de compte: ");
                        String numeroRetrait = scanner.nextLine();
                        System.out.print("Montant à retirer: ");
                        double montantRetrait = scanner.nextDouble();

                        CompteBancaire compteRetrait = findCompte(comptes, numeroRetrait);
                        if (compteRetrait != null) {
                            compteRetrait.retirer(montantRetrait);
                            System.out.println("Retrait effectué. Nouveau solde: " + compteRetrait.getSolde());
                        } else {
                            throw new CompteInexistantException("Le compte source n'existe pas.");
                        }
                        break;

                    case 5: // Transférer de l'argent
                        System.out.print("Numéro du compte source: ");
                        String numeroSource = scanner.nextLine();
                        System.out.print("Numéro du compte destination: ");
                        String numeroDestination = scanner.nextLine();
                        System.out.print("Montant à transférer: ");
                        double montantTransfert = scanner.nextDouble();

                        CompteBancaire compteSource = findCompte(comptes, numeroSource);
                        CompteBancaire compteDestination = findCompte(comptes, numeroDestination);

                        if (compteSource != null && compteDestination != null) {
                            compteSource.transfererVers(compteDestination, montantTransfert);
                            System.out.println("Transfert effectué.");
                        } else {
                            if (compteSource == null) {
                                throw new CompteInexistantException("Le compte source n'existe pas.");
                            }
                            if (compteDestination == null) {
                                throw new CompteInexistantException("Le compte destination n'existe pas.");
                            }
                        }
                        break;

                    case 6: // Afficher les comptes
                        if (comptes.isEmpty()) {
                            System.out.println("Aucun compte disponible.");
                        } else {
                            comptes.forEach(System.out::println);
                        }
                        break;

                    case 7: // Quitter
                        System.out.println("Au revoir!");
                        scanner.close();
                        return;

                    default:
                        System.out.println("Option invalide. Veuillez réessayer.");
                }
            } catch (FondsInsuffisantsException | CompteInexistantException e) {
                System.err.println("Erreur: " + e.getMessage());
            } catch (Exception e) {
                System.err.println("Une erreur inattendue s'est produite: " + e.getMessage());
            }
        }
    }

    private static CompteBancaire findCompte(ArrayList<CompteBancaire> comptes, String numeroCompte) {
        for (CompteBancaire compte : comptes) {
            if (compte.getNumeroCompte().equals(numeroCompte)) {
                return compte;
            }
        }
        return null;
    }
}

