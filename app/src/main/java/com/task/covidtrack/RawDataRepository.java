package com.task.covidtrack;

import android.app.Application;

import androidx.lifecycle.MutableLiveData;

import com.task.Pojo.Example;
import com.task.Pojo.RawDatum;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RawDataRepository {

    private Application application;
    private ArrayList<RawDatum> Data=new ArrayList<>();
    private MutableLiveData<List<RawDatum>> mutableLiveData=new MutableLiveData<>();

    public RawDataRepository(Application  application) {
        this.application=application;
    }
//
//    public MutableLiveData<List<RawDatum>> getMutableLiveData() {
//
//        RestApiService apiService = RetrofitInstance.getApiService();
//        Call<Example> call = apiService.getRawData();
//        call.enqueue(new Callback<Example>() {
//            @Override
//            public void onResponse(Call<Example> call, Response<Example> response) {
//                Example mBlogWrapper = response.body();
//                if (mBlogWrapper != null && mBlogWrapper.getRawData() != null) {
//                    Data = (ArrayList<RawDatum>) mBlogWrapper.getRawData();
//                    mutableLiveData.setValue(Data);
//                }
//            }
//
//            @Override
//            public void onFailure(Call<Example> call, Throwable t) { }
//        });
//        return mutableLiveData;
//    }
}
