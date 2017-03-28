package es.pamp.basededatos;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import es.pamp.adaptadores.ClienteAdaptadorRecycler;
import es.pamp.bbdd.BBDD;
import es.pamp.modelo.Cliente;

public class RecyclerViewActivity extends AppCompatActivity {
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView mRecyclerView;
    List<Cliente> data;
    private  BBDD bbdd;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        bbdd = new BBDD(this, "DBCLIENTES", null, 1 );
        db = bbdd.getReadableDatabase();
        data = bbdd.getData(db);


        ClienteAdaptadorRecycler adaptador = new ClienteAdaptadorRecycler(this, data);
        final RecyclerView clienteRV = (RecyclerView) findViewById(R.id.rvCliente);


        adaptador.setListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(RecyclerViewActivity.this, "Has seleccionado: " + clienteRV.getChildAdapterPosition(v) + " Nombre: " + data.get(clienteRV.getChildAdapterPosition(v)).getNombre(), Toast.LENGTH_SHORT).show();
            }
        });

        clienteRV.setAdapter(adaptador);
        clienteRV.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));

    }


}
