package com.mongeat.mappers;

import com.mongeat.dtos.ArticleDto;
import com.mongeat.models.Article;

public class ArticleMapper {

    public static Article mapToArticle(ArticleDto articleDto) {
        Article article = new Article();
        article.setId(articleDto.getId());
        article.setName(articleDto.getName());
        article.setImage(articleDto.getImage());
        article.setPrice(articleDto.getPrice());
        return article;
    }

    public static ArticleDto mapToArticleDto(Article article) {
        ArticleDto articleDto = new ArticleDto();
        articleDto.setId(article.getId());
        articleDto.setName(article.getName());
        articleDto.setImage(article.getImage());
        articleDto.setPrice(article.getPrice());
        return articleDto;
    }
}
