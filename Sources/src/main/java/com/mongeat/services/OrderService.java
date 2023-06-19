package com.mongeat.services;

import com.mongeat.converters.ArticleConverter;
import com.mongeat.converters.OrderConverter;
import com.mongeat.converters.UserConverter;
import com.mongeat.converters.add.NewOrderConverter;
import com.mongeat.entities.OrderEntity;
import com.mongeat.models.Article;
import com.mongeat.models.Order;
import com.mongeat.models.add.NewOrder;
import com.mongeat.repositories.ArticleRepository;
import com.mongeat.repositories.OrderRepository;
import com.mongeat.repositories.UserRepository;
import jakarta.annotation.PostConstruct;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Singleton
public class OrderService extends GenericService<Order, NewOrder, OrderEntity> {
    @Inject
    OrderRepository orderRepository;
    @Inject
    ArticleRepository articleRepository;
    @Inject
    UserRepository userRepository;

    ArticleConverter articleConverter = new ArticleConverter();
    UserConverter userConverter = new UserConverter();

    @PostConstruct
    public void init() {
        setRepository(orderRepository);
        setConverter(new OrderConverter());
        setAddConverter(new NewOrderConverter());
    }

    @Override
    public Order getById(String id) {
        OrderEntity entity = repository.findById(id);
        Order order = converter.toModel(entity);
        order.setArticles(entity.getArticles().stream().map(a -> articleConverter.toModel(articleRepository.findById(a))).collect(Collectors.toList()));
        order.setOwner(userConverter.toModel(userRepository.findById(entity.getOwner())));
        return order;
    }

    @Override
    public Collection<Order> getAll() {
        ArrayList<OrderEntity> entities = (ArrayList<OrderEntity>) repository.getAll();
        ArrayList<Order> orders = (ArrayList<Order>) entities.stream().map(e -> converter.toModel(e)).collect(Collectors.toList());
        int i = 0;
        for (OrderEntity order : entities) {
            orders.get(i).setArticles(getArticlesFromOrder(order));
            orders.get(i).setOwner(userConverter.toModel(userRepository.findById(entities.stream().map(OrderEntity::getOwner).collect(Collectors.toList()).get(i))));
            i++;
        }
        return orders;
    }

    @Override
    public Collection<Order> getPaginated(int page, int limit) {
        ArrayList<OrderEntity> entities = (ArrayList<OrderEntity>) repository.getPaginated(page, limit);
        ArrayList<Order> orders = (ArrayList<Order>) entities.stream().map(e -> converter.toModel(e)).collect(Collectors.toList());
        int i = 0;
        for (OrderEntity order : entities) {
            orders.get(i).setArticles(getArticlesFromOrder(order));
            orders.get(i).setOwner(userConverter.toModel(userRepository.findById(entities.stream().map(OrderEntity::getOwner).collect(Collectors.toList()).get(i))));
            i++;
        }
        return orders;
    }

    private List<Article> getArticlesFromOrder(OrderEntity order) {
        List<Article> articles = new ArrayList<>();
        order.getArticles().forEach(articleId -> articles.add(articleConverter.toModel(articleRepository.findById(articleId))));
        return articles;
    }
}
