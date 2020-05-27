/**
 * 
 */
package com.product.post.service;

import java.util.List;

import com.product.post.bo.ProductBo;
import com.product.post.dto.ProductDto;

/**
 * @author yuvaraj
 *
 */
public interface ProductService {

	List<ProductDto> getProducts();

	ProductDto getProduct(Long productId);

	ProductDto saveProduct(ProductBo productBo);

	ProductDto updateProduct(ProductBo productBo);

	boolean removeProduct(Long productId);

	List<ProductDto> getProducts(Long categoryId, Long productId);

}
