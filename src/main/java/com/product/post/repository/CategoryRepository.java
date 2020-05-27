/**
 * 
 */
package com.product.post.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.product.post.entity.CategoryEntity;

/**
 * @author yuvaraj
 *
 */
@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {

	Optional<CategoryEntity> findByName(String name);

}
