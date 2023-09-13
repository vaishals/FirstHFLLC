/**
 * 
 */
package com.test.fhf.service;

import org.springframework.cache.annotation.Cacheable;

import com.test.fhf.model.NewsResponseObject;

/**
 * @author vaishalshah
 *
 */
public interface NewsService {
	
	
	NewsResponseObject fetchArticles(int count);
	
	NewsResponseObject fetchByAuthor(String author);
	
	NewsResponseObject fetchByTitle(String title);
	
	NewsResponseObject fetchByKeyWord(String keyWord);
	
	

}
