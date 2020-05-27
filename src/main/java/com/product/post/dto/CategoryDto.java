/**
 * 
 */
package com.product.post.dto;


/**
 * @author yuvaraj
 *
 */
public class CategoryDto {
	
	private Long id;

	private String name;
	
	private int status;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
}
