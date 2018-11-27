package org.himti_umt.ngumbaraapps.fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import org.himti_umt.ngumbaraapps.R;
import org.himti_umt.ngumbaraapps.adapter.MuseumAdapter;
import org.himti_umt.ngumbaraapps.network.ApiService;
import org.himti_umt.ngumbaraapps.network.ConfigRetrofit;
import org.himti_umt.ngumbaraapps.response.DataMuseumItem;
import org.himti_umt.ngumbaraapps.response.ResponseDataMuseum;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class DestinasiFragment extends Fragment {

    private RecyclerView recyclerView;

    public DestinasiFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_destinasi, container, false);

        recyclerView = view.findViewById(R.id.recycler_destinasi_museum);

        ApiService  apiService = ConfigRetrofit.retrofit.create(ApiService.class);
        Call<ResponseDataMuseum> call = apiService.museum();
        call.enqueue(new Callback<ResponseDataMuseum>() {
            @Override
            public void onResponse(Call<ResponseDataMuseum> call, Response<ResponseDataMuseum> response) {
                Boolean status = response.body().isStatus();

                if(status==true){
                    List<DataMuseumItem> dataMuseum = response.body().getDataMuseum();
                    MuseumAdapter adapter = new MuseumAdapter(getContext(), dataMuseum);
                    recyclerView.setAdapter(adapter);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                }else {
                    Toast.makeText(getContext(), "DATA TIDAK ADA", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseDataMuseum> call, Throwable t) {
                Toast.makeText(getContext(), "Periksa Jaringan Anda", Toast.LENGTH_SHORT).show();
                Log.d("Status", t.getMessage().toString());
            }
        });

        return view;
    }


}
