package com.ilyass.springdatarest.domain;

import com.ilyass.springdatarest.service.model.Article;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "articleDTO", types = Article.class)
public interface ArticleDTO {
    Long getId();

    @Value("#{target.description}")
    String getDesc();

    Double getPrice();

    @Value("#{target.quantity}")
    Double getQuant();

    @Value("#{target.categorie.categorie}")
    String getCat();
}

/*
        ◦ L’annotation @Projection de Spring Data Rest permet de préciser les projections des données à transférer via Rest.
        Dans cet exemple, nous allons transmettre : l’identifiant de l’article (champ : id), la description (champ : desc), le prix (champ price), la quantité (champ : quant) et la catégorie (champs : cat).
        Par défaut, Spring Data Rest n’envoie pas l’id dans la réponse Rest.

        ◦ Par défaut, Spring Data Rest injectera la valeur du champ ayant le même nom au niveau de la classe Article (classe précisée dans l’attribut types de l’annotation @Projection).

        ◦ Si un champ de la Classe ArticleDTO n’ayant pas le même nom qu’aucun champ de la classe Article, il faut annoter ce dernier par @Value en précisant le nom du champ correspondant au niveau de la classe Article.
 */
