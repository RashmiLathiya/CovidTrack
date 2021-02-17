package com.task.covidtrack.ViewModel;
import android.util.Log;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.task.covidtrack.Model.State;
import com.task.covidtrack.Network.JsonPlaceHolderApi;
import com.task.covidtrack.Network.RetrofitInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListViewModel extends ViewModel {
    //live data observer
    private JsonPlaceHolderApi placeHolderAPI;
    private MutableLiveData<State> listMutableLiveData;

    public ListViewModel() {
        listMutableLiveData=new MutableLiveData<>();
    }

    public MutableLiveData<State> getListMutableLiveData(){
        return listMutableLiveData;
    }

    public void getStateData(){
        placeHolderAPI= RetrofitInstance.getRetrofit().create(JsonPlaceHolderApi.class);
        Call<State> call=placeHolderAPI.getSummeryData();
        call.enqueue(new Callback<State>() {
            @Override
            public void onResponse(Call<State> call, Response<State> response) {
                if (response.isSuccessful()) {
                    listMutableLiveData.postValue(response.body());
                } else {
                    Log.d("error", "onFail" + response);
                }            }

            @Override
            public void onFailure(Call<State> call, Throwable t) {
                listMutableLiveData.postValue(null);

            }
        });

    }
}
