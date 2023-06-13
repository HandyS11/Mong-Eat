package com.mongeat.stub;

import com.mongeat.entities.Article;

import java.util.ArrayList;
import java.util.List;

public class ArticleStub {
    public final List<Article> articles = new ArrayList<>();

    public ArticleStub() {
        Article article1 = new Article("64705dcabd367e78ccaddbe0", "HotDog", "https://img-3.journaldesfemmes.fr/EnBOqIbquxzrhd5mUBBcYWxuC6k=/800x600/smart/7f89fdbac0064efd89ffefe57963f5e4/recipe-jdf/10027650.jpg", 4.99);
        Article article2 = new Article("64705dda1fe1d56fab1b17b2", "Kebab", "https://assets.afcdn.com/recipe/20210304/118354_w1024h1024c1cx1060cy707.webp", 7.99);
        Article article3 = new Article("64705df5278554181000e023", "Tacos", "https://img.lamontagne.fr/HmMg02j97x7ruTOhk40Zaerb9DxgUpPRh7zpZ_U8wrs/fit/657/438/sm/0/bG9jYWw6Ly8vMDAvMDAvMDQvNjMvMzgvMjAwMDAwNDYzMzg3Mg.jpg", 8.99);
        Article article4 = new Article("64705e06ae09d7bf1afc23ff", "Shushi", "https://img.freepik.com/photos-premium/grand-ensemble-sushis-rouleaux-enormes-rouleaux-taille-assiettes-blanches-enorme-assiette-shushi_457363-1987.jpg", 14.99);
        Article article5 = new Article("64705e5df7e8ac3405332f57", "Pizza", "https://img.passeportsante.net/1200x675/2021-03-26/i100872-.webp", 12.99);
        Article article6 = new Article("64705e9520469bd3b59ec539", "Hamburger", "https://cf-images.us-east-1.prod.boltdns.net/v1/static/1033249144001/8f05cb88-1a61-4d69-a75e-74be87e533e4/b3598f48-b8ca-4eda-b091-800804d2cba1/1280x720/match/image.jpg", 5.99);

        articles.add(article1);
        articles.add(article2);
        articles.add(article3);
        articles.add(article4);
        articles.add(article5);
        articles.add(article6);
    }

    public List<Article> getArticles() {
        return articles;
    }
}
