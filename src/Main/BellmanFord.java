package Main;

import java.util.List;

/**
 * La classe BellmanFord implémente l'interface Algorithme.
 * Elle utilise l'algorithme de Bellman-Ford pour résoudre le problème du plus court chemin.
 */

public class BellmanFord implements Algorithme{

    /**
     * Résout le problème du plus court chemin en utilisant l'algorithme de Bellman-Ford / du Point Fixe.
     * @param g Le graphe à traiter.
     * @param depart Le noeud de départ.
     * @return Un objet de type Valeur qui contient les valeurs et les parents de chaque noeud.
     */

    public Valeur resoudre(Graphe g, String depart) {
        // On créer un tableau de type Valeur qui met toutes les valeurs à +infini (Double.MAX_VALUE) sauf pour le départ qui est à 0
        Valeur v = new Valeur();
        List<String> noeuds = g.listeNoeuds();
        for (String n : noeuds) {
            v.setValeur(n, Double.MAX_VALUE);
            v.setParent(n, null);
        }
        v.setValeur(depart, 0);

        // On parcourt tous les noeuds et on regarde si on peut améliorer la valeur de leur voisin
        // valeurModifiee permet de savoir si on a modifié une valeur ou pas et donc savoir si on a atteint le point fixe ou non
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
