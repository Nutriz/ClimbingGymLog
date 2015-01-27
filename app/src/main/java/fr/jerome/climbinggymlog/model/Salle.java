package fr.jerome.climbinggymlog.model;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by jerome on 25/01/15.
 */
public class Salle {

    private int id;
    private String nom;
    private String adresse;
    private String nomGerant;
    private Date dateAjout;
    private ArrayList<Client> clients;

    public Salle(int id, String nom, String adresse, String nomGerant) {

        this.id = id;
        this.nom = nom;
        this.adresse = adresse;
        this.nomGerant = nomGerant;
        this.dateAjout = new Date();
        this.clients = new ArrayList<Client>();
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {

        this.id = id;
    }

    public String getNom() {

        return nom;
    }

    public void setNom(String nom) {

        this.nom = nom;
    }

    public String getAdresse() {

        return adresse;
    }

    public void setAdresse(String adresse) {

        this.adresse = adresse;
    }

    public String getNomGerant() {

        return nomGerant;
    }

    public void setNomGerant(String nomGerant) {

        this.nomGerant = nomGerant;
    }

    public Date getDateAjout() {

        return dateAjout;
    }

    public void setDateAjout(Date dateAjout) {

        this.dateAjout = dateAjout;
    }

    public ArrayList<Client> getClients() {

        return clients;
    }

    public void setClients(ArrayList<Client> clients) {

        this.clients = clients;
    }

    @Override
    public String toString() {

        return  "_id" + id + "\n" +
                "nom : " + nom + "\n" +
                "adresse : " + adresse + "\n" +
                "nom gérant : " + nomGerant + "\n" +
                "date d'ajout : " + dateAjout+ "\n" +
                "nombre de client : " + clients.size();
    }
}