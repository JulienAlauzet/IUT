import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RepresentantTest {

    @Test
    public void echelon2_base10_nbHeures100_brut_should_give_1300() {
        Representant representant = new RepresentantBuilder()
                .setBase(10)
                .setNbHeures(100)
                .setEchelon(2)
                .createRepresentant();
        assertEquals(representant.getSalaireBrut(), 1300);
    }

}