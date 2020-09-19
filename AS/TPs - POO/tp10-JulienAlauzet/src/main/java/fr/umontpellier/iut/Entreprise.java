package fr.umontpellier.iut;

import java.time.LocalDate;
import java.util.*;

public class Entreprise {
    private Collection<Employe> lePersonnel;
    private double bonusTotal;

    public Entreprise() {
        lePersonnel = new ArrayList<>();
    }

    public void embaucher(Employe e, LocalDate dateEmbauche){
        e.setDateEmbauche(dateEmbauche);
        lePersonnel.add(e);
    }

    public void licencier(Employe e){
        lePersonnel.remove(e);
    }

    @Override
    public String toString() {
        String res = "Voici le personnel de votre entreprise:";
        for (Employe e :
                lePersonnel) {
            res += "\n\n" + e.toString();
        }
        return res;
    }

    public Collection<Employe> getEmployes(){
        TreeSet<Employe> listeTriee;
        listeTriee = new TreeSet(new ComparateurEmploye());
        listeTriee.addAll(lePersonnel);
        return listeTriee;
    }

    public void setBonusTotal(double bonusTotal) {
        this.bonusTotal = bonusTotal;
    }

    public void distribuerBonus() {
        PriorityQueue<Employe> file = new PriorityQueue<Employe>((o1, o2) -> o1.getDateEmbauche().compareTo(o2.getDateEmbauche()));
        file.addAll(lePersonnel);
        while (!file.isEmpty() && bonusTotal > 0) {
            Employe courant = file.poll();
            double bonusIndividuel = courant.getMoisAnciennete()*3;
            if (bonusIndividuel > bonusTotal) {
                bonusIndividuel = bonusTotal;
                bonusTotal = 0;
            }
            else
                bonusTotal -= bonusIndividuel;
            courant.setBonus(bonusIndividuel);
        }
    }

    public void remercier(int n) {
        PriorityQueue<Employe> file = new PriorityQueue<Employe>((o1, o2) -> o2.getDateEmbauche().compareTo(o1.getDateEmbauche()));
        file.addAll(lePersonnel);
        while (n > 0 && !file.isEmpty()) {
            Employe employeAVirer = file.poll();
            lePersonnel.removeIf(employe -> employe.equals(employeAVirer) && employe.getDateEmbauche().equals(employeAVirer.getDateEmbauche()));
            n--;
        }
    }
}
