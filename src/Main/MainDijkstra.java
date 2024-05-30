package Main;

import java.util.List;

public class MainDijkstra {
    public static void main(String[] args) {
        GrapheListe grapheListe = new GrapheListe();
        grapheListe.ajouterArc("D", "B", 23);
        grapheListe.ajouterArc("D", "C", 10);
        grapheListe.ajouterArc("B", "E", 11);
        grapheListe.ajouterArc("C", "A", 19);
        grapheListe.ajouterArc("A", "B", 12);
        grapheListe.ajouterArc("A", "D", 87);

        Dijkstra dijkstra = new Dijkstra();
        Valeur v = dijkstra.resoudre(grapheListe, "D");

        List<String> noeuds = List.of("A", "B", "C", "E");
        for (String noeud : noeuds) {
            List<String> chem1 = v.calculerChemin(noeud);
            System.out.println("Le chemin le plus court en partant de " + noeud + " est : " + chem1);
        }
    }
}