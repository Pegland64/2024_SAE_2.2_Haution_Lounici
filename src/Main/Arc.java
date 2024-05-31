package Main;

/**
 * La classe Arc représente un arc dans un graphe.
 * Celui-ci est entre deux noeuds.
 * Un arc est défini par une destination et un coût.
 */

public class Arc {
    private double cout;
    private String dest;

    /**
     * Constructeur de la classe Arc.
     * @param dest La destination de l'arc.
     * @param cout Le coût de l'arc.
     */

    public Arc(String dest, double cout) {
        this.dest = dest;
        this.cout = cout;
    }

    /**
     * Retourne la destination de l'arc.
     * @return La destination de l'arc.
     */

    public String getDest() {
        return this.dest;
    }

    /**
     * Retourne le coût de l'arc.
     * @return Le coût de l'arc.
     */
    public double getCout() {
        return this.cout;
    }

    /**
     * Retourne la destination et le cout sous forme de String.
     * @return Une chaîne représentant l'arc.
     */

    public String ToString() {
        return this.dest + "(" + this.cout + ")";
    }

    /**
     * Vérifie si cet arc est égal à un autre arc.
     * @param arc L'autre arc à comparer.
     * @return true si les arcs sont égaux, false sinon.
     */

    public boolean estEgalA (Arc arc) {
        return this.dest.equals(arc.getDest()) && this.cout == arc.getCout();
    }
}
