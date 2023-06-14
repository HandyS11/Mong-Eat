package com.mongeat.services;

import com.mongeat.entities.ArticleEntity;
import com.mongeat.repositories.ArticleRepository;
import jakarta.annotation.PostConstruct;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@Singleton
public class ArticleService extends GenericService<ArticleEntity> {

    @Inject
    ArticleRepository articleRepository;

    @PostConstruct
    public void init() {
        setRepository(articleRepository);
    }
}
