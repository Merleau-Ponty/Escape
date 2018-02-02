package metier;

public class DemandeIntervention {

    private int di_id;
    private Partie partie;
    private Enigme enigme;
    private boolean di_clic = false;

    public DemandeIntervention(int di_id, Partie partie, Enigme enigme, Boolean di_clic){
        this.di_id = di_id;
        this.partie = partie;
        this.enigme = enigme;
        this.di_clic= di_clic;
    }



    public int getDi_id() {
        return di_id;
    }

    public void setDi_clic(boolean di_clic) {
        this.di_clic = di_clic;
    }

    //GET CLIC DemandeIntervention
    public boolean isDi_clic() {
        return di_clic;
    }

    public Partie getPartie() {
        return partie;
    }

    public void setPartie(Partie partie) {
        this.partie = partie;
    }

    public Enigme getEnigme() {
        return enigme;
    }

    public void setEnigme(Enigme enigme) {
        this.enigme = enigme;
    }
}
