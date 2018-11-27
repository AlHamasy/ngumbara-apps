package org.himti_umt.ngumbaraapps.network;


import org.himti_umt.ngumbaraapps.response.ResponseDataMuseum;


import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("kategori/museum/data_museum.php")
    Call<ResponseDataMuseum> museum();
}
