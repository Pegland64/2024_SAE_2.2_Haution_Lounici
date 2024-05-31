package Main;

import java.util.*;

/**
 * La classe Arcs représente une liste d'arcs dans un graphe.
 */

public class Arcs {
    List<Arc> arcs;

    /**
     * Constructeur de la classe Arcs.
     */

    public Arcs() {
        this.arcs = new ArrayList<Arc>();
    }

    /**
     * Ajoute un arc à la liste des arcs.
     * @param arc L'arc à ajouter.
     */

    public void ajouterArc(Arc arc) {
        this.arcs.add(arc);
    }

    /**
     * Retourne la liste des arcs.
     * @return La liste des arcs.
     */

    public List<Arc> getArcs() {
        return this.arcs;
    }

    /**
     * Retourne une Liste d'arc sous forme de String.
     * @return Une chaîne représentant la liste des arcs.
     */

    public String ToString() {
        String res = "";
        for (Arc a : this.arcs) {
            res += a.ToString() + " ";
        }
        return res;
    }
}
