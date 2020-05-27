/**
 * 
 */
package com.product.post.component.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.product.post.bo.CategoryBo;
import com.product.post.component.CategoryComponent;
import com.product.post.dto.CategoryDto;
import com.product.post.service.CategoryService;

/**
 * @author yuvaraj
 *
 */
@Component
public class CategoryComponentImpl implements CategoryComponent {

	@Autowired
	CategoryService categoryService;

	@Override
	public List<CategoryDto> getCategories() {
		return categoryService.getCategories();
	}

	@Override
	public CategoryDto getCategory(Long categoryId) {
		return categoryService.getCategory(categoryId);
	}

	@Override
	public CategoryDto saveCategory(CategoryBo categoryBo) {
		return categoryService.saveCategory(categoryBo);
	}

	@Override
	public CategoryDto updateCategory(CategoryBo categoryBo) {
		return categoryService.updateCategory(categoryBo);
	}

	@Override
	public boolean removeCategory(Long categoryId) {
		return categoryService.removeCategory(categoryId);
	}

}
