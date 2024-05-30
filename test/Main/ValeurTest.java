package Main;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValeurTest {
    @Test
    public void TestPointFixe(){
        GrapheListe g = new GrapheListe();
        g.ajouterArc("D", "B", 23);
        g.ajouterArc("D", "C", 10);
        g.ajouterArc("B", "E", 11);
        g.ajouterArc("C", "A", 19);
        g.ajouterArc("A", "B", 12);
        g.ajouterArc("A", "D", 87);

        Valeur v = BellmanFord.resoudre(g, "D");

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
}