package com.task.covidtrack.Network;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class RetrofitInstance {

    public static final String BASE_URL = "https://api.covid19api.com/";

    private static Retrofit retrofit;
    public static Retrofit getRetrofit(){
        if (retrofit==null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(JacksonConverterFactory.create())
                    .build();

        }
        return retrofit;
    }
}


