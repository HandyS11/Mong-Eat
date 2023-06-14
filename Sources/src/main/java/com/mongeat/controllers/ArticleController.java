package com.mongeat.controllers;

import com.mongeat.dtos.ArticleDto;
import com.mongeat.entities.ArticleEntity;
import com.mongeat.services.ArticleService;
import jakarta.annotation.PostConstruct;
import jakarta.inject.Inject;
import jakarta.ws.rs.Path;

@Path("/articles")
public class ArticleController extends GenericController<ArticleEntity, ArticleDto> {

    @Inject
    ArticleService articleService;

    public ArticleController() {
        super(ArticleDto.class);
    }

    @PostConstruct
    public void init() {
        setService(articleService);
    }
}
