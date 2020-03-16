package com.systemtask.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.systemtask.model.MoviesDataDo;
import com.systemtask.model.repository.Api;
import com.systemtask.model.repository.RetrofitClient;

import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainViewModel extends ViewModel {

    MutableLiveData<List<MoviesDataDo>> heroList;

    public LiveData<List<MoviesDataDo>> getHeroes() {

        if (heroList == null) {
            heroList = new MutableLiveData<List<MoviesDataDo>>();

            loadHeroes();
        }

        return heroList;
    }


    private void loadHeroes() {

        Api retrofitClient =  RetrofitClient.getClient().create(Api.class);

        Call<List<MoviesDataDo>> call = retrofitClient.getHeroes();

        call.enqueue(new Callback<List<MoviesDataDo>>() {
            @Override
            public void onResponse(Call<List<MoviesDataDo>> call, Response<List<MoviesDataDo>> response) {

                heroList.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<MoviesDataDo>> call, Throwable t) {

            }
        });
    }

}
