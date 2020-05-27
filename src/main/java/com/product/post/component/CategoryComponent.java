/**
 * 
 */
package com.product.post.component;

import java.util.List;

import com.product.post.bo.CategoryBo;
import com.product.post.dto.CategoryDto;

/**
 * @author yuvaraj
 *
 */
public interface CategoryComponent {

	List<CategoryDto> getCategories();

	CategoryDto getCategory(Long categoryId);

	CategoryDto saveCategory(CategoryBo categoryBo);

	CategoryDto updateCategory(CategoryBo categoryBo);

	boolean removeCategory(Long categoryId);
}
