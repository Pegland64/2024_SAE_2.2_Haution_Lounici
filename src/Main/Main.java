package Main;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        GrapheListe g = new GrapheListe();
        g.ajouterArc("D", "B", 23);
        g.ajouterArc("D", "C", 10);
        g.ajouterArc("B", "E", 11);
        g.ajouterArc("C", "A", 19);
        g.ajouterArc("A", "B", 12);
        g.ajouterArc("A", "D", 87);

        System.out.println(g.ToString());

        BellmanFord bellmanFord = new BellmanFord();
        Valeur v = bellmanFord.resoudre(g, "D");
        System.out.println(v.toString());

        List<String> l = v.calculerChemin("A");
        System.out.println(l.toString());

        GrapheListe g2 = new GrapheListe("C:/Users/pegla/OneDrive/Bureau/SAE 2.2/2024_SAE_2.2_Haution_Lounici/src/Ex_Graphe/Graphe1.txt");
        System.out.println(g2.ToString());

    }
}
