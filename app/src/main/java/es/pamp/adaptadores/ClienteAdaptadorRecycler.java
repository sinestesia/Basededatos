package es.pamp.adaptadores;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import es.pamp.basededatos.R;
import es.pamp.modelo.Cliente;

/**
 * Created by cice on 28/3/17.
 */

public class ClienteAdaptadorRecycler extends RecyclerView.Adapter<ClienteAdaptadorRecycler.ClienteViewHolder> implements View.OnClickListener{

    private Context contexto;
    private List<Cliente> data;
    private View.OnClickListener listener;

    public ClienteAdaptadorRecycler(Context contexto, List<Cliente> data) {
        this.contexto = contexto;
        this.data = data;
    }

    public static class ClienteViewHolder extends RecyclerView.ViewHolder{

        TextView clienteNombre;
        TextView  clienteTelefono;

        public ClienteViewHolder(View itemView) {
            super(itemView);
            clienteNombre =(TextView) itemView.findViewById(R.id.nombre);
            clienteTelefono =(TextView) itemView.findViewById(R.id.telefono);
        }
    }


    @Override
    public ClienteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(contexto).inflate(R.layout.cliente, parent, false);
        v.setOnClickListener(this);
        return new ClienteViewHolder(v);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public void onBindViewHolder(ClienteViewHolder holder, int position) {
        holder.clienteNombre.setText(data.get(position).getNombre());
        holder.clienteTelefono.setText(data.get(position).getTelefono());
    }

    public void setListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onClick(View v) {
        if(listener!=null) {
            listener.onClick(v);
        }
    }
}