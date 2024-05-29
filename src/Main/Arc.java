package Main;

public class Arc {
    private double cout;
    private String dest;

    public Arc(String dest, double cout) {
        this.dest = dest;
        this.cout = cout;
    }

    public String getDest() {
        return this.dest;
    }

    public double getCout() {
        return this.cout;
    }

    public String ToString() {
        return this.dest + "(" + this.cout + ")";
    }

    public boolean estEgalA (Arc arc) {
        return this.dest.equals(arc.getDest()) && this.cout == arc.getCout();
    }
}
