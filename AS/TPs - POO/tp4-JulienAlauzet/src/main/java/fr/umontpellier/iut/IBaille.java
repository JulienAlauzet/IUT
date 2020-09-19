package fr.umontpellier.iut;
import java.util.Scanner;

public class IBaille {
    public static void main(String[] args) {
        int produit;
        int prixEnchere;
        int prixMax;
        Scanner saisie;
        Produit produit1 = new Produit(1, "Windows", 50, 5);
        produit1.demarrerEnchere();
        Produit produit2 = new Produit(1, "Ubuntu", 100, 10);
        produit2.demarrerEnchere();
        Compte compte1 = new Compte("Toto", "toto@gmail.com", "rue de Toto");
        compte1.créditerCompte(100);
        Compte compte2 = new Compte("Tutu", "tutu@gmail.com", "rue de Tutu");
        compte2.créditerCompte(150);
        Compte compte3 = new Compte("Titi", "titi@gmail.com", "rue de Titi");
        saisie = new Scanner(System.in);
        System.out.println("Bonjour " + compte1 + "\nVoici les produits existants :\n" + produit1 + "\n" + produit2 + "\n Sur lequel souhaitez vous enchérir? (0, 1, 2)\nVotre choix : ");
        produit = saisie.nextInt();
        if (produit == 1 || produit == 2) {
            saisie = new Scanner(System.in);
            System.out.println("Prix choisi :");
            prixEnchere = saisie.nextInt();
            saisie = new Scanner(System.in);
            System.out.println("Prix max :");
            prixMax = saisie.nextInt();
            if (produit == 1)
                compte1.creerOffre(produit1, prixEnchere, prixMax);
            else
                compte1.creerOffre(produit2, prixEnchere, prixMax);
        }
        saisie = new Scanner(System.in);
        System.out.println("Bonjour " + compte2 + "\nVoici les produits existants :\n" + produit1 + "\n" + produit2 + "\n Sur lequel souhaitez vous enchérir? (0, 1, 2)\nVotre choix : ");
        produit = saisie.nextInt();
        if (produit == 1 || produit == 2) {
            saisie = new Scanner(System.in);
            System.out.println("Prix choisi :");
            prixEnchere = saisie.nextInt();
            saisie = new Scanner(System.in);
            System.out.println("Prix max :");
            prixMax = saisie.nextInt();
            if (produit == 1)
                compte2.creerOffre(produit1, prixEnchere, prixMax);
            else
                compte2.creerOffre(produit2, prixEnchere, prixMax);
        }
        saisie = new Scanner(System.in);
        System.out.println("Bonjour " + compte3 + "\nVoici les produits existants :\n" + produit1 + "\n" + produit2 + "\n Sur lequel souhaitez vous enchérir? (0, 1, 2)\nVotre choix : ");
        produit = saisie.nextInt();
        if (produit == 1 || produit == 2) {
            saisie = new Scanner(System.in);
            System.out.println("Prix choisi :");
            prixEnchere = saisie.nextInt();
            saisie = new Scanner(System.in);
            System.out.println("Prix max :");
            prixMax = saisie.nextInt();
            if (produit == 1)
                compte3.creerOffre(produit1, prixEnchere, prixMax);
            else
                compte3.creerOffre(produit2, prixEnchere, prixMax);
        }
        System.out.println("Voici l'état des enchères :\n" + produit1 + "\n" + produit2);
    }
}
