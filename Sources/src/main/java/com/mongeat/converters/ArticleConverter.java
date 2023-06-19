package com.mongeat.converters;

import com.mongeat.entities.ArticleEntity;
import com.mongeat.models.Article;

public class ArticleConverter implements IConverter<Article, ArticleEntity> {

    @Override
    public ArticleEntity toEntity(Article object) {
        if (object == null) {
            return null;
        }
        ArticleEntity articleEntity = new ArticleEntity();
        articleEntity.setId(object.getId());
        articleEntity.setName(object.getName());
        articleEntity.setImage(object.getImage());
        articleEntity.setPrice(object.getPrice());
        return articleEntity;
    }

    @Override
    public Article toModel(ArticleEntity object) {
        if (object == null) {
            return null;
        }
        Article article = new Article();
        article.setId(object.getId());
        article.setName(object.getName());
        article.setImage(object.getImage());
        article.setPrice(object.getPrice());
        return article;
    }
}
