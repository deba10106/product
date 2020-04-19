package backend.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter

public class TransactionDTO {



	private String created_by;
	private Date created_dt;
	private String last_updated_by;
	private Date last_updated_dt;



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
