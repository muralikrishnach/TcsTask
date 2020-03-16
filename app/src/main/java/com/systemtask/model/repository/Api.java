package com.systemtask.model.repository;

import com.systemtask.model.MoviesDataDo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

   /* String BASE_URL = "https://www.dropbox.com/s/82anw5663cv5ewt/";

    @GET("json.txt?d1=0")
    Call<List<MoviesDataDo>> getHeroes();*/


    String BASE_URL = "https://simplifiedcoding.net/demos/";

    @GET("marvel")
    Call<List<MoviesDataDo>> getHeroes();

}
