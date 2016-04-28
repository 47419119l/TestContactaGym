package com.example.sandra.testcontactagym;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.firebase.client.Firebase;

public class MainActivity extends AppCompatActivity {
    Firebase clientRef;
    Firebase ref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        Firebase.setAndroidContext(getBaseContext());
        ref = new Firebase("https://testgimmapp.firebaseio.com/");
        clientRef = ref.child("InfoGym");


        InfoGym infoGym = new InfoGym();
        infoGym.setCorreoElectronicoGym("gim@example.com");
        infoGym.setNombreGym("Gimnasio de ejemplo");
        infoGym.setTelefonoGym(963852741);
        infoGym.setDireccionGym("C / Doctor Trueta n3");
        infoGym.setLatitudGym(41.3851);
        infoGym.setLongitudGym(2.1734);
        String []horari = new String[3];
        horari[0]="08.00 - 23.30";
        horari[1]="09.00 - 23.00";
        horari[2]="10.00 - 16.00";

        infoGym.setHorarioGym(horari);


        Firebase client = clientRef.push();
        client.setValue(infoGym);
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
