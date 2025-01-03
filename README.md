# Gestion des Comptes Bancaires

Ce projet est une application Java qui permet de gérer des comptes bancaires à travers différentes fonctionnalités interactives.

## Fonctionnalités

1. **Ajouter un compte** :
    - Compte courant avec un découvert autorisé.
    - Compte épargne avec un taux d'intérêt.

2. **Supprimer un compte** :
    - Supprime un compte existant à l'aide de son numéro.

3. **Effectuer un dépôt** :
    - Ajoute un montant spécifié au solde d'un compte existant.

4. **Effectuer un retrait** :
    - Retire un montant du solde d'un compte, en vérifiant que le solde est suffisant.

5. **Transférer de l'argent** :
    - Transfère des fonds d'un compte source vers un compte destination.

6. **Afficher les comptes** :
    - Liste tous les comptes avec leurs informations détaillées.

## Exceptions Gérées

- **FondsInsuffisantsException** :
    - Levée lors d'un retrait ou d'un transfert si le solde est insuffisant.

- **CompteInexistantException** :
    - Levée lorsqu'une opération est tentée sur un compte qui n'existe pas.

## Structure du Code

### Classes Principales

- **CompteBancaire** : Classe de base pour les comptes.
- **CompteCourant** : Hérite de `CompteBancaire` et permet un découvert autorisé.
- **CompteEpargne** : Hérite de `CompteBancaire` et applique un taux d'intérêt.

### Classe Main

- Fournit un menu interactif pour l'utilisateur.
- Appelle les méthodes nécessaires pour effectuer les opérations.

## Exécution

Pour exécuter le projet :

1. Compilez le projet avec `javac` :
   ```bash
   javac Main.java
   ```
2. Exécutez l'application :
   ```bash
   java Main
   ```

## Branche Git

- Branche principale : `main`
- Nouvelle branche pour modifications : `feature/gestion-comptes`

## Contribution

1. Clonez le dépôt :
   ```bash
   git clone https://github.com/LAMBARAA-Abdellah/feature-gestion-exceptions
   ```

2. Créez une nouvelle branche :
   ```bash
   git checkout -b feature/gestion-exceptions
   ```

3. Poussez vos modifications :
   ```bash
   git push origin feature/gestion-exceptions

   ```

## Licence

Ce projet est sous licence MIT.