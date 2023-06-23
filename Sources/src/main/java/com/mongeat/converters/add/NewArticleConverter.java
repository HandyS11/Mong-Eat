package com.mongeat.converters.add;

import com.mongeat.converters.IConverter;
import com.mongeat.entities.ArticleEntity;
import com.mongeat.models.add.NewArticle;

/**
 * Converts a NewArticle to an ArticleEntity
 */
public class NewArticleConverter implements IConverter<NewArticle, ArticleEntity> {

    /**
     * Converts a NewArticle object to an ArticleEntity object.
     *
     * @param object The NewArticle object to convert.
     * @return The ArticleEntity object.
     */
    @Override
    public ArticleEntity toEntity(NewArticle object) {
        if (object == null) {
            return null;
        }
        ArticleEntity articleEntity = new ArticleEntity();
        articleEntity.setName(object.getName());
        articleEntity.setImage(object.getImage());
        articleEntity.setPrice(object.getPrice());
        return articleEntity;
    }

    /**
     * Converts an ArticleEntity object to a NewArticle object.
     *
     * @param object The ArticleEntity object to convert.
     * @return The NewArticle object.
     */
    @Override
    public NewArticle toModel(ArticleEntity object) {
        if (object == null) {
            return null;
        }
        NewArticle article = new NewArticle();
        article.setName(object.getName());
        article.setImage(object.getImage());
        article.setPrice(object.getPrice());
        return article;
    }
}
