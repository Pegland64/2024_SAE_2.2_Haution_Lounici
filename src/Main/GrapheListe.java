package Main;

import Main.Arc;
import Main.Arcs;
import Main.Graphe;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * La classe GrapheListe représente un graphe sous forme de liste d'adjacence.
 */

public class GrapheListe implements Graphe {
    private ArrayList<String> noeuds;
    private ArrayList<Arcs> adjacence;

    /**
     * Constructeur de la classe GrapheListe.
     */

    public GrapheListe() {
        this.noeuds = new ArrayList<>();
        this.adjacence = new ArrayList<>();
    }

    /**
     * Constructeur de la classe GrapheListe a partir d'un fichier texte.
     * @param filepath Le chemin du fichier contenant le graphe.
     */

    public GrapheListe(String filepath) {
        this.adjacence = new ArrayList<>();
        this.noeuds = new ArrayList<>();
        //on lit et on ajoute les arcs du fichier
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filepath));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\t");
                String noeud1 = parts[0];
                String noeud2 = parts[1];
                int cout = Integer.parseInt(parts[2]);
                this.ajouterArc(noeud1, noeud2, cout);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Retourne l'indice d'un noeud dans la liste des noeuds.
     * @param n Le noeud dont on veut l'indice.
     * @return L'indice du noeud.
     */

    public int getIndice(String n) {
        return this.noeuds.indexOf(n);
    }

    /**
     * Ajoute un arc au graphe.
     * @param depart Le noeud de départ de l'arc.
     * @param destination Le noeud de destination de l'arc.
     * @param cout Le coût de l'arc.
     */

    public void ajouterArc(String depart, String destination, double cout) {
        int i = this.getIndice(depart);
        //on verifie si le noeud de depart est deja present
        if (i == -1) {
            this.noeuds.add(depart);
            this.adjacence.add(new Arcs());
            i = this.noeuds.size() - 1;
        }
        //on verifie si le noeud de destination est deja present
        int j = this.getIndice(destination);
        if (j == -1) {
            this.noeuds.add(destination);
            this.adjacence.add(new Arcs());
        }
        //on ajooute l'arc
        this.adjacence.get(i).ajouterArc(new Arc(destination, cout));
    }


    /**
     * Retourne la liste des noeuds du graphe.
     * @return La liste des noeuds du graphe.
     */

    public List<String> listeNoeuds() {
        return this.noeuds;
    }

    /**
     * Retourne la liste des arcs suivants d'un noeud donné.
     * @param n Le noeud dont on veut obtenir les arcs suivants.
     * @return La liste des arcs suivants du noeud.
     */

    public List<Arc> suivants(String n) {
        int i = this.getIndice(n);
        if (i == -1) {
            return null;
        }
        return this.adjacence.get(i).getArcs();
    }

    /**
     * Retourne une représentation du graphe sous forme de String.
     * @return Une chaîne représentant le graphe.
     */

    public String ToString() {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < this.noeuds.size(); i++) {
            res.append(this.noeuds.get(i)).append(" -> ").append(this.adjacence.get(i).ToString()).append("\n");
        }
        return res.toString();
    }

    /**
     * Vérifie si un arc est présent dans le graphe.
     * @param arc L'arc à vérifier.
     * @return true si l'arc est présent.
     */

    public boolean containsArc(Arc arc) {
        //on parcourt la liste d'adjacence pour voir si l'arc est present
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
