package inducesmile.com.safar.service;

import inducesmile.com.safar.Interface.TestInterface;
import inducesmile.com.safar.Models.Table;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


public class Service {
    static String BASE_URL = "http://safar.iutlab.uz/";
    private static Retrofit retrofit;

    public static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }

    public Call<Table> getUser(String lang, int id) {
        TestInterface apiInterface = getClient().create(TestInterface.class);
        return apiInterface.getUser(lang, id);
    }
}
