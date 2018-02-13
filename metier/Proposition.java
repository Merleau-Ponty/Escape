package metier;

public class Proposition {
    private int pr_id;
    private Partie Partie;
    private Enigme enigme;
    private String pr_texte;
    private boolean pr_valide;

    public Proposition(int pr_id, Partie Partie, Enigme enigme, String pr_texte, boolean pr_valide){
        this.pr_id = pr_id;
        this.Partie = Partie;
        this.enigme = enigme;
        this.pr_texte = pr_texte;
        this.pr_valide = pr_valide;
    }

    public int getPr_id() {
        return pr_id;
    }

    public Partie getPartie() {
        return Partie;
    }

    public void setPartie(Partie partie) {
        Partie = partie;
    }

    public Enigme getEnigme() {
        return enigme;
    }

    public void setEnigme(Enigme enigme) {
        enigme = enigme;
    }

    public String getPr_texte() {
        return pr_texte;
    }

    public void setPr_texte(String pr_texte) {
        this.pr_texte = pr_texte;
    }

    public boolean isPr_valide() {
        if(pr_texte == enigme.getE_reponse()){
            pr_valide = true;
        }
        return pr_valide;
    }

    public void setPr_valide(boolean pr_valide) {
        this.pr_valide = pr_valide;
    }
}
