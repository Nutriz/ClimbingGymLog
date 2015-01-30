package fr.jerome.climbinggymlog.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import fr.jerome.climbinggymlog.model.Client;
import fr.jerome.climbinggymlog.model.Seance;

/**
 * Created by jerome on 28/01/15.
 */
public class SeanceDB extends DBHandler {

    public static final String TABLE_NAME = "Seance";

    public static final String ID_SEANCE = "_id";
    public static final String NOM_SEANCE = "nom_seance";
    public static final String DATE_SEANCE = "date_seance";
    public static final String DATE_AJ_SEANCE = "date_aj_seance";
    public static final String NOM_SALLE_SEANCE = "nom_salle_seance";
    public static final String NOTE_SEANCE = "note_seance";
    public static final String USER_SEANCE = "user_seance";

    public static final String   CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "(" +
                                 ID_SEANCE + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                 NOM_SEANCE + " TEXT, " +
                                 DATE_SEANCE + " DATE, " +
                                 DATE_AJ_SEANCE + " DATE, " +
                                 NOM_SALLE_SEANCE + " TEXT, " +
                                 NOTE_SEANCE + " TEXT, " +
                                 USER_SEANCE + " INTEGER);";

    public static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME + ";";

    public SeanceDB(Context context) {

        super(context);
    }

    /**
     * @param seance la séance à inserer dans la table
     */
    public void insert(Seance seance) {

        ContentValues value = new ContentValues();

        value.put(NOM_SEANCE, seance.getNom());
        value.put(DATE_SEANCE, seance.getDateSeance().toString());
        value.put(DATE_AJ_SEANCE, seance.getDateAjout().toString());
        value.put(NOM_SALLE_SEANCE, seance.getNomSalle());
        value.put(NOTE_SEANCE, seance.getNote());
        value.put(USER_SEANCE, seance.getIdClient());

        database.insert(TABLE_NAME, null, value);

        Log.d("SQL", "Ajout de la séance " + seance.getNom() + " id : " + seance.getId() + " à la table Seance");
    }

    /**
     * @param id l'identifiant de la séance à récupérer
     */
    public Cursor select(long id) {

//        Cursor c = database.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE _id=?", new String[]{String.valueOf(id)});
        Cursor c = database.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE _id=" + id, null);
        return c;
    }

    /**
     * @param seance la séance modifié
     */
    public void update(Seance seance) {

    }

    /**
     * @param seance séance à supprimer
     */
    public void delete(Seance seance) {

        int id = seance.getId();
        database.delete(TABLE_NAME, ID_SEANCE  + " = " + id, null);

        Log.d("SQLite", "Suppression de la séance : " + seance.getNom() + "avec l'id : " +seance.getId() + " de la table Seance");
    }
}
