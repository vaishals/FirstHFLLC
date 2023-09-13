## Description

This project creates a REST API framework using Java and SpringBoot. It interacts with the GNews API to fetch new data.

## API

There are four different APIs that this project provides:
- Get top n articles (/getArticles) where n corresponds to an optional API parameter `maxSize` (defaults to 10).
- Get articles by author (/getArticlesByAuthor) where author can be specified by parameter `author`.
- Get articles by title (/getArticlesByTitle) where title can be specified by paramater `title`.
- Get articles by keyword (/getArticlesByKeyWord) where keycword can be specified by parameter `keyWord`.

## Caching

In order to reduce calls to the GNews API, this project implements caching with key matching the request paramater. E.g.
> In the API  `/getArticlesByAuthor` the key will be `author`. So once the result value is cached for a specific author, the value will always be returned from the cache instead of another call to the GNews API.

## Swagger

Once the application is running, you can access the detailed documentation using this URL http://localhost:8080/swagger-ui/index.html#/ (Replace the server and port info)

## Instructions to start
- Open the project in a compatible IDE.
- import as maven project
- run `maven clean install`
- Run the project. 
