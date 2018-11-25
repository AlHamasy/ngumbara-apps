package org.himti_umt.ngumbaraapps.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ConfigRetrofit {

    public static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://himti-umt.org/data_ngumbara/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static ApiService service = retrofit.create(ApiService.class);

}
