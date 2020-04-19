package backend.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter

public class ReviewDTO {

	private Long user_id;
	private Integer star_rating;
	private String remarks;
	private String created_by;
	private Date created_dt;
	private String last_updated_by;
	private Date last_updated_dt;

	public Long getUser_id() {
		return user_id;
	}
	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}

	public Integer getStar_rating() {
		return star_rating;
	}
	public void setStar_rating(Integer star_rating) {
		this.star_rating = star_rating;
	}

	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
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
