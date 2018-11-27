package org.himti_umt.ngumbaraapps.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.himti_umt.ngumbaraapps.R;
import org.himti_umt.ngumbaraapps.response.DataMuseumItem;

import java.util.List;

public class MuseumAdapter extends RecyclerView.Adapter<MuseumAdapter.MyHolder> {

    private Context con;
    private List<DataMuseumItem> dataMuseumItems;

    public MuseumAdapter(Context con, List<DataMuseumItem> dataMuseumItems){
        this.con = con;
        this.dataMuseumItems = dataMuseumItems;
    }

    @Override
    public MuseumAdapter.MyHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_museum, viewGroup, false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(MuseumAdapter.MyHolder holder, int position) {

        holder.txtNamaMuseum.setText(dataMuseumItems.get(position).getNamaMuseum());

    }

    @Override
    public int getItemCount() {
        return dataMuseumItems.size();
    }

    class MyHolder extends RecyclerView.ViewHolder{
        ImageView imgHeader;
        TextView txtNamaMuseum;


        MyHolder(View itemView) {
            super(itemView);

            imgHeader = itemView.findViewById(R.id.iv_list_museum);
            txtNamaMuseum = itemView.findViewById(R.id.tv_nama_museum);
        }
    }
}
