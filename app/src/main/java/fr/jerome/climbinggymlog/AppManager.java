package fr.jerome.climbinggymlog;import android.content.Context;import java.sql.Date;import java.util.List;import fr.jerome.climbinggymlog.database.ClientDB;import fr.jerome.climbinggymlog.model.Client;import fr.jerome.climbinggymlog.model.Cotation;import fr.jerome.climbinggymlog.model.StyleVoie;import fr.jerome.climbinggymlog.model.TypeEsc;/** * Created by jerome on 30/01/15. */public class AppManager {    public static Client client;    public static List<Cotation> cotations;    public static List<TypeEsc> typesEsc;    public static List<StyleVoie> styleVoies;    public static void setCotations(List<Cotation> cotations) {        AppManager.cotations = cotations;    }    public static void setTypeEsc(List<TypeEsc> typesEsc) {        AppManager.typesEsc = typesEsc;    }    public static void setStyleVoie(List<StyleVoie> styleVoies) {        AppManager.styleVoies = styleVoies;    }    public static void setClient(Context context) {        ClientDB clientDB = new ClientDB(context);        Client client;        // Si aucun client dans la Table        if (clientDB.isTableEmpty()) {            long sysTime = System.currentTimeMillis();            client = new Client("GULLY", "Jérome", 27, "333333", new Date(sysTime), 0);            clientDB.insert(client);        }        else {            client = clientDB.select(1);        }        AppManager.client = client;    }}