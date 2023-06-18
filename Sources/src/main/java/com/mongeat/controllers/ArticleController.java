package com.mongeat.controllers;

import com.mongeat.dtos.ArticleDto;
import com.mongeat.dtos.add.NewArticleDto;
import com.mongeat.entities.ArticleEntity;
import com.mongeat.mappers.ArticleMapper;
import com.mongeat.mappers.add.NewArticleMapper;
import com.mongeat.models.Article;
import com.mongeat.models.add.NewArticle;
import com.mongeat.services.ArticleService;
import jakarta.annotation.PostConstruct;
import jakarta.inject.Inject;
import jakarta.ws.rs.Path;

@Path("/articles")
public class ArticleController extends GenericController<ArticleDto, NewArticleDto, Article, NewArticle, ArticleEntity> {

    @Inject
    ArticleService articleService;

    @PostConstruct
    public void init() {
        setService(articleService);
        setMapper(new ArticleMapper());
        setPostMapper(new NewArticleMapper());
    }
}
