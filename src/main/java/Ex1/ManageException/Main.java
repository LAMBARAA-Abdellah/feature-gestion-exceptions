package Ex1.ManageException;

public class Main {
    public static void main(String[] args) {
        try {
            EntierNaturel entier = new EntierNaturel(5);
            System.out.println("Valeur initiale : " + entier.getVal());

            entier.setVal(10);
            System.out.println("Nouvelle valeur : " + entier.getVal());

            entier.decrementer();
            System.out.println("Valeur après décrémentation : " + entier.getVal());

            entier.setVal(-5);

        } catch (NombreNegatifException e) {
            System.err.println("Exception capturée : " + e.getMessage());
            System.err.println("Valeur erronée : " + e.getValeurErronee());
        }

        try {
            EntierNaturel entierNegatif = new EntierNaturel(-3);
        } catch (NombreNegatifException e) {
            System.err.println("Exception capturée : " + e.getMessage());
            System.err.println("Valeur erronée : " + e.getValeurErronee());
        }

        try {
            EntierNaturel entierZero = new EntierNaturel(0);
            entierZero.decrementer();
        } catch (NombreNegatifException e) {
            System.err.println("Exception capturée : " + e.getMessage());
            System.err.println("Valeur erronée : " + e.getValeurErronee());
        }
    }
}