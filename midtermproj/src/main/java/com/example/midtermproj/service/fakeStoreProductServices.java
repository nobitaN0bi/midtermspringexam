package com.example.midtermproj.service;

import com.example.midtermproj.dtos.fakeStoreProductDTO;
import com.example.midtermproj.models.Category;
import com.example.midtermproj.models.Product;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@SuppressWarnings("SpellCheckingInspection")
@Configuration
public class fakeStoreProductServices implements ProductServices {


    private final String url = "https://fakestoreapi.com/products";
    private final RestTemplate restTemplate = new RestTemplate();

    @Override
    public List<Product> getProducts() {

        List<fakeStoreProductDTO> fakeStoreProductDTOinstances = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<fakeStoreProductDTO>>() {
                }).getBody();

        assert fakeStoreProductDTOinstances != null;

        return fakeStoreProductDTOinstances.stream().map(this::mapToProduct).toList();
    }

    private Product mapToProduct(fakeStoreProductDTO fakeStoreProductDTO) {
        Category category = new Category(1L, fakeStoreProductDTO.getCategory());
        category.setName(fakeStoreProductDTO.getCategory());
        return new Product(fakeStoreProductDTO.getId(), fakeStoreProductDTO.getTitle(), fakeStoreProductDTO.getDescription(), fakeStoreProductDTO.getPrice(), category, fakeStoreProductDTO.getImage());
    }

    @Override
    public Product getProduct(Long id) {

        fakeStoreProductDTO fakeStoreProductDTO = restTemplate.getForObject(url + "/" + id, fakeStoreProductDTO.class);

        assert fakeStoreProductDTO != null;

        return mapToProduct(fakeStoreProductDTO);
    }

    @Override
    public Product addProduct(Product product) {

//        Add product to the fakestoreapi
        fakeStoreProductDTO fakeStoreProductDTO = new fakeStoreProductDTO();
        fakeStoreProductDTO.setTitle(product.getTitle());
        fakeStoreProductDTO.setDescription(product.getDescription());
        fakeStoreProductDTO.setCategory(product.getCategory().getName());
        fakeStoreProductDTO.setPrice(product.getPrice());
        fakeStoreProductDTO.setImage(product.getImageUrl());

        fakeStoreProductDTO response = restTemplate.postForObject(url, fakeStoreProductDTO, fakeStoreProductDTO.class);

        assert response != null;

        return mapToProduct(response);
    }

    @Override
    public Product updateProduct(Product product) {
//        Update product to the fakestoreapi
        fakeStoreProductDTO fakeStoreProductDTO = new fakeStoreProductDTO();
        fakeStoreProductDTO.setId(product.getId());
        fakeStoreProductDTO.setTitle(product.getTitle());
        fakeStoreProductDTO.setDescription(product.getDescription());
        fakeStoreProductDTO.setCategory(product.getCategory().getName());
        fakeStoreProductDTO.setPrice(product.getPrice());
        fakeStoreProductDTO.setImage(product.getImageUrl());

        restTemplate.put(url + "/" + product.getId(), fakeStoreProductDTO);

        return product;
    }

    @Override
    public void deleteProduct(Long id) {
        restTemplate.delete(url + "/" + id);
    }

    @Override
    public List<Product> getProductsByCategory(String categoryName) {
//     https://fakestoreapi.com/products/category/jewelery
        List<fakeStoreProductDTO> fakeStoreProductDTOinstances = restTemplate.exchange(
                url + "/category/" + categoryName,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<fakeStoreProductDTO>>() {
                }).getBody();

        assert fakeStoreProductDTOinstances != null;

        return fakeStoreProductDTOinstances.stream().map(this::mapToProduct).toList();
    }

    @Override
    public List<String> getCategories() {

        List<String> categories = restTemplate.exchange(
                url + "/categories",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<String>>() {
                }).getBody();

        assert categories != null;

        return categories;
    }

    @Override
    public List<Product> getLimitedProducts(int limit) {

//        https://fakestoreapi.com/products?limit=
        List<fakeStoreProductDTO> fakeStoreProductDTOinstances = restTemplate.exchange(
                url + "?limit=" + limit,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<fakeStoreProductDTO>>() {
                }).getBody();

        assert fakeStoreProductDTOinstances != null;

        return fakeStoreProductDTOinstances.stream().map(this::mapToProduct).toList();

    }

    @Override
    public List<Product> getSortedProducts(String sort) {

//        https://fakestoreapi.com/products?sort=
        List<fakeStoreProductDTO> fakeStoreProductDTOinstances = restTemplate.exchange(
                url + "?sort=" + sort,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<fakeStoreProductDTO>>() {
                }).getBody();

        assert fakeStoreProductDTOinstances != null;

        return fakeStoreProductDTOinstances.stream().map(this::mapToProduct).toList();

    }
}
