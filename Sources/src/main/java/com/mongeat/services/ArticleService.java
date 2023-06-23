package com.mongeat.services;

import com.mongeat.converters.ArticleConverter;
import com.mongeat.converters.add.NewArticleConverter;
import com.mongeat.entities.ArticleEntity;
import com.mongeat.models.Article;
import com.mongeat.models.add.NewArticle;
import com.mongeat.repositories.ArticleRepository;
import jakarta.annotation.PostConstruct;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.util.List;
import java.util.stream.Collectors;

@Singleton
public class ArticleService extends GenericService<Article, NewArticle, ArticleEntity> {
    @Inject
    ArticleRepository articleRepository;

    @PostConstruct
    public void init() {
        setRepository(articleRepository);
        setConverter(new ArticleConverter());
        setAddConverter(new NewArticleConverter());
    }

    public List<Article> findByName(String name) {
        return articleRepository.findByName(name).stream().map(a -> converter.toModel(a)).collect(Collectors.toList());
    }
}
