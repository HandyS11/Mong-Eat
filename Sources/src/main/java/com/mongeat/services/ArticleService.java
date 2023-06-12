package com.mongeat.services;

import com.mongeat.entities.Article;
import com.mongeat.repositories.ArticleRepository;
import jakarta.annotation.PostConstruct;
import jakarta.inject.Inject;

public class ArticleService extends GenericService<Article> {

    @Inject
    ArticleRepository articleRepository;

    @PostConstruct
    public void init() {
        setRepository(articleRepository);
    }
}
