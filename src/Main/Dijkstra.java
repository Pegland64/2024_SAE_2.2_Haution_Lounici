package Main;

import java.util.ArrayList;
import java.util.List;

/**
 * La classe Dijkstra implémente l'interface Algorithme.
 * Elle utilise l'algorithme de Dijkstra pour résoudre le problème du plus court chemin.
 */

public class Dijkstra implements Algorithme{
    /**
     * Entrées :
     * G un graphe orienté avec une pondération positive des arcs (coût ou poids)
     * A un sommet (départ) de G
     *
     * Début
     * Q <- {} // utilisation d’une liste de noeuds à traiter
     * Pour chaque sommet v de G faire
     *   v.valeur <- Infini
     *   v.parent <- Indéfini
     *   Q <- Q U {v} // ajouter le sommet v à la liste Q
     * Fin Pour
     * A.valeur <- 0
     * Tant que Q est un ensemble non vide faire
     *   u <- un sommet de Q telle que u.valeur est minimal
     *   // enlever le sommet u de la liste Q
     *   Q <- Q \ {u}
     *   Pour chaque sommet v de Q tel que l’arc (u,v) existe faire
     *     d <- u.valeur + poids(u,v)
     *     Si d < v.valeur
     *       // le chemin est plus intéressant
     *       Alors v.valeur <- d
     *       v.parent <- u
     *     Fin Si
     *   Fin Pour
     * Fin Tant que
     * Fin
     */

    /**
     * Résout le problème du plus court chemin en utilisant l'algorithme de Dijkstra.
     * @param graphe Le graphe à traiter.
     * @param depart Le noeud de départ.
     * @return Un objet de type Valeur qui contient les valeurs et les parents de chaque noeud.
     */

    public Valeur resoudre(Graphe graphe, String depart) {
        Valeur resultat = new Valeur();
        List<String> noeuds = graphe.listeNoeuds();

        for (String noeud : noeuds) {
            resultat.setValeur(noeud, Double.POSITIVE_INFINITY);
            resultat.setParent(noeud, null);
        }
        resultat.setValeur(depart, 0.0);

        List<String> nonVisites = new ArrayList<>(noeuds);

        while (!nonVisites.isEmpty()) {
            String courant = nonVisites.get(0);
            for (String noeud : nonVisites) {
                if (resultat.getValeur(noeud) < resultat.getValeur(courant)) {
                    courant = noeud;
                }
            }
            nonVisites.remove(courant);

            List<Arc> arcsSortants = graphe.suivants(courant);
            if (arcsSortants != null) {
                for (Arc arc : arcsSortants) {
                    String voisin = arc.getDest();
                    double nouvelleDistance = resultat.getValeur(courant) + arc.getCout();
                    if (nouvelleDistance < resultat.getValeur(voisin)) {
                        resultat.setValeur(voisin, nouvelleDistance);
                        resultat.setParent(voisin, courant);
                    }
                }
            }
        }

        return resultat;
    }
}
