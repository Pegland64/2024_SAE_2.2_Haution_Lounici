package Main;

import java.util.List;

public class BellmanFord {
    public static Valeur resoudre(Graphe g, String depart) {
        // initialisation
        Valeur v = new Valeur();
        List<String> noeuds = g.listeNoeuds();
        for (String n : noeuds) {
            v.setValeur(n, Double.MAX_VALUE);
            v.setParent(n, null);
        }
        v.setValeur(depart, 0);

        for (int i = 0; i < noeuds.size(); i++) {
            for (String n : noeuds) {
                List<Arc> suivants = g.suivants(n);
                for (Arc a : suivants) {
                    double cout = v.getValeur(n) + a.getCout();
                    if (cout < v.getValeur(a.getDest())) {
                        v.setValeur(a.getDest(), cout);
                        v.setParent(a.getDest(), n);
                    }
                }
            }
        }
        return v;
    }
}
