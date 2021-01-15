package com.example.assisnment_mvvm_and_rxjava;

import com.example.assisnment_mvvm_and_rxjava.models.Article;
import com.example.assisnment_mvvm_and_rxjava.repository.MyRepository;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import io.reactivex.android.plugins.RxAndroidPlugins;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class RetrofitResponseTestCase {
	private MyRepository repository;

	@Before
	public void setup(){
		RxAndroidPlugins.setInitMainThreadSchedulerHandler(h -> Schedulers.trampoline());

		repository = new MyRepository();
	}

	@Test
	public void dataIsNotNull(){
		List<Article> articleList = null;

		repository.getNews("us").observeOn(AndroidSchedulers.mainThread())
				.subscribeOn(Schedulers.io())
				.subscribe(newsData ->{
					articleList.addAll(newsData.getArticles());
				});
	}
}
