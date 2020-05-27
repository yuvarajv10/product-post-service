/**
 * 
 */
package com.product.post.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.product.post.entity.ProductEntity;

/**
 * @author yuvaraj
 *
 */
@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

	Optional<ProductEntity> findByIdAndStatus(Long productId, Integer status);

	List<ProductEntity> findByIdAndCategory(Long productId, Long categoryId);

}
