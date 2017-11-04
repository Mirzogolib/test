package inducesmile.com.safar.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import inducesmile.com.safar.Interface.MyOnClickListener;
import inducesmile.com.safar.Models.Table;
import inducesmile.com.safar.Models.TableElements;
import inducesmile.com.safar.R;
import inducesmile.com.safar.adapter.AdapterFragment;
import inducesmile.com.safar.service.Service;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SubActivity extends AppCompatActivity {

    Service service;
    AdapterFragment adapter;
    TextView text1, text2;
    RecyclerView listProductShop;
    MyOnClickListener mListener;
    String language, TAG;
    int id;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_adapter_check);
        text1 = (TextView)findViewById(R.id.product_name);
        listProductShop = (RecyclerView) findViewById(R.id.listTable);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        listProductShop.setLayoutManager(layoutManager);
        adapter = new AdapterFragment(getApplicationContext(), mListener);
        service = new Service();
        listProductShop.setAdapter(adapter);
        language = "Ru";
        id = 1;
        service.getUser(language, id).enqueue(new Callback<Table>() {
            @Override
            public void onResponse(Call<Table> call, Response<Table> response) {
                Log.d(TAG, "Succesful getting");
                for(TableElements tableElements : response.body().getResults()){
                    adapter.addNewItem(tableElements);
                }
//                SharedPreferences sharedPreferences = getSharedPreferences("mypref", MODE_PRIVATE);
//                SharedPreferences.Editor editor = sharedPreferences.edit();
//                editor.putString("blabla", response.body().getResults().get(0).getTableName());
//                editor.commit();
            }

            @Override
            public void onFailure(Call<Table> call, Throwable t) {
                Log.d(TAG, t.getMessage());
//                SharedPreferences data = getApplicationContext().getSharedPreferences("mypref", MODE_PRIVATE);
//                String usname= data.getString("blabla", "");
//                if(data == null){
//                    Toast.makeText(SubActivity.this, "Sorry you have to check internet connection", Toast.LENGTH_LONG);
//                }else {
//
//                }
            }
        });



    }
}
