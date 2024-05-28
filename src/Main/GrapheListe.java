package Main;

import java.util.*;

public class GrapheListe implements Graphe{
    ArrayList<String> noeuds;
    ArrayList<Arcs> adjacence;

    public GrapheListe() {
        this.noeuds = new ArrayList<String>();
        this.adjacence = new ArrayList<Arcs>();
    }

    public int getIndice(String n) {
        return this.noeuds.indexOf(n);
    }

    public void ajouterArc(String depart, String destination, double cout) {
        int i = this.getIndice(depart);
        if (i == -1) {
            this.noeuds.add(depart);
            this.adjacence.add(new Arcs());
            i = this.noeuds.size() - 1;
        }
        this.adjacence.get(i).ajouterArc(new Arc(destination, cout));
    }

    public List<String> listeNoeuds() {
        return this.noeuds;
    }

    public List<Arc> suivants(String n) {
        int i = this.getIndice(n);
        if (i == -1) {
            return null;
        }
        return this.adjacence.get(i).getArcs();
    }

    public String ToString() {
        String res = "";
        for (int i = 0; i < this.noeuds.size(); i++) {
            res += this.noeuds.get(i) + " -> " + this.adjacence.get(i).ToString() + "\n";
        }
        return res;
    }


}
