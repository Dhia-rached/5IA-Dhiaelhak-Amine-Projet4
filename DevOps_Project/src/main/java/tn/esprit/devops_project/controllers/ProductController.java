package tn.esprit.devops_project.controllers;

import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.*;
import tn.esprit.devops_project.entities.Product;
import tn.esprit.devops_project.entities.ProductCategory;
import tn.esprit.devops_project.services.Iservices.IProductService;

import java.util.List;
@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*")

















public class ProductController {
    private static final Logger logger = LogManager.getLogger(ProductController.class);
    private final IProductService productService;

    @PostMapping("/product/{idStock}")
    Product addProduct(@RequestBody Product product,@PathVariable Long idStock){
        logger.info("Adding product with stock ID: {}", idStock);
        return productService.addProduct(product,idStock);

    }

    @GetMapping("/product/{id}")
    Product retrieveProduct(@PathVariable Long id){
        logger.info("Retrieving product with ID: {}", id);

        return productService.retrieveProduct(id);
    }

    @GetMapping("/product")
    List<Product> retreiveAllProduct(){
        logger.info("Retrieving all products");

        return productService.retreiveAllProduct();
    }
    @GetMapping("/product/stock/{id}")
    List<Product> retreiveProductStock(@PathVariable Long id){
        logger.info("Retrieving products for stock ID: {}", id);

        return productService.retreiveProductStock(id);
    }

    @GetMapping("/productCategoy/{category}")
    List<Product> retrieveProductByCategory(@PathVariable ProductCategory category){
        logger.info("Retrieving products in category: {}", category);

        return productService.retrieveProductByCategory(category);
    }

    @DeleteMapping("/product/{id}")
    void deleteProduct(@PathVariable Long id){
        logger.info("Deleting product with ID: {}", id);

        productService.deleteProduct(id);
    }
}
