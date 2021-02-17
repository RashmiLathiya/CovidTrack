package com.task.covidtrack.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.task.covidtrack.Model.Country;
import com.task.covidtrack.Model.State;
import com.task.covidtrack.MainViewModel;
import com.task.covidtrack.R;
import com.task.covidtrack.Adapter.RawDataAdapter;
import com.task.covidtrack.Network.JsonPlaceHolderApi;

import java.text.DecimalFormat;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class MainActivity extends AppCompatActivity {

    public static final String JSON_URL = "https://api.covid19api.com/";
    RawDataAdapter rawDataAdapter;
    TextView confirm,total_confirm,recover,death;
    ImageView img_all;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(1024,1024);
        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        confirm=findViewById(R.id.confirme);
        total_confirm=findViewById(R.id.active);
        recover=findViewById(R.id.recover);
        death=findViewById(R.id.death);
        img_all=findViewById(R.id.button_all);
        img_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,CountryActivity.class);
                startActivity(intent);
            }
        });
        getGroupData();

    }
    private void getGroupData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(JSON_URL)
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
        JsonPlaceHolderApi placeHolderAPI = retrofit.create(JsonPlaceHolderApi.class);
        Call<State> call = placeHolderAPI.getSummeryData();
        call.enqueue(new Callback<State>() {
            @Override
            public void onResponse(Call<State> call, Response<State> response) {
                if (response.isSuccessful()) {
                   // Toast.makeText(MainActivity.this, "success" + response.code(), Toast.LENGTH_SHORT).show();
                    Log.d("success",response.body().toString());
                    DecimalFormat formatter = new DecimalFormat("#,###,###");
                    Integer con=response.body().getGlobal().getNewConfirmed();
                    confirm.setText(formatter.format(con));
                    Integer act=response.body().getGlobal().getTotalConfirmed();
                    total_confirm.setText(formatter.format(act));
                    Integer rec=response.body().getGlobal().getTotalRecovered();
                    recover.setText(formatter.format(rec));
                    Integer dea=response.body().getGlobal().getTotalDeaths();
                    death.setText(formatter.format(dea));
//                    for(int i=0; i<Grouplist.size();i++){
//                        GroupData groupData=new GroupData();
//                        groupData.setId(Grouplist.get(i).getGroupId());
//                        groupData.setName(Grouplist.get(i).getGroupName());
//                        groupData.setMembers(Grouplist.get(i).getMembers());
//                        int j=Grouplist.get(i).getGroupId();
//                        String url="http://download.runtastic.com/meetandcode/mobile_and_web_2016/images/groups/"+j+".png";
//                        groupData.setImgUrl(url);
//                        adapter.addTask(groupData);
//                    }
                } else {
                    Toast.makeText(MainActivity.this, "error" + response.code(), Toast.LENGTH_SHORT).show();
                    Log.d("error", "onFail" + response);
                }
            }
            @Override
            public void onFailure(Call<State> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Fail" + t, Toast.LENGTH_LONG).show();
            }
        });

    }


}