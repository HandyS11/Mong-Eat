package com.mongeat.controllers;

import com.mongeat.dtos.ArticleDto;
import com.mongeat.entities.ArticleEntity;
import com.mongeat.mappers.ArticleMapper;
import com.mongeat.models.Article;
import com.mongeat.services.ArticleService;
import jakarta.annotation.PostConstruct;
import jakarta.inject.Inject;
import jakarta.ws.rs.Path;

@Path("/articles")
public class ArticleController extends GenericController<ArticleDto, Article, ArticleEntity> {

    @Inject
    ArticleService articleService;

    @PostConstruct
    public void init() {
        setService(articleService);
        setMapper(new ArticleMapper());
    }
}
