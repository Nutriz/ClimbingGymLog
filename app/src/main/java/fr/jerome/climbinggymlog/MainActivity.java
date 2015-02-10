package fr.jerome.climbinggymlog;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

import java.sql.Date;
import java.util.ArrayList;

import fr.jerome.climbinggymlog.database.ClientDB;
import fr.jerome.climbinggymlog.database.CotationDB;
import fr.jerome.climbinggymlog.database.SeanceDB;
import fr.jerome.climbinggymlog.database.StyleVoieDB;
import fr.jerome.climbinggymlog.database.TypeEscDB;
import fr.jerome.climbinggymlog.database.VoieDB;
import fr.jerome.climbinggymlog.model.Client;
import fr.jerome.climbinggymlog.model.Seance;
import fr.jerome.climbinggymlog.model.Voie;
import fr.jerome.climbinggymlog.view.MyPagerAdapter;
import fr.jerome.climbinggymlog.view.fragments.EvenementsFragment;
import fr.jerome.climbinggymlog.view.fragments.ResumeFragment;
import fr.jerome.climbinggymlog.view.googletools.SlidingTabLayout;
import fr.jerome.climbinggymlog.view.fragments.SeancesFragment;
import fr.jerome.climbinggymlog.view.fragments.StatistiquesFragment;


public class MainActivity extends ActionBarActivity {

    private SlidingTabLayout slidingTabLayout;
    private ViewPager viewPager;
    private ArrayList<Fragment> fragments;
    private MyPagerAdapter myPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        long sysTime = System.currentTimeMillis();

        /**  AppManager pour les objets statiques  */
        AppManager.setClient(new Client("GULLY", "Jérome", 20484851, new Date(sysTime), 0));
        AppManager.setCotations(new CotationDB(this).getAllCotations());
        AppManager.setTypeEsc(new TypeEscDB(this).getAllTypes());
        AppManager.setStyleVoie(new StyleVoieDB(this).getAllStyles());

        slidingTabLayout = (SlidingTabLayout) findViewById(R.id.tab);
        viewPager = (ViewPager) findViewById(R.id.viewpager);

        // create a fragment list in order.
        fragments = new ArrayList<Fragment>();
        fragments.add(new ResumeFragment());
        fragments.add(new SeancesFragment());
        fragments.add(new StatistiquesFragment());
        fragments.add(new EvenementsFragment());

        // use FragmentPagerAdapter to bind the slidingTabLayout (tabs with different titles)
        // and ViewPager (different pages of fragment) together.
        myPagerAdapter = new MyPagerAdapter(getSupportFragmentManager(),  fragments);
        viewPager.setAdapter(myPagerAdapter);
        slidingTabLayout.setViewPager(viewPager);

        /**  DBHandlers pour manipuler la DB  */
        ClientDB clientDB = new ClientDB(this);
        SeanceDB seanceDB = new SeanceDB(this);
        VoieDB voieDB = new VoieDB(this);

        Client client = AppManager.client;

        Seance seance = new Seance("Séance #01", new Date(sysTime), new Date(sysTime), "Roc en stock", "séance plutot bonne", client);
        Seance seance2 = new Seance("Séance #02", new Date(sysTime), new Date(sysTime), "Roc en stock", "séance plutot mauvaise", client);
        Seance seance3 = new Seance("Séance #03", new Date(sysTime), new Date(sysTime), "Roc en stock", "séance plutot moyenne", client);

        clientDB.insert(client);
        seanceDB.insert(seance);
        seanceDB.insert(seance2);
        seanceDB.insert(seance3);

        Voie voie = voieDB.insert(new Voie(seance2.getId(), "5c #02", AppManager.cotations.get(10), "Moulinette", "Dalle", true, true, "voie cool", null));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
