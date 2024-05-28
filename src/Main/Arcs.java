package Main;

import java.util.*;

public class Arcs {
    List<Arc> arcs;

    public Arcs() {
        this.arcs = new ArrayList<Arc>();
    }

    public void ajouterArc(Arc arc) {
        this.arcs.add(arc);
    }

    public List<Arc> getArcs() {
        return this.arcs;
    }

    public String ToString() {
        String res = "";
        for (Arc a : this.arcs) {
            res += a.ToString() + " ";
        }
        return res;
    }
}
