/**
 * 
 */
package com.test.fhf.model;

import java.util.List;

/**
 * @author vaishalshah
 *
 */
public class NewsResponseObject {

	private int totalArticles;
	private List<Article> articles;

	public int getTotalArticles() {
		return totalArticles;
	}

	public void setTotalArticles(int totalArticles) {
		this.totalArticles = totalArticles;
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

}
