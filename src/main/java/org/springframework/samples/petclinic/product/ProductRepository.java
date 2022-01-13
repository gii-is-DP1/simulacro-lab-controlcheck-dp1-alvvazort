package org.springframework.samples.petclinic.product;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;




public interface ProductRepository extends CrudRepository<Product, Integer>{
    List<Product> findAll();

    @Query("Select p from ProductType p")
    List<ProductType> findAllProductTypes();
    @Query("Select p from ProductType p where p.name = :name")
    ProductType findProductTypesByName(@Param("name") String name);

    @Query("Select p from Product p where p.price < :price")
    List<Product> findByPriceLessThan(@Param("price") double price);
    Optional<Product> findById(int id);
    Product findByName(String name) ;
    Product save(Product p);
}
