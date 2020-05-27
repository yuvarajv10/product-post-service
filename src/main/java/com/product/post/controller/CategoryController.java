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

import com.product.post.bo.CategoryBo;
import com.product.post.component.CategoryComponent;
import com.product.post.dto.CategoryDto;
import com.product.post.dto.UserDto;

/**
 * Category related services.
 * 
 * @author yuvaraj
 *
 */
@Controller
@RequestMapping(value = "/category")
public class CategoryController {

	@Autowired
	CategoryComponent categoryComponent;

	/**
	 * Add new category.
	 * 
	 * @param categoryBo
	 * @return
	 */
	@PostMapping(value = "/save")
	@ResponseBody
	public ResponseEntity<CategoryDto> saveCategory(@RequestBody @Valid CategoryBo categoryBo) {
		checkUserAuthStatus();
		return new ResponseEntity<>(categoryComponent.saveCategory(categoryBo), HttpStatus.OK);
	}

	/**
	 * Update the category.
	 * 
	 * @param categoryBo
	 * @return
	 */
	@PutMapping(value = "/update")
	@ResponseBody
	public ResponseEntity<CategoryDto> updateCategory(@RequestBody @Valid CategoryBo categoryBo) {
		checkUserAuthStatus();
		return new ResponseEntity<>(categoryComponent.updateCategory(categoryBo), HttpStatus.OK);
	}

	/**
	 * Delete category by category id.
	 * 
	 * @param categoryId
	 * @return
	 */
	@DeleteMapping("/remove/{categoryId}")
	public ResponseEntity<?> removeUser(@PathVariable Long categoryId) {
		checkUserAuthStatus();
		return new ResponseEntity<>(categoryComponent.removeCategory(categoryId), HttpStatus.OK);
	}

	/**
	 * List all categories.
	 * 
	 * @return
	 */
	@GetMapping("/")
	public ResponseEntity<List<CategoryDto>> getCategories() {
		checkUserAuthStatus();
		return new ResponseEntity<>(categoryComponent.getCategories(), HttpStatus.OK);
	}

	/**
	 * Get category detail by category id.
	 * 
	 * @param categoryId
	 * @return
	 */
	@GetMapping("/details/{categoryId}")
	public ResponseEntity<CategoryDto> getCategory(@PathVariable Long categoryId) {
		checkUserAuthStatus();
		return new ResponseEntity<>(categoryComponent.getCategory(categoryId), HttpStatus.OK);
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
