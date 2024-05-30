
import org.junit.jupiter.api.Test;
import Main.Arc;
import Main.GrapheListe;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;


public class TestGraphe {

    @Test
    public void testAjouterNoeuds() {
        GrapheListe graphe = new GrapheListe();
        graphe.ajouterArc("A", "B", 12);
        graphe.ajouterArc("A", "C", 19);
        graphe.ajouterArc("B", "D", 23);
        graphe.ajouterArc("B", "E", 11);
        graphe.ajouterArc("C", "D", 10);
        graphe.ajouterArc("D", "A", 87);
        graphe.ajouterArc("D", "E", 43);

        List<String> noeuds = graphe.listeNoeuds();
        assertEquals(5, noeuds.size());
        assertTrue(noeuds.contains("A"));
        assertTrue(noeuds.contains("B"));
        assertTrue(noeuds.contains("C"));
        assertTrue(noeuds.contains("D"));
        assertTrue(noeuds.contains("E"));
    }

    @Test
    public void testAjoutArcs() {
        GrapheListe graphe = new GrapheListe();
        graphe.ajouterArc("A", "B", 12);
        graphe.ajouterArc("A", "C", 19);
        graphe.ajouterArc("B", "D", 23);
        graphe.ajouterArc("B", "E", 11);
        graphe.ajouterArc("C", "D", 10);
        graphe.ajouterArc("D", "A", 87);
        graphe.ajouterArc("D", "E", 43);

        List<Arc> arcs = graphe.suivants("A");
        assertEquals(2, arcs.size());
        assertTrue(graphe.containsArc(new Arc("D", 23)));
        assertTrue(graphe.containsArc(new Arc("C", 19)));

        List<Arc> arcsB = graphe.suivants("B");
        assertEquals(2, arcsB.size());
        assertTrue(graphe.containsArc(new Arc("D", 23)));
        assertTrue(graphe.containsArc(new Arc("E", 11)));

        List<Arc> arcsC = graphe.suivants("C");
        assertEquals(1, arcsC.size());
        assertTrue(graphe.containsArc(new Arc("D", 10)));

        List<Arc> arcsD = graphe.suivants("D");
        assertEquals(2, arcsD.size());
        assertTrue(graphe.containsArc(new Arc("A", 87)));
        assertTrue(graphe.containsArc(new Arc("E", 43)));

        List<Arc> arcsE = graphe.suivants("E");
        assertEquals(0, arcsE.size());
    }

    @Test
    public void
}