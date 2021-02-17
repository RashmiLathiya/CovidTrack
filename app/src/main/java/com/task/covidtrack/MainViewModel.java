package com.task.covidtrack;

import android.app.Application;
import android.app.ListActivity;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.task.Pojo.RawDatum;

import java.util.List;

public class MainViewModel extends AndroidViewModel {
    private RawDataRepository rawDataRepository;

    public MainViewModel(@NonNull Application application) {
        super(application);
        rawDataRepository = new RawDataRepository(application);
    }

//    public LiveData<List<RawDatum>> getAllBlog() {
//       // return rawDataRepository.getMutableLiveData();
//    }
}
