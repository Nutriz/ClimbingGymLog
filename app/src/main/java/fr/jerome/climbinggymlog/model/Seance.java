package fr.jerome.climbinggymlog.model;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by jerome on 25/01/15.
 */
public class Seance {

    private long id = 0;
    private String nom;
    private Date dateSeance;
    private Date dateAjout;
    private String nomSalle;
    private String note;
    // FIXME Stocker directement le client en tant qu'objet
    private Client client;
    private ArrayList<Voie> voies;

    public Seance(long id, String nom, Date dateSeance, Date dateAjout, String nomSalle, String note, Client client) {

        this.id = id;
        this.nom = nom;
        this.dateSeance = dateSeance;
        this.dateAjout = dateAjout;
        this.nomSalle = nomSalle;
        this.note = note;
        this.client = client;
        this.voies = new ArrayList<Voie>();
    }

    public Seance(String nom, Date dateSeance, Date dateAjout, String nomSalle, String note, Client client) {

        this.nom = nom;
        this.dateSeance = dateSeance;
        this.dateAjout = dateAjout;
        this.nomSalle = nomSalle;
        this.note = note;
        this.client = client;
        this.voies = new ArrayList<Voie>();
    }

    public void addVoie(Voie newVoie) {

        voies.add(newVoie);
    }

    public long getId() {

        return id;
    }

    public void setId(long id) {

        this.id = id;
    }

    public String getNom() {

        return nom;
    }

    public void setNom(String nom) {

        this.nom = nom;
    }

    public Date getDateAjout() {

        return dateAjout;
    }

    public Date getDateSeance() {

        return dateSeance;
    }

    public void setDateSeance(Date dateSeance) {

        this.dateSeance = dateSeance;
    }

    public void setDateAjout(Date dateAjout) {

        this.dateAjout = dateAjout;
    }

    public String getNomSalle() {

        return nomSalle;
    }

    public void setNomSalle(String nomSalle) {

        this.nomSalle = nomSalle;
    }

    public String getNote() {

        return note;
    }

    public void setNote(String note) {

        this.note = note;
    }

    public Client getClient() {

        return client;
    }

    public void setClient(Client client) {

        this.client = client;
    }

    public ArrayList<Voie> getVoies() {

        return voies;
    }

    public void setVoies(ArrayList<Voie> voies) {

        this.voies = voies;
    }

    @Override
    public String toString() {

        return "Seance{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", dateSeance=" + dateSeance +
                ", dateAjout=" + dateAjout +
                ", nomSalle='" + nomSalle + '\'' +
                ", note='" + note + '\'' +
                ", client=" + client +
                ", voies=" + voies +
                '}';
    }
}
