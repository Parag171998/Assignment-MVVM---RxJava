package com.example.assisnment_mvvm_and_rxjava.network;
import com.example.assisnment_mvvm_and_rxjava.models.NewsData;

import org.reactivestreams.Publisher;

import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("top-headlines")
    Observable<NewsData> getHeadlines(
            @Query("country") String country,
            @Query("apiKey") String apiKey
    );
}
