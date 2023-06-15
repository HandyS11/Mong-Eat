package com.mongeat.services;

import com.mongeat.converters.ArticleConverter;
import com.mongeat.entities.ArticleEntity;
import com.mongeat.models.Article;
import com.mongeat.repositories.ArticleRepository;
import jakarta.annotation.PostConstruct;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@Singleton
public class ArticleService extends GenericService<Article, ArticleEntity> {
    @Inject
    ArticleRepository articleRepository;

    @PostConstruct
    public void init() {
        setRepository(articleRepository);
        setConverter(new ArticleConverter());
    }
}
