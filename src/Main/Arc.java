package Main;

public class Arc {
    private String dest;
    private double cout;

    public Arc(String dest, double cout) {
        this.dest = dest;
        this.cout = cout;
    }

    public String ToString() {
        return this.dest + "(" + this.cout + ")";
    }
}
