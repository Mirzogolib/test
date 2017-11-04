package inducesmile.com.safar.Interface;

import inducesmile.com.safar.Models.Table;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface TestInterface {
    @GET("api/Main/GetTablesList")
    Call<Table> getUser(@Query("lang") String lang, @Query("typeId") int id);

}
