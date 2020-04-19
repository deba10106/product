package backend.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter

public class ProductDTO {


	private String name;
	private String description;
	private String category;
	private Integer price;
	private String status;
	private Date expiry_dt;
	private  String created_by;
	private Date created_dt;
	private String last_updated_by;
	private Date last_updated_dt;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getExpiryDate() {
		return expiry_dt;
	}
	public void setExpiryDate(Date expiry_dt) {
		this.expiry_dt = expiry_dt;
	}
	public String getCreatedBy() {
		return created_by;
	}
	public void setCreatedBy(String created_by) {
		this.created_by = created_by;
	}
	public Date getCreatedDate() {
		return created_dt;
	}
	public void setCreatedDate(Date created_dt) {
		this.created_dt = created_dt;
	}
	public String getLastUpdateBy() {
		return last_updated_by;
	}
	public void setLastUpdateBy(String last_updated_by) {
		this.last_updated_by = last_updated_by;
	}
	public Date getLastUpdateDate() {
		return last_updated_dt;
	}
	public void setLastUpdateDate(Date last_updated_dt) {
		this.last_updated_dt = last_updated_dt;
	}
	
	
}
