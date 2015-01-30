package fr.jerome.climbinggymlog.database;

import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import fr.jerome.climbinggymlog.model.TypeEsc;

/**
 * Created by jerome on 28/01/15.
 */
public class TypeEscDB extends DBHandler {

    public static final String TABLE_NAME = "Type_esc";

    public static final String ID_TYPE_ESC = "_id";
    public static final String NOM_TYPE_ESC = "nom_type_esc";

    public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "(" +
            ID_TYPE_ESC + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            NOM_TYPE_ESC + " TEXT);";

    public static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME + ";";

    public TypeEscDB(Context context) {

        super(context);
    }

    /**
     * @return  types : Une liste contenant tous les type d'escalade
     */
    public List<TypeEsc> getAllTypes() {

        List<TypeEsc> types = new ArrayList<TypeEsc>();

        Cursor cur = database.query(TABLE_NAME,
                new String[]{ID_TYPE_ESC, NOM_TYPE_ESC},
                null, null, null, null, null);

        cur.moveToFirst();
        while (!cur.isAfterLast()) {
            TypeEsc typeEsc = new TypeEsc(cur.getLong(0), cur.getString(1));
            types.add(typeEsc);
            cur.moveToNext();
        }
        cur.close();
        return types;
    }
}
