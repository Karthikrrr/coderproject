package com.lovemycode.ecommerce.config;

import com.lovemycode.ecommerce.entity.Product;
import com.lovemycode.ecommerce.entity.ProductCategory;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {


    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        RepositoryRestConfigurer.super.configureRepositoryRestConfiguration(config, cors);

        HttpMethod[] theUnsupportedactions = {HttpMethod.PUT, HttpMethod.POST, HttpMethod.DELETE};


        config.getExposureConfiguration()
                .forDomainType(Product.class)
                .withItemExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedactions))
                .withCollectionExposure(((metdata, httpMethods) -> httpMethods.disable(theUnsupportedactions)));

        config.getExposureConfiguration()
                .forDomainType(ProductCategory.class)
                .withItemExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedactions))
                .withCollectionExposure(((metdata, httpMethods) -> httpMethods.disable(theUnsupportedactions)));

    }
}