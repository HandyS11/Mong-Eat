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
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

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

    @Path("/byName/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getByName(@PathParam("name") String name) {
        Article article = articleService.findByName(name);
        if (article != null) {
            return Response.ok(mapper.toDto(article)).build();
        }
        else {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Article with name " + name + " not found")
                    .build();
        }
    }
}
