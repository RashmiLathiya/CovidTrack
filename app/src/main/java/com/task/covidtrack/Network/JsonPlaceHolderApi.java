package com.task.covidtrack.Network;

import com.task.covidtrack.Model.State;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolderApi {

    @GET("raw_data.json")
    Call<State> getRawData();
//  https://api.covid19india.org/state_district_wise.json


    @GET("state_district_wise.json")
    Call<State> getDistrictData();

    @GET("summary")
    Call<State> getSummeryData();
//    https://api.covid19api.com/summary


}
