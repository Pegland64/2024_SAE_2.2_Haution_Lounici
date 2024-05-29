
import org.junit.jupiter.api.Test;
import Main.Arc;
import Main.GrapheListe;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;


public class TestGraphe {
    public void testAjouterArc(){
        GrapheListe graphe = new GrapheListe();
        graphe.ajouterArc("A", "B", 12);
        graphe.ajouterArc("A", "C", 19);
        graphe.ajouterArc("B", "D", 23);
        graphe.ajouterArc("B", "E", 11);
        graphe.ajouterArc("C", "D", 10);
        graphe.ajouterArc("D", "A", 87);
        graphe.ajouterArc("D", "E", 43);

        List<Arc> arcsA = graphe.suivants("A");
        assertEquals(2, arcsA.size());
        assertTrue(arcsA.contains(new Arc("B", 12)));
        assertTrue(arcsA.contains(new Arc("C", 19)));

        List<Arc> arcsB = graphe.suivants("B");
        assertEquals(2, arcsB.size());
        assertTrue(arcsB.contains(new Arc("D", 23)));
        assertTrue(arcsB.contains(new Arc("E", 11)));

        List<Arc> arcsC = graphe.suivants("C");
        assertEquals(1, arcsC.size());
        assertTrue(arcsC.contains(new Arc("D", 10)));

        List<Arc> arcsD = graphe.suivants("D");
        assertEquals(2, arcsD.size());
        assertTrue(arcsD.contains(new Arc("A", 87)));
        assertTrue(arcsD.contains(new Arc("E", 43)));
    }
}
