package fr.jerome.climbinggymlog.helpers;import android.content.Context;import android.graphics.Color;import java.sql.Date;import java.util.List;import fr.jerome.climbinggymlog.data.CotationDB;import fr.jerome.climbinggymlog.data.SeanceDB;import fr.jerome.climbinggymlog.data.StyleVoieDB;import fr.jerome.climbinggymlog.data.TypeEscDB;import fr.jerome.climbinggymlog.data.VoieDB;import fr.jerome.climbinggymlog.models.Client;import fr.jerome.climbinggymlog.models.Cotation;import fr.jerome.climbinggymlog.models.Seance;import fr.jerome.climbinggymlog.models.StyleVoie;import fr.jerome.climbinggymlog.models.TypeEsc;import fr.jerome.climbinggymlog.models.Voie;/** * Created by jerome on 30/01/15. */public class AppManager {    public static Client client;    public static final int salleId = 1;    public static String nomSalleClient;    public static List<Cotation> cotations;    public static List<TypeEsc> typesEsc;    public static List<StyleVoie> styleVoies;    public static long sysTime = System.currentTimeMillis();    public static int lastSeanceId;    public static boolean showLoginActivity;    public static void init(Context context) {        AppManager.setCotations(new CotationDB(context).getAllCotations());        AppManager.setTypeEsc(new TypeEscDB(context).getAllTypes());        AppManager.setStyleVoie(new StyleVoieDB(context).getAllStyles());        AppManager.updateLastSeanceId(context);//        AppManager.generateSomeValues(context);    }    /**     * Méthode de test permetant de génrérer 15 séances avec 10 voies dans chaque     * avec une cotation progressive     * @param context     */    private static void generateSomeValues(Context context) {        SeanceDB seanceDB = new SeanceDB(context);        VoieDB voieDB = new VoieDB(context);        int idVoie = 0;        for (int i = 1; i < 15; i++) {            Seance seance = new Seance(i, "Séance "+i, new Date(sysTime), new Date(sysTime), nomSalleClient, "note", client);            seanceDB.insert(seance);            switch (i) {                case 1 :                case 2 :                case 3 : {                    for (int j = 0; j < 8; j++) {                        idVoie++;                        Voie voie = new Voie(idVoie, AppManager.cotations.get(20).getNom(), AppManager.cotations.get(20), AppManager.typesEsc.get(1), AppManager.styleVoies.get(1), true, true, "", seance.getId());                        voieDB.insert(voie);                    }                }break;                case 4 :                case 5 :                case 6 : {                    for (int j = 0; j < 8; j++) {                        idVoie++;                        Voie voie = new Voie(idVoie, AppManager.cotations.get(22).getNom(), AppManager.cotations.get(22), AppManager.typesEsc.get(1), AppManager.styleVoies.get(1), true, true, "", seance.getId());                        voieDB.insert(voie);                    }                }break;                case 7 :                case 8 :                case 9 : {                    for (int j = 0; j < 8; j++) {                        idVoie++;                        Voie voie = new Voie(idVoie, AppManager.cotations.get(24).getNom(), AppManager.cotations.get(24), AppManager.typesEsc.get(1), AppManager.styleVoies.get(1), true, true, "", seance.getId());                        voieDB.insert(voie);                    }                }break;                case 10 :                case 11 :                case 12 : {                    for (int j = 0; j < 8; j++) {                        idVoie++;                        Voie voie = new Voie(idVoie, AppManager.cotations.get(26).getNom(), AppManager.cotations.get(26), AppManager.typesEsc.get(1), AppManager.styleVoies.get(1), true, true, "", seance.getId());                        voieDB.insert(voie);                    }                }break;                case 13 :                case 14 :                case 15 : {                    for (int j = 0; j < 8; j++) {                        idVoie++;                        Voie voie = new Voie(idVoie, AppManager.cotations.get(28).getNom(), AppManager.cotations.get(28), AppManager.typesEsc.get(1), AppManager.styleVoies.get(1), true, true, "", seance.getId());                        voieDB.insert(voie);                    }                }break;            }        }    }    public static void setCotations(List<Cotation> cotations) {        // Set couleur de la cotation        for (Cotation c : cotations) {            // Set couleur suivant chiffre            switch (c.getNumDiff()) {                case 3 : c.setCouleur(Color.argb(255, 50, 155, 0)); break;                case 4 : c.setCouleur(Color.argb(255, 50, 155, 0)); break;                case 5 : c.setCouleur(Color.argb(255, 8, 85, 184)); break;                case 6 : c.setCouleur(Color.argb(255, 255, 208, 0)); break;                case 7 : c.setCouleur(Color.argb(255, 207, 16, 0)); break;                case 8 : c.setCouleur(Color.argb(255, 86, 0, 148)); break;                case 9 : c.setCouleur(Color.argb(255, 0, 0, 0)); break;            }            int colorTmp = c.getCouleur();            int colorAlphaA = Color.argb(60, Color.red(colorTmp), Color.green(colorTmp), Color.blue(colorTmp));            int colorAlphaB = Color.argb(145, Color.red(colorTmp), Color.green(colorTmp), Color.blue(colorTmp));            // Set alpha suivant lettre            switch (c.getCharDiff()) {                case "a" : c.setCouleur(colorAlphaA); break;                case "b" : c.setCouleur(colorAlphaB); break;            }        }        AppManager.cotations = cotations;    }    public static void updateLastSeanceId(Context context) {        SeanceDB seanceDB = new SeanceDB(context);        lastSeanceId = seanceDB.getLastSeanceId();        seanceDB.close();    }    public static void setTypeEsc(List<TypeEsc> typesEsc) {        AppManager.typesEsc = typesEsc;    }    public static void setStyleVoie(List<StyleVoie> styleVoies) {        AppManager.styleVoies = styleVoies;    }    public static void setClient(Client client) {        AppManager.client = client;        setNomSalleClient();    }    private static void setNomSalleClient() {        // FIXME stocker le nom de la salle        nomSalleClient = "Roc en stock";    }}