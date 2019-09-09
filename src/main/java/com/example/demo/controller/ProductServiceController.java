package com.example.demo.controller;

import com.example.demo.exception.ProductNotFoundException;
import com.example.demo.model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

//GET API
@RestController
public class ProductServiceController {
    private static Map<String, Product> productRepo = new HashMap<>();

    static {
        Product honey = new Product();
        honey.setId("1");
        honey.setName("Honey");
        productRepo.put(honey.getId(),honey);

        Product almond = new Product();
        almond.setId("2");
        almond.setName("Almond");
        productRepo.put(almond.getId(),almond);

    }

    //GET REQUEST
    @RequestMapping(value = "/products")
    public ResponseEntity<Object> getProduct() {
        return new ResponseEntity<>(productRepo.values(), HttpStatus.OK);
    }

    //POST REQUEST - Create a resource
    @RequestMapping(value = "/products",  method = RequestMethod.POST)
    public ResponseEntity<Object> createProduct (@RequestBody Product product) {
        productRepo.put(product.getId(),product);
        return new ResponseEntity<>("Product is created successfully", HttpStatus.CREATED);
    }

    //PUT REQUEST - Update a resource.
    @RequestMapping(value = "/products/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateProduct(@PathVariable("id") String id, @RequestBody Product product) {
        if (!productRepo.containsKey(id)) throw new ProductNotFoundException();
        productRepo.remove(id);
        product.setId(id);
        productRepo.put(id, product);
        return new ResponseEntity<>("Product is updated successfully", HttpStatus.OK);
    }


    //DELETE REQUEST - Delete existing resources. It does not contain request body
    //We can send path variables or Request params
    @RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)

    public ResponseEntity<Object> deleteProduct(@PathVariable("id") String id) {
        if(!productRepo.containsKey(id)) throw new ProductNotFoundException();
        productRepo.remove(id);
        return new ResponseEntity<>("Product is deleted successfully", HttpStatus.OK);
    }

    //GET REQUEST - GET ONE PRODUCT
    @RequestMapping(value = "/products/{id}")
    public ResponseEntity<Object>getOneProduct(@PathVariable("id") String id) {
        if (!productRepo.containsKey(id)) throw new ProductNotFoundException();
        return new ResponseEntity<>(productRepo.get(id), HttpStatus.OK);
    }

}
