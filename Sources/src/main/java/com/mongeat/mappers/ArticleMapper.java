package com.mongeat.mappers;

import com.mongeat.dtos.ArticleDto;
import com.mongeat.models.Article;

public class ArticleMapper implements IMapper<Article, ArticleDto> {

    @Override
    public ArticleDto toDto(Article object) {
        ArticleDto articleDto = new ArticleDto();
        articleDto.setId(object.getId());
        articleDto.setName(object.getName());
        articleDto.setImage(object.getImage());
        articleDto.setPrice(object.getPrice());
        return articleDto;
    }

    @Override
    public Article toModel(ArticleDto object) {
        Article article = new Article();
        article.setId(object.getId());
        article.setName(object.getName());
        article.setImage(object.getImage());
        article.setPrice(object.getPrice());
        return article;
    }
}
