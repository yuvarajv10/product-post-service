/**
 * 
 */
package com.product.post.util;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.product.post.entity.CategoryEntity;
import com.product.post.repository.CategoryRepository;

/**
 * @author yuvaraj
 *
 */
@Component
public class CommonUtil {

	@Autowired
	CategoryRepository categoryRepo;

	public String getCategoryName(Long categoryId) {
		Optional<CategoryEntity> categoryOpt = categoryRepo.findById(categoryId);
		if (categoryOpt.isPresent()) {
			return categoryOpt.get().getName();
		}
		return "";
	}

}
