package Main;

import java.util.List;

/**
 * L'interface Graphe représente un graphe.
 * Un graphe est défini par une liste de noeuds et une liste d'arcs pour chaque noeud.
 */

public interface Graphe {
    /**
     * Retourne la liste des noeuds du graphe.
     * @return La liste des noeuds du graphe.
     */
    public List<String> listeNoeuds();

    /**
     * Retourne la liste des arcs suivants d'un noeud donné.
     * @param n Le noeud dont on veut obtenir les arcs suivants.
     * @return La liste des arcs suivants du noeud.
     */

    public List<Arc> suivants(String n);
}
