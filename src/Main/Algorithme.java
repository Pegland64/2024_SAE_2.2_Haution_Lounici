package Main;

/**
 * Interface Algorithme
 */

public interface Algorithme {
    /**
     * Permet de trouver les chemin les plus court pour aller d'un noeuds a un autre en fonction de la methode utiliser.
     * @param g Le graphe à traiter.
     * @param depart Le noeud de départ.
     * @return un tableau de la classe valeur avec les chemins les plus court mais qui change en fonction de la methode utiliser.
     */

    Valeur resoudre(Graphe g, String depart);
}