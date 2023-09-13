/**
 * 
 */
package com.test.fhf.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.test.fhf.model.NewsResponseObject;
import com.test.fhf.service.NewsService;

/**
 * @author vaishalshah
 *
 */

@Service
@CacheConfig(cacheNames = { "articles" })
public class NewsServiceImpl implements NewsService {

	@Autowired
	WebClient webClient;

	@Autowired
	CacheManager cacheManager;

	@Value("${API_KEY}")
	String apiKey;

	private static final String TOPHEADLINES = "/top-headlines";
	private static final String SEARCH = "/search";
	
	
	
	private static final String CATEGORY_GENERAL = "general";
	private static final String CATEGORY = "category";
	private static final String LANG_EN = "en";
	private static final String LANG = "lang";
	private static final String API_KEY = "apikey";
	private static final String MAX_PARAM = "max";
	private static final String Q = "q";
	private static final String IN = "in";

	@Override
	public NewsResponseObject fetchArticles(int count) {
		NewsResponseObject respObject = webClient.get()
												.uri(uriBuilder -> uriBuilder
																.path(TOPHEADLINES)
																.queryParam(CATEGORY, CATEGORY_GENERAL)
																.queryParam(LANG, LANG_EN)
																.queryParam(MAX_PARAM, count)
																.queryParam(API_KEY, apiKey)
																.build())
												.retrieve()
												.bodyToMono(NewsResponseObject.class)
												.block();

		return respObject;
	}

	@Override
	@Cacheable(key = "#author")
	public NewsResponseObject fetchByAuthor(String author) {
		NewsResponseObject respObject = webClient.get()
												.uri(uriBuilder -> uriBuilder
														.path(SEARCH)
														.queryParam(Q, author)
														.queryParam(LANG, LANG_EN)
														.queryParam(IN, "author")
														.queryParam(API_KEY, apiKey)
														.build())
												.retrieve()
												.bodyToMono(NewsResponseObject.class)
												.block();

		return respObject;
	}

	@Override
	@Cacheable(key = "#title")
	public NewsResponseObject fetchByTitle(String title) {
		NewsResponseObject respObject = webClient.get()
												.uri(uriBuilder -> uriBuilder
														.path(SEARCH)
														.queryParam(Q, title)
														.queryParam(LANG, LANG_EN)
														.queryParam(IN, "title")
														.queryParam(API_KEY, apiKey)
														.build())
												.retrieve()
												.bodyToMono(NewsResponseObject.class)
												.block();

		return respObject;
	}

	@Override
	@Cacheable(key = "#keyWord")
	public NewsResponseObject fetchByKeyWord(String keyWord) {
		NewsResponseObject respObject = webClient.get()
												.uri(uriBuilder -> uriBuilder
														.path(SEARCH)
														.queryParam(Q, keyWord)
														.queryParam(LANG, LANG_EN)
														.queryParam(IN, "content")
														.queryParam(API_KEY, apiKey)
														.build())
												.retrieve()
												.bodyToMono(NewsResponseObject.class)
												.block();

		return respObject;
	}
}
