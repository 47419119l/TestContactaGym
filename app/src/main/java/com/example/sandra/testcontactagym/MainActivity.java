package com.example.sandra.testcontactagym;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.client.Firebase;
import com.firebase.ui.FirebaseListAdapter;

public class MainActivity extends AppCompatActivity {
    private Firebase infoGymRef;
    private Firebase ref;
    private ListView listCentre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        /**
         * Contecem amb firebase.
         */
        Firebase.setAndroidContext(getBaseContext());
        ref = new Firebase("https://testgimmapp.firebaseio.com/");
        infoGymRef = ref.child("InfoGym");
        /**
         * Objectes layout.
         */

        listCentre = (ListView)findViewById(R.id.listCentre);



        FirebaseListAdapter adapter = new FirebaseListAdapter<InfoGym>(this, InfoGym.class, R.layout.list_localiza_centro, infoGymRef) {
            @Override
            protected void populateView(View v, InfoGym info, int position) {
                TextView nom = (TextView) v.findViewById(R.id.nomCentre);
                TextView direccio = (TextView) v.findViewById(R.id.ubicacioCentre);
                TextView email = (TextView) v.findViewById(R.id.emailCentre);
                TextView telefon = (TextView) v.findViewById(R.id.telfCentre);
                TextView semana = (TextView) v.findViewById(R.id.horariCentre);
                TextView horari2 = (TextView)v.findViewById(R.id.horari2);
                TextView horari3 = (TextView)v.findViewById(R.id.horari3);


                nom.setText(info.getNombreGym());
                direccio.setText(info.direccionGym);
                email.setText(info.getCorreoElectronicoGym());
                telefon.setText(String.valueOf(info.getTelefonoGym()));
                semana.setText("Lunes- viernes : " + info.getHorarioGym()[0]);
                horari2.setText("Sabados : " + info.getHorarioGym()[1]);
                horari3.setText("Domingos y festivos : " + info.getHorarioGym()[2]);

            }
        };
        listCentre.setAdapter(adapter);

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
