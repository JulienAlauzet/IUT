public class GestionEmployes {

    public static void main(String[] args) {
        Employe employe1 = new EmployeBuilder()
                .setNom("Toto")
                .setPrenom("Lolo")
                .setBase(20)
                .setNbHeures(120)
                .createEmploye();
        System.out.println(employe1);

        /*Commercial commercial1 = new CommercialBuilder()
                .setBase(30)
                .setNbHeures(100)
                .createCommercial();*/

        Fabricant fabricant1 = new FabricantBuilder()
                .setBase(15)
                .setNbHeures(150)
                .createFabricant();

        Technicien technicien1 = new TechnicienBuilder()
                .setBase(15)
                .setNbHeures(100)
                .createTechnicien();

        System.out.println(technicien1);
        technicien1.effectuerTacheTechnique();

        /*System.out.println(commercial1);
        commercial1.negocierTransaction();*/

        System.out.println(fabricant1);
        fabricant1.fabriquerProduit();


    }

}
