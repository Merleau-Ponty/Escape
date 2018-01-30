package metier;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Partie {

    //déclarations variables
    private int p_id;
    final int scoreMax=10000; //Score maximum atteint
    private int p_score=0; //score initialisé à 0
    private ArrayList<Objectif> lesObjectifs ;

    //hashmap pour classe association
    private Map<Enigme, DemandeIntervention> enigmeIntervention;
    //key,value : ex : enigme1, DemandeIntervention.clic = false

    private Map<Enigme, Proposition> enigmeProposition;
    //Key,value : ex : enigme1, false si la proposition n'est pas correcte// true la proposition est correcte



    //constructeur
    public Partie(int p_id, int p_score){
        this.p_id = p_id;
        this.p_score = p_score;

        //Initialisation du HashMap dans le constructeur de Partie
        // On veut avoir pour chaque Enigme, la DemandeIntervention associée s'il y en a eu une, sinon false
        //
        // question : ne faudrait-il pas le faire plutôt dans la classe association ??
        //C'est bizarre, on ne peut pas accéder aux interventions d'une énigmes depuis énigme
        //mais on peut accéder à l'énigme et à la partie liées à la DemandeIntervantion...

        enigmeIntervention = new HashMap<Enigme, DemandeIntervention>();
        enigmeProposition = new HashMap<Enigme, Proposition>();
        //pour chaque Objectif
        /*for(Objectif o : lesObjectifs){
            for(Enigme e : o.lesEnigmes){
                enigmeIntervention.put(e.getE_titre()); //mettre l'objet interv avec un SELECT ?? (idée)
                //du style SELECT DemandeIntervention FROM DemandeIntervention
                // WHERE DemandeIntervention.partie = DemandeIntervention.enigme
            }
        }*/
    }//fin constructeur








    //METHODES ----------------------------------------------------

    /* CALCUL DU SCORE
    p_score =
    Somme des :
        points de LesEnigmes (dans Objectif) ALMOST CHECK (manque s'il a réussi l'énigme)
        + penalite par indice (dans Indice) CHECK
        + o_points_bonus (dans Objectif) CHECK
        + di_penalite NOT CHECK : manque hashmap pour savoir si EnigmeX a eu une DemandeInterventionX
    */
    public void calculScore(){
        //init
        int pointsEnigme=0;
        int penalitesIndice=0;
        int pointsBonus=0;
        int scoreTotal=0;
        int penaliteIntervention=0;
        int pointsEnigmeEtPenalites=0;

        //somme des points de toutes les énigmes de tous les objectifs
        for(Objectif lo : lesObjectifs){
            for(Enigme le : lo.lesEnigmes){

                //s'il a a réussi l'énigme on ajoute les points de l'énigme
                for (Map.Entry<Enigme, Proposition> p : enigmeProposition.entrySet()){
                    //si la proposition est valide
                    if(p.getValue().isPr_valide() == true){
                        pointsEnigme+=le.getE_points();
                    } //Sinon rien, on laisse à 0;
                }

                //pénalité par indice de l'énigme
                for(Indice li : le.getLesIndices()){
                    //penalité de chaque indice li
                    penalitesIndice+=li.getI_penalite();
                }

                pointsEnigmeEtPenalites=pointsEnigme+penalitesIndice;

                //si le score de (l'énigme + les pénalités) < 0
                if(pointsEnigmeEtPenalites<0) {
                    //il ne gagne ni ne perd rien pour l'énigme courante
                    pointsEnigmeEtPenalites=0; //on remet à 0 pour l'énigme et les pénalités
                }

            }//fin for lesEnigmes

            //pointsBonus (dans Objectif)
            pointsBonus += lo.getO_points_bonus();

        }//fin for lesObjectifs

        //penaliteIntervention = penalité si demande d'intervention
        //on utilise le hashmap entre DemandeIntervention & Enigme
        for (Map.Entry<Enigme, DemandeIntervention> ei : enigmeIntervention.entrySet()){
            if(ei.getValue().equals(true)){
                penaliteIntervention-=500;
            }
        }


        //on reprend les points énigme et pénalité indice (soit positif soit nul)
        //on y ajoute les points bonus de l'objectif et la pénalité si intervention
        scoreTotal+=pointsEnigmeEtPenalites+pointsBonus+penaliteIntervention;

        this.p_score=scoreTotal;
    }//fin méthode calculScore()

    public int getP_id() {
        return p_id;
    }

    public int getP_score() {
        return p_score;
    }

    public void setP_score(int p_score) {
        this.p_score = p_score;
    }

    public ArrayList<Objectif> getLesObjectifs() {
        return lesObjectifs;
    }

    public void setLesObjectifs(ArrayList<Objectif> lesObjectifs) {
        lesObjectifs = lesObjectifs;
    }

    public void ajoutDemandeIntervention(DemandeIntervention di, Enigme e){
        enigmeIntervention.put(e,di);
    }

    public void ajoutProposition(Proposition p, Enigme e){
        enigmeProposition.put(e,p);
    }

} //fin class Partie