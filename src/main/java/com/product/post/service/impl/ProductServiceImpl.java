/**
 * 
 */
package com.product.post.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.post.bo.ProductBo;
import com.product.post.constant.CommonConstant;
import com.product.post.dto.ProductDto;
import com.product.post.entity.ProductEntity;
import com.product.post.repository.ProductRepository;
import com.product.post.service.ProductService;
import com.product.post.util.CommonUtil;

/**
 * @author yuvaraj
 *
 */
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepo;

	@Autowired
	CommonUtil commonUtil;

	@Override
	public List<ProductDto> getProducts() {
		List<ProductEntity> productEntities = productRepo.findAll();
		List<ProductDto> productDtos = new ArrayList<>();
		for (ProductEntity productEntity : productEntities) {
			ProductDto productDto = new ProductDto();
			productDto.setId(productEntity.getId());
			productDto.setName(productEntity.getName());
			productDto.setPrice(productEntity.getPrice());
			productDto.setImage(productEntity.getImage());
			productDto.setDescription(productEntity.getDescription());
			productDto.setCategory(productEntity.getCategory());
			productDto.setCategoryName(commonUtil.getCategoryName(productEntity.getCategory()));
			productDto.setWidth(productEntity.getWidth());
			productDto.setHeight(productEntity.getHeight());
			productDto.setWeight(productEntity.getWeight());
			productDto.setQuantity(productEntity.getQuantity());
			productDto.setShippingFee(productEntity.getShippingFee());
			productDto.setStatus(CommonConstant.ACTIVE);
			productDtos.add(productDto);
		}
		return productDtos;
	}

	@Override
	public ProductDto getProduct(Long productId) {
		Optional<ProductEntity> productOpt = productRepo.findById(productId);
		ProductDto productDto = new ProductDto();
		if (productOpt.isPresent()) {
			ProductEntity productEntity = productOpt.get();
			productDto = convertToProductDto(productEntity);
		}
		return productDto;
	}

	@Override
	public ProductDto saveProduct(ProductBo productBo) {
		ProductEntity productEntity = new ProductEntity();
		productEntity.setName(productBo.getName());
		productEntity.setPrice(productBo.getPrice());
		productEntity.setImage(productBo.getImage());
		productEntity.setDescription(productBo.getDescription());
		productEntity.setCategory(productBo.getCategory());
		productEntity.setWidth(productBo.getWidth());
		productEntity.setHeight(productBo.getHeight());
		productEntity.setWeight(productBo.getWeight());
		productEntity.setQuantity(productBo.getQuantity());
		productEntity.setShippingFee(productBo.getShippingFee());
		productEntity.setStatus(CommonConstant.ACTIVE);
		productEntity.setPostedBy(1l);
		productRepo.save(productEntity);
		return convertToProductDto(productEntity);
	}

	@Override
	public ProductDto updateProduct(ProductBo productBo) {
		Optional<ProductEntity> productOpt = productRepo.findById(productBo.getId());
		ProductDto productDto = new ProductDto();
		if (productOpt.isPresent()) {
			ProductEntity productEntity = productOpt.get();
			productEntity.setName(productBo.getName());
			productEntity.setPrice(productBo.getPrice());
			productEntity.setImage(productBo.getImage());
			productEntity.setDescription(productBo.getDescription());
			productEntity.setCategory(productBo.getCategory());
			productEntity.setWidth(productBo.getWidth());
			productEntity.setHeight(productBo.getHeight());
			productEntity.setWeight(productBo.getWeight());
			productEntity.setQuantity(productBo.getQuantity());
			productEntity.setShippingFee(productBo.getShippingFee());
			productEntity.setStatus(CommonConstant.ACTIVE);
			productEntity.setPostedBy(1l);
			productRepo.save(productEntity);

			productDto = convertToProductDto(productEntity);
		}
		return productDto;
	}

	private ProductDto convertToProductDto(ProductEntity productEntity) {
		ProductDto productDto = new ProductDto();
		productDto.setId(productEntity.getId());
		productDto.setName(productEntity.getName());
		productDto.setPrice(productEntity.getPrice());
		productDto.setImage(productEntity.getImage());
		productDto.setDescription(productEntity.getDescription());
		productDto.setCategory(productEntity.getCategory());
		productDto.setCategoryName(commonUtil.getCategoryName(productEntity.getCategory()));
		productDto.setWidth(productEntity.getWidth());
		productDto.setHeight(productEntity.getHeight());
		productDto.setWeight(productEntity.getWeight());
		productDto.setQuantity(productEntity.getQuantity());
		productDto.setShippingFee(productEntity.getShippingFee());
		productDto.setStatus(CommonConstant.ACTIVE);		
		return productDto;
	}

	@Override
	public boolean removeProduct(Long productId) {
		Optional<ProductEntity> productOpt = productRepo.findById(productId);
		if (productOpt.isPresent()) {
			ProductEntity productEntity = productOpt.get();
			productRepo.delete(productEntity);
			return true;
		}
		return false;
	}

	@Override
	public List<ProductDto> getProducts(Long categoryId, Long productId) {
		List<ProductEntity> productEntities = productRepo.findByIdAndCategory(productId, categoryId);
		List<ProductDto> productDtos = new ArrayList<>();
		for (ProductEntity productEntity : productEntities) {
			ProductDto productDto = new ProductDto();
			productDto.setId(productEntity.getId());
			productDto.setName(productEntity.getName());
			productDto.setPrice(productEntity.getPrice());
			productDto.setImage(productEntity.getImage());
			productDto.setDescription(productEntity.getDescription());
			productDto.setCategory(productEntity.getCategory());
			productDto.setCategoryName(commonUtil.getCategoryName(productEntity.getCategory()));
			productDto.setWidth(productEntity.getWidth());
			productDto.setHeight(productEntity.getHeight());
			productDto.setWeight(productEntity.getWeight());
			productDto.setQuantity(productEntity.getQuantity());
			productDto.setShippingFee(productEntity.getShippingFee());
			productDto.setStatus(CommonConstant.ACTIVE);
			productDtos.add(productDto);
		}
		return productDtos;
	}

}
