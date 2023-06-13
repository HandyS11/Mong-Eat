package com.mongeat.controllers;

import com.mongeat.entities.Article;
import com.mongeat.services.ArticleService;
import jakarta.annotation.PostConstruct;
import jakarta.inject.Inject;
import jakarta.ws.rs.Path;

@Path("/articles")
public class ArticleController extends GenericController<Article> {

    @Inject
    ArticleService articleService;

    @PostConstruct
    public void init() {
        setService(articleService);
    }
}
