package com.example.assisnment_mvvm_and_rxjava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.example.assisnment_mvvm_and_rxjava.models.NewsData;
import com.example.assisnment_mvvm_and_rxjava.viewModel.MainViewModel;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

	private MainViewModel mainViewModel;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		initViewModel();
	}

	@SuppressLint("CheckResult")
	private void initViewModel() {
		mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);

		mainViewModel.getHeadlines("us").subscribeOn(Schedulers.io())
				.observeOn(AndroidSchedulers.mainThread())
				.subscribeWith(new Observer<NewsData>() {
					@Override
					public void onSubscribe(@NonNull Disposable d) {

					}

					@Override
					public void onNext(@NonNull NewsData newsData) {
						newsData.getArticles();
					}

					@Override
					public void onError(@NonNull Throwable e) {

					}

					@Override
					public void onComplete() {

					}
				});
	}
}