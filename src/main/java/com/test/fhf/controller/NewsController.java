package com.test.fhf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.fhf.model.NewsResponseObject;
import com.test.fhf.service.impl.NewsServiceImpl;

@RestController
@RequestMapping("/news")
public class NewsController {

	@Autowired
	NewsServiceImpl newsServiceImpl;

	@GetMapping("/getArticles")
	@ResponseBody
	public NewsResponseObject getArticles(@RequestParam(defaultValue = "10", required = false) Integer maxSize) {

		return newsServiceImpl.fetchArticles(maxSize);

	}

	@GetMapping("/getArticlesByAuthor")
	@ResponseBody
	public NewsResponseObject getArticlesByAuthor(@RequestParam String author) {

		return newsServiceImpl.fetchByAuthor(author);

	}

	@GetMapping("/getArticlesByTitle")
	@ResponseBody
	public NewsResponseObject getArticlesByTitle(@RequestParam String title) {

		return newsServiceImpl.fetchByTitle(title);

	}

	@GetMapping("/getArticlesByKeyWord")
	@ResponseBody
	public NewsResponseObject getArticlesByKeyWord(@RequestParam String keyWord) {

		return newsServiceImpl.fetchByKeyWord(keyWord);

	}

}
