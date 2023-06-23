package com.mongeat.mappers;

import com.mongeat.dtos.ArticleDto;
import com.mongeat.models.Article;

/**
 * Map Article to ArticleDto and vice versa
 */
public class ArticleMapper implements IMapper<Article, ArticleDto> {

    /**
     * Map Article to ArticleDto
     * @param object Article
     * @return ArticleDto
     */
    @Override
    public ArticleDto toDto(Article object) {
        ArticleDto articleDto = new ArticleDto();
        articleDto.setId(object.getId());
        articleDto.setName(object.getName());
        articleDto.setImage(object.getImage());
        articleDto.setPrice(object.getPrice());
        return articleDto;
    }

    /**
     * Map ArticleDto to Article
     * @param object ArticleDto
     * @return Article
     */
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
