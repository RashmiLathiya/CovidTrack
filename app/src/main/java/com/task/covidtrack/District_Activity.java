package com.task.covidtrack;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.task.Pojo.Example;
import com.task.Pojo.RawDatum;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class District_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_district);
       // getGroupData();
    }

//    private void getGroupData() {
//        RestApiService apiService = RetrofitInstance.getApiService();
//        Call<Example> call = apiService.getDistrictData();
//        call.enqueue(new Callback<Example>() {
//            @Override
//            public void onResponse(Call<Example> call, Response<Example> response) {
//                if (response.isSuccessful()) {
//                    Log.d("success",response.body().toString());
//                    List<RawDatum> Grouplist=response.body().getRawData();
//                    prepareRecyclerView(Grouplist);
//                } else {
//                    Toast.makeText(District_Activity.this, "error" + response.code(), Toast.LENGTH_SHORT).show();
//                    Log.d("error", "onFail" + response);
//                }
//            }
//            @Override
//            public void onFailure(Call<Example> call, Throwable t) {
//                Toast.makeText(District_Activity.this, "Fail" + t, Toast.LENGTH_SHORT).show();
//            }
//        });
//
//    }






}


