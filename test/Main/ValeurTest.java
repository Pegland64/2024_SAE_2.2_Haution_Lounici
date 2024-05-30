package Main;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValeurTest {
    @Test
    public void TestPointFixe() {
        GrapheListe g = new GrapheListe();
        g.ajouterArc("D", "B", 23);
        g.ajouterArc("D", "C", 10);
        g.ajouterArc("B", "E", 11);
        g.ajouterArc("C", "A", 19);
        g.ajouterArc("A", "B", 12);
        g.ajouterArc("A", "D", 87);

        BellmanFord bellmanFord = new BellmanFord();
        Valeur v = bellmanFord.resoudre(g, "D");

        assertEquals(0, v.getValeur("D"));
        assertEquals(23, v.getValeur("B"));
        assertEquals(10, v.getValeur("C"));
        assertEquals(34, v.getValeur("E"));
        assertEquals(29, v.getValeur("A"));

        assertEquals(null, v.getParent("D"));
        assertEquals("D", v.getParent("B"));
        assertEquals("D", v.getParent("C"));
        assertEquals("B", v.getParent("E"));
        assertEquals("C", v.getParent("A"));
    }

    @Test
    public void testDijkstra() {
        GrapheListe g = new GrapheListe();
        g.ajouterArc("D", "B", 23);
        g.ajouterArc("D", "C", 10);
        g.ajouterArc("B", "E", 11);
        g.ajouterArc("C", "A", 19);
        g.ajouterArc("A", "B", 12);
        g.ajouterArc("A", "D", 87);

        Dijkstra dijkstra = new Dijkstra();
        Valeur v = dijkstra.resoudre(g, "D");

        assertEquals(0.0, v.getValeur("D"), 0.001);
        assertEquals(23.0, v.getValeur("B"), 0.001);
        assertEquals(10.0, v.getValeur("C"), 0.001);
        assertEquals(34.0, v.getValeur("E"), 0.001);
        assertEquals(29.0, v.getValeur("A"), 0.001);

        assertNull(v.getParent("D"));
        assertEquals("D", v.getParent("B"));
        assertEquals("D", v.getParent("C"));
        assertEquals("B", v.getParent("E"));
        assertEquals("C", v.getParent("A"));
    }
}