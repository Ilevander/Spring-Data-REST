package com.ilyass.springdatarest;

import com.ilyass.springdatarest.dao.ArticleRepository;
import com.ilyass.springdatarest.dao.CategoryRepository;
import com.ilyass.springdatarest.service.model.Article;
import com.ilyass.springdatarest.service.model.Categorie;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class SpringDataRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataRestApplication.class, args);
    }

    @Bean
    public CommandLineRunner initDatabase(CategoryRepository categorieRepository,
                                          ArticleRepository articleRepository) {
        return (args) -> {
            // Creating and saving categories
            var categorie1 = Categorie.builder().categorie("CATEGORIE_1").build();
            var categorie2 = Categorie.builder().categorie("CATEGORIE_2").build();
            var categorie3 = Categorie.builder().categorie("CATEGORIE_3").build();

            categorie1 = categorieRepository.save(categorie1);
            categorie2 = categorieRepository.save(categorie2);
            categorie3 = categorieRepository.save(categorie3);

            // Creating and associating articles with categories
            var article1 = Article.builder()
                    .description("Article_1")
                    .price(5000.0)
                    .quantity(10.0)
                    .categorie(categorie1) // Set category
                    .build();

            var article2 = Article.builder()
                    .description("Article_2")
                    .price(6000.0)
                    .quantity(20.0)
                    .categorie(categorie1) // Set category
                    .build();

            var article3 = Article.builder()
                    .description("Article_3")
                    .price(7000.0)
                    .quantity(30.0)
                    .categorie(categorie2) // Set category
                    .build();

            var article4 = Article.builder()
                    .description("Article_4")
                    .price(8000.0)
                    .quantity(40.0)
                    .categorie(categorie2) // Set category
                    .build();

            var article5 = Article.builder()
                    .description("Article_5")
                    .price(9000.0)
                    .quantity(50.0)
                    .categorie(categorie3) // Set category
                    .build();

            // Saving articles with categories properly set
            articleRepository.save(article1);
            articleRepository.save(article2);
            articleRepository.save(article3);
            articleRepository.save(article4);
            articleRepository.save(article5);

            // Updating categories with their associated articles
            categorie1.setArticles(new ArrayList<>());
            categorie1.addArticle(article1);
            categorie1.addArticle(article2);

            categorie2.setArticles(new ArrayList<>());
            categorie2.addArticle(article3);
            categorie2.addArticle(article4);

            categorie3.setArticles(new ArrayList<>());
            categorie3.addArticle(article5);

            // Saving updated categories (if necessary in your setup)
            categorieRepository.save(categorie1);
            categorieRepository.save(categorie2);
            categorieRepository.save(categorie3);
        };
    }


}
