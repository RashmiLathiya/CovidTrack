package com.task.covidtrack.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;
import android.widget.Toast;

//import com.github.mikephil.charting.charts.PieChart;
import com.task.covidtrack.Model.Country;
import com.task.covidtrack.Model.State;
import com.task.covidtrack.R;
import com.task.covidtrack.Adapter.RawDataAdapter;
import com.task.covidtrack.Network.JsonPlaceHolderApi;

import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.PieModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import static com.task.covidtrack.Activity.MainActivity.JSON_URL;

public class CountryActivity extends AppCompatActivity {

    PieChart pieChart;
    RecyclerView mRecyclerView;
    RawDataAdapter rawDataAdapter;
    List<Country> Grouplist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country);
        getWindow().setFlags(1024,1024);
        mRecyclerView = findViewById(R.id.blogRecyclerView);
        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        pieChart=findViewById(R.id.piechart);
        Grouplist=new ArrayList<>();
        getGroupData();
    }

    // menu items
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.ascending:
                Collections.sort(Grouplist,Country.ascending);
                rawDataAdapter.notifyDataSetChanged();
                return true;
            case R.id.descending:
                Collections.sort(Grouplist,Country.dscending);
                rawDataAdapter.notifyDataSetChanged();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.searchview, menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
//                String newList=newText.toLowerCase();
//                List<Country> countries=new ArrayList<>();
//                for(String name:)


                rawDataAdapter.getFilter().filter(newText);
                return false;
            }
        });
        return true;
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
               //     Toast.makeText(CountryActivity.this, "success" + response.code(), Toast.LENGTH_SHORT).show();
                    Log.d("success",response.body().toString());

                    int act=response.body().getGlobal().getTotalConfirmed();
                    int rec=response.body().getGlobal().getTotalRecovered();
                    int dea=response.body().getGlobal().getTotalDeaths();

                   /* ArrayList<PieEntry> cases=new ArrayList<>();
                    cases.add(new PieEntry(act,"Confirm"));
                    cases.add(new PieEntry(rec,"Recover"));
                    cases.add(new PieEntry(dea,"Deaths"));
                    PieDataSet pieDataSet=new PieDataSet(cases,"Cases");
                    pieDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
                    pieDataSet.setValueTextColor(Color.BLACK);
                    pieDataSet.setValueTextSize(16f);
                    PieData pieData=new PieData(pieDataSet);
                    pieChart.setData(pieData);
                    pieChart.getDescription().setEnabled(false);
                    pieChart.setCenterText("Cases");
                    pieChart.animate();*/
                    // pie chart or global data
                    pieChart.addPieSlice(new PieModel("Confirmed",act, Color.parseColor("#4E3C76")));
                    pieChart.addPieSlice(new PieModel("Recovered",rec, Color.parseColor("#6B6BEB")));
                    pieChart.addPieSlice(new PieModel("Deaths",dea, Color.parseColor("#FE538B")));
                    pieChart.startAnimation();
                    Grouplist=response.body().getCountries();
                    prepareRecyclerView(Grouplist);
                } else {
                    Toast.makeText(CountryActivity.this, "error" + response.code(), Toast.LENGTH_SHORT).show();
                    Log.d("error", "onFail" + response);
                }
            }
            @Override
            public void onFailure(Call<State> call, Throwable t) {
                Toast.makeText(CountryActivity.this, "Fail" + t, Toast.LENGTH_LONG).show();
            }
        });

    }
    private void prepareRecyclerView(List<Country> rawList) {

        rawDataAdapter = new RawDataAdapter(rawList);
        if (this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        } else {
            mRecyclerView.setLayoutManager(new GridLayoutManager(this, 4));

        }
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(rawDataAdapter);
        rawDataAdapter.notifyDataSetChanged();

    }



}