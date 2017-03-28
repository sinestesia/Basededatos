package es.pamp.basededatos;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import es.pamp.bbdd.BBDD;

import static es.pamp.basededatos.R.id.salirBoton;

public class MainActivity extends AppCompatActivity {


    private  BBDD bbdd;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bbdd = new BBDD(this, "DBCLIENTES", null, 1 );
        db = bbdd.getReadableDatabase();

        if (db==null){
            Toast toast = Toast.makeText(getApplicationContext(), "ERROR BD", Toast.LENGTH_SHORT);
            toast.show();
        }

        Button salirBoton = (Button) findViewById(R.id.salirBoton);
        salirBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.this.finish();
            }
        });
        Button entrarBoton = (Button) findViewById(R.id.entrarBoton);
        entrarBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usuario = ((EditText) findViewById(R.id.usuarioText)).getText().toString();
                String pass = ((EditText) findViewById(R.id.passText)).getText().toString();

                if (bbdd.userpass(db,usuario,pass)){
                    bbdd.close();
                    Intent i = new Intent(MainActivity.this,RecyclerViewActivity.class);
                    startActivity(i);
                }else{
                    Toast toast = Toast.makeText(getApplicationContext(), "USUARIO O CONTRASEÑA INCORRECTA", Toast.LENGTH_SHORT);
                    toast.show();
                }


            }
        });



    }
}
