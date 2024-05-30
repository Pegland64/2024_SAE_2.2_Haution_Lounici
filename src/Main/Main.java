package Main;

public class Main {
    public static void main(String[] args) {
        GrapheListe g = new GrapheListe();
        g.ajouterArc("D", "B", 23);
        g.ajouterArc("D", "C", 10);
        g.ajouterArc("B", "E", 11);
        g.ajouterArc("C", "A", 19);
        g.ajouterArc("A", "B", 12);
        g.ajouterArc("A", "D", 87);

        System.out.println(g.ToString());

        Valeur v = BellmanFord.resoudre(g, "D");
        System.out.println(v.toString());
    }
}
