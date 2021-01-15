package com.example.assisnment_mvvm_and_rxjava.viewModel;

import androidx.lifecycle.ViewModel;

import com.example.assisnment_mvvm_and_rxjava.models.NewsData;
import com.example.assisnment_mvvm_and_rxjava.repository.MyRepository;

import io.reactivex.Observable;

public class MainViewModel extends ViewModel {

	private MyRepository myRepository;

	public Observable<NewsData> getHeadlines(String country)
	{
		if (myRepository == null) {
			myRepository = MyRepository.getInstance();
		}
		return myRepository.getNews(country);
	}

}
