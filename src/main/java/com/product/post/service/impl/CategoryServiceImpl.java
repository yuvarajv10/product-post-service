/**
 * 
 */
package com.product.post.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.product.post.bo.CategoryBo;
import com.product.post.constant.CommonConstant;
import com.product.post.dto.CategoryDto;
import com.product.post.entity.CategoryEntity;
import com.product.post.repository.CategoryRepository;
import com.product.post.service.CategoryService;

/**
 * @author yuvaraj
 *
 */
@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryRepository categoryRepo;

	@Override
	public List<CategoryDto> getCategories() {
		List<CategoryEntity> categoryEntities = categoryRepo.findAll();
		List<CategoryDto> categoryDtos = new ArrayList<>();
		for (CategoryEntity categoryEntity : categoryEntities) {
			CategoryDto categoryDto = new CategoryDto();
			categoryDto.setId(categoryEntity.getId());
			categoryDto.setName(categoryEntity.getName());
			categoryDto.setStatus(categoryEntity.getStatus());
			categoryDtos.add(categoryDto);
		}

		return categoryDtos;
	}

	@Override
	public CategoryDto getCategory(Long categoryId) {
		Optional<CategoryEntity> categoryOpt = categoryRepo.findById(categoryId);
		CategoryDto categoryDto = new CategoryDto();
		if (categoryOpt.isPresent()) {
			CategoryEntity categoryEntity = categoryOpt.get();
			categoryDto = convertToCategoryDto(categoryEntity);
		}
		return categoryDto;
	}

	@Override
	public CategoryDto saveCategory(CategoryBo categoryBo) {
		CategoryEntity categoryEntity = new CategoryEntity();
		categoryEntity.setName(categoryBo.getName());
		categoryEntity.setStatus(CommonConstant.ACTIVE);
		categoryRepo.save(categoryEntity);
		return convertToCategoryDto(categoryEntity);
	}

	@Override
	public CategoryDto updateCategory(CategoryBo categoryBo) {
		Optional<CategoryEntity> categoryOpt = categoryRepo.findById(categoryBo.getId());
		CategoryDto categoryDto = new CategoryDto();
		if (categoryOpt.isPresent()) {
			CategoryEntity categoryEntity = categoryOpt.get();
			categoryEntity.setName(categoryBo.getName());
			categoryEntity.setStatus(categoryBo.getStatus());
			categoryRepo.save(categoryEntity);
			categoryDto = convertToCategoryDto(categoryEntity);
		}
		return categoryDto;
	}

	private CategoryDto convertToCategoryDto(CategoryEntity categoryEntity) {
		CategoryDto categoryDto = new CategoryDto();
		categoryDto.setId(categoryEntity.getId());
		categoryDto.setName(categoryEntity.getName());
		categoryDto.setStatus(categoryEntity.getStatus());
		return categoryDto;
	}

	@Override
	public boolean removeCategory(Long categoryId) {
		Optional<CategoryEntity> categoryOpt = categoryRepo.findById(categoryId);
		if (categoryOpt.isPresent()) {
			CategoryEntity categoryEntity = categoryOpt.get();
			categoryRepo.delete(categoryEntity);
			return true;
		}
		return false;
	}

}
