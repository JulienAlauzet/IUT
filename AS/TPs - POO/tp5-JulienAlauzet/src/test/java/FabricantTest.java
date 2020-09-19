import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class FabricantTest {
    Fabricant fabricant;
@Disabled
    @Test
    public void Q4_base_15_nbHeure_100_nbUnitesProd5_taux100_brut_should_give_2000 () {
        fabricant = new FabricantBuilder()
                .setBase(15)
                .setNbHeures(100)
                .setNbUnitesProduites(5)
                .setTauxComissionUnite(100)
                .createFabricant();
        assertEquals(fabricant.getSalaireBrut(), 2000);
    }

@Disabled
    @Test
    public void Q4_base_15_nbHeure_100_nbUnitesProd5_taux100_net_should_give_1600 () {
        fabricant = new FabricantBuilder()
                .setBase(15)
                .setNbHeures(100)
                .setNbUnitesProduites(5)
                .setTauxComissionUnite(100)
                .createFabricant();
        assertEquals(fabricant.getSalaireNet(), 1600 );
    }

@Disabled
    @Test
    public void Q4_base_20_nbHeure_100_nbUnitesProd5_taux100_brut_should_give_2500 () {
        fabricant = new FabricantBuilder()
                .setBase(20)
                .setNbHeures(100)
                .setNbUnitesProduites(5)
                .setTauxComissionUnite(100)
                .createFabricant();
        assertEquals(fabricant.getSalaireBrut(), 2500 );
    }


@Disabled
    @Test
    public void Q4_base_20_nbHeure_100_nbUnitesProd5_taux100_net_should_give_2000 () {
        fabricant = new FabricantBuilder()
                .setBase(20)
                .setNbHeures(100)
                .setNbUnitesProduites(5)
                .setTauxComissionUnite(100)
                .createFabricant();
        assertEquals(fabricant.getSalaireNet(), 2000 );
    }

@Disabled
    @Test
    public void Q4_15_200_5_100_brut_should_give_3500 () {
        fabricant = new FabricantBuilder()
                .setBase(15)
                .setNbHeures(200)
                .setNbUnitesProduites(5)
                .setTauxComissionUnite(100)
                .createFabricant();
        assertEquals(fabricant.getSalaireBrut(), 3500);
    }

@Disabled
    @Test
    public void Q4_15_200_5_100_net_should_give_3500 () {
        fabricant = new FabricantBuilder()
                .setBase(15)
                .setNbHeures(200)
                .setNbUnitesProduites(5)
                .setTauxComissionUnite(100)
                .createFabricant();
        assertEquals(fabricant.getSalaireNet(), 2800);
    }
@Disabled
    @Test
    public void Q4_15_200_10_100_brut_should_give_4000 () {
        fabricant = new FabricantBuilder()
                .setBase(15)
                .setNbHeures(200)
                .setNbUnitesProduites(10)
                .setTauxComissionUnite(100)
                .createFabricant();
        assertEquals(fabricant.getSalaireBrut(), 4000);
    }

@Disabled
    @Test
    public void Q4_15_200_10_100_net_should_give_3200 () {
        fabricant = new FabricantBuilder()
                .setBase(15)
                .setNbHeures(200)
                .setNbUnitesProduites(10)
                .setTauxComissionUnite(100)
                .createFabricant();
        assertEquals(fabricant.getSalaireNet(), 3200);
    }
@Disabled
    @Test
    public void Q4_15_200_10_50_brut_should_give_3500 () {
        fabricant = new FabricantBuilder()
                .setBase(15)
                .setNbHeures(200)
                .setNbUnitesProduites(10)
                .setTauxComissionUnite(50)
                .createFabricant();
        assertEquals(fabricant.getSalaireBrut(), 3500);
    }

@Disabled
    @Test
    public void Q4_15_200_10_50_net_should_give_2800 () {
        fabricant = new FabricantBuilder()
                .setBase(15)
                .setNbHeures(200)
                .setNbUnitesProduites(10)
                .setTauxComissionUnite(50)
                .createFabricant();
        assertEquals(fabricant.getSalaireNet(), 2800);
    }

    @Test
    public void Q5_15_200_10_50_brut_should_give_3600 () {
        fabricant = new FabricantBuilder()
                .setBase(15)
                .setNbHeures(200)
                .setNbUnitesProduites(10)
                .setTauxComissionUnite(50)
                .createFabricant();
        assertEquals(fabricant.getSalaireBrut(), 3600);
    }
}