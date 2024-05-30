package Main;

import Main.Arc;
import Main.Arcs;
import Main.Graphe;

import java.util.*;

public class GrapheListe implements Graphe {
    private ArrayList<String> noeuds;
    private ArrayList<Arcs> adjacence;

    public GrapheListe() {
        this.noeuds = new ArrayList<>();
        this.adjacence = new ArrayList<>();
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

        int j = this.getIndice(destination);
        if (j == -1) {
            this.noeuds.add(destination);
            this.adjacence.add(new Arcs());
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
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < this.noeuds.size(); i++) {
            res.append(this.noeuds.get(i)).append(" -> ").append(this.adjacence.get(i).ToString()).append("\n");
        }
        return res.toString();
    }

    public boolean containsArc(Arc arc) {
        for (Arcs arcsList : this.adjacence) {
            for(Arc arcList : arcsList.getArcs()) {
                if (arcList.estEgalA(arc)) {
                    return true;
                }
            }
        }
        return false;
    }
}
