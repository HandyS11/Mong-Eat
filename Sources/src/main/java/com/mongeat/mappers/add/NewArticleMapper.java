package com.mongeat.mappers.add;

import com.mongeat.dtos.add.NewArticleDto;
import com.mongeat.mappers.IMapper;
import com.mongeat.models.add.NewArticle;

public class NewArticleMapper implements IMapper<NewArticle, NewArticleDto> {

    @Override
    public NewArticleDto toDto(NewArticle object) {
        NewArticleDto articleDto = new NewArticleDto();
        articleDto.setName(object.getName());
        articleDto.setImage(object.getImage());
        articleDto.setPrice(object.getPrice());
        return articleDto;
    }

    @Override
    public NewArticle toModel(NewArticleDto object) {
        NewArticle article = new NewArticle();
        article.setName(object.getName());
        article.setImage(object.getImage());
        article.setPrice(object.getPrice());
        return article;
    }
}
