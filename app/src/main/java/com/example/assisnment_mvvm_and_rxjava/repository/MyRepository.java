package com.example.assisnment_mvvm_and_rxjava.repository;

import com.example.assisnment_mvvm_and_rxjava.models.NewsData;
import com.example.assisnment_mvvm_and_rxjava.network.NewsApiClient;

import io.reactivex.Observable;

public class MyRepository {

	private final String NEWS_API_KEY = "6d0df12f66ef4483bad3908f781308b1";

	private static MyRepository myRepositoryInstance;
	public static MyRepository getInstance()
	{
		if(myRepositoryInstance == null)
			myRepositoryInstance = new MyRepository();

		return myRepositoryInstance;
	}

	public Observable<NewsData> getNews(String country){
		return NewsApiClient.getInstance().getApi().getHeadlines(country, NEWS_API_KEY);
	}
}
