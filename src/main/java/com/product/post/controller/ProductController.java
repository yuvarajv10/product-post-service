/**
 * 
 */
package com.product.post.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import com.product.post.bo.ProductBo;
import com.product.post.component.ProductComponent;
import com.product.post.dto.ProductDto;
import com.product.post.dto.UserDto;

/**
 * Product related services.
 * 
 * @author yuvaraj
 *
 */
@Controller
@RequestMapping(value = "/product")
public class ProductController {

	@Autowired
	ProductComponent productComponent;

	/**
	 * Add new product.
	 * 
	 * @param productBo
	 * @return
	 */
	@PostMapping(value = "/save")
	@ResponseBody
	public ResponseEntity<ProductDto> saveProduct(@RequestBody @Valid ProductBo productBo) {
		checkUserAuthStatus();
		return new ResponseEntity<>(productComponent.saveProduct(productBo), HttpStatus.OK);
	}

	/**
	 * Update the product.
	 * 
	 * @param productBo
	 * @return
	 */
	@PutMapping(value = "/update")
	@ResponseBody
	public ResponseEntity<ProductDto> updateProduct(@RequestBody @Valid ProductBo productBo) {
		checkUserAuthStatus();
		return new ResponseEntity<>(productComponent.updateProduct(productBo), HttpStatus.OK);
	}

	/**
	 * Delete product by productId.
	 * 
	 * @param productId
	 * @return
	 */
	@DeleteMapping("/remove/{productId}")
	public ResponseEntity<?> removeProduct(@PathVariable Long productId) {
		checkUserAuthStatus();
		return new ResponseEntity<>(productComponent.removeProduct(productId), HttpStatus.OK);
	}

	/**
	 * List all products.
	 * 
	 * @return
	 */
	@GetMapping("/")
	public ResponseEntity<List<ProductDto>> getProducts() {
		checkUserAuthStatus();
		return new ResponseEntity<>(productComponent.getProducts(), HttpStatus.OK);
	}

	/**
	 * List products based on category and product. It will use while implement with
	 * search and filter.
	 * 
	 * @param categoryId
	 * @param productId
	 * @return
	 */
	@GetMapping("/category/{categoryId}/product/{productId}")
	public ResponseEntity<List<ProductDto>> getProducts(@PathVariable Long categoryId, @PathVariable Long productId) {
		checkUserAuthStatus();
		return new ResponseEntity<>(productComponent.getProducts(categoryId, productId), HttpStatus.OK);
	}

	/**
	 * Get product detail by product id.
	 * 
	 * @param productId
	 * @return
	 */
	@GetMapping("/details/{productId}")
	public ResponseEntity<ProductDto> getProduct(@PathVariable Long productId) {
		checkUserAuthStatus();
		return new ResponseEntity<>(productComponent.getProduct(productId), HttpStatus.OK);
	}

	/**
	 * Checking authentication while access api.
	 * 
	 * @return
	 */
	private String checkUserAuthStatus() {
		try {
			HttpStatus response = new RestTemplate().getForEntity("http://localhost:8000/user/status", UserDto.class)
					.getStatusCode();
			if (response.FORBIDDEN == HttpStatus.FORBIDDEN) {
				return "redirect:http://localhost:8101/user/login";
			}
		} catch (HttpStatusCodeException exception) {
			if (exception.getStatusCode().FORBIDDEN == HttpStatus.FORBIDDEN) {
				return "redirect:http://localhost:8101/user/login";
			}
		}

		return "";
	}
}
