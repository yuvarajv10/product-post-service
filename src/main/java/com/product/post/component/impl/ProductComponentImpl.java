/**
 * 
 */
package com.product.post.component.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.product.post.bo.ProductBo;
import com.product.post.component.ProductComponent;
import com.product.post.dto.ProductDto;
import com.product.post.service.ProductService;

/**
 * @author yuvaraj
 *
 */
@Component
public class ProductComponentImpl implements ProductComponent {

	@Autowired
	ProductService productService;

	@Override
	public List<ProductDto> getProducts() {
		return productService.getProducts();
	}

	@Override
	public ProductDto getProduct(Long productId) {
		return productService.getProduct(productId);
	}

	@Override
	public ProductDto saveProduct(ProductBo productBo) {
		return productService.saveProduct(productBo);
	}

	@Override
	public ProductDto updateProduct(ProductBo productBo) {
		return productService.updateProduct(productBo);
	}

	@Override
	public boolean removeProduct(Long productId) {
		return productService.removeProduct(productId);
	}

	@Override
	public List<ProductDto> getProducts(Long categoryId, Long productId) {
		return productService.getProducts(categoryId, productId);
	}

}
