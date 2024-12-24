package com.ilyass.springdatarest.dao;

import com.ilyass.springdatarest.domain.ArticleDTO;
import com.ilyass.springdatarest.service.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "articles", path = "ecommerce", excerptProjection = ArticleDTO.class)
public interface ArticleRepository extends JpaRepository<Article, Long> {
    @RestResource(path = "byCategorie", rel = "customFindByDescription")
    List<Article> findByCategorie_Categorie(@Param("categorie") String description);
}

/**
 *         ◦ L’annotation @RepositoryRestResource permet d’exposer le Repository ArticleRepository sous forme d’api Rest.
 *
 *         ◦ L’attribut collectionResourceRel sert à configurer le nom du champ qui représentera la collection des articles dans le message JSON ou XML.
 *
 *         ◦ L’attribut path sert à configurer le nom de l’Endpoint dans l’URL.
 *         ◦ L’attribut excerptProjection permet de préciser les projections que l’api peut exposer aux clients.
 */