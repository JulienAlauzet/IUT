import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TechnicienTest {

    Technicien technicien;
@Disabled
    @Test
    public void Q4_base_15_nbHeure_100_echelon2_brut_should_give_1700() {
        technicien = new TechnicienBuilder()
                .setBase(15)
                .setNbHeures(100)
                .setEchelon(2)
                .createTechnicien();
        assertEquals(technicien.getSalaireBrut(), 1700);
    }

@Disabled
    @Test
    public void Q4_base_15_nbHeure_100_echelon2_net_should_give_1700 () {
        technicien = new TechnicienBuilder()
                .setBase(15)
                .setNbHeures(100)
                .setEchelon(2)
                .createTechnicien();
        assertEquals(technicien.getSalaireNet(), 1360);
    }

@Disabled
    @Test
    public void Q4_base_15_nbHeure_100_echelon0_brut_should_give_1500 () {
        technicien = new TechnicienBuilder()
                .setBase(15)
                .setNbHeures(100)
                .setEchelon(0)
                .createTechnicien();
        assertEquals(technicien.getSalaireBrut(), 1500);
    }


@Disabled
    @Test
    public void Q4_base_15_nbHeure_100_echelon0_net_should_give_1200 () {
        technicien = new TechnicienBuilder()
                .setBase(15)
                .setNbHeures(100)
                .setEchelon(0)
                .createTechnicien();
        assertEquals(technicien.getSalaireNet(), 1200);
    }

@Disabled
    @Test
    public void Q4_base_10_nbHeure_100_echelon2_brut_should_give_1200 () {
        technicien = new TechnicienBuilder()
                .setBase(10)
                .setNbHeures(100)
                .setEchelon(2)
                .createTechnicien();
        assertEquals(technicien.getSalaireBrut(), 1200);
    }

@Disabled
    @Test
    public void Q4_base_10_nbHeure_100_echelon2_net_should_give_960 () {
        technicien = new TechnicienBuilder()
                .setBase(10)
                .setNbHeures(100)
                .setEchelon(2)
                .createTechnicien();
        assertEquals(technicien.getSalaireNet(), 960);
    }
@Disabled
    @Test
    public void Q4_base_15_nbHeure_200_echelon2_brut_should_give_3200 () {
        technicien = new TechnicienBuilder()
                .setBase(15)
                .setNbHeures(200)
                .setEchelon(2)
                .createTechnicien();
        assertEquals(technicien.getSalaireBrut(), 3200);
    }


@Disabled
    @Test
    public void Q4_base_15_nbHeure_200_echelon2_net_should_give_2560 () {
        technicien = new TechnicienBuilder()
                .setBase(15)
                .setNbHeures(200)
                .setEchelon(2)
                .createTechnicien();
        assertEquals(technicien.getSalaireNet(), 2560);
    }

    @Test
    public void Q5_base_15_nbHeure_200_echelon2_brut_should_give_3300 () {
        technicien = new TechnicienBuilder()
                .setBase(15)
                .setNbHeures(200)
                .setEchelon(2)
                .createTechnicien();
        assertEquals(technicien.getSalaireBrut(), 3300);
    }

}