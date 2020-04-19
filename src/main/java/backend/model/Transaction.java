package backend.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "transactions")
@NoArgsConstructor
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long buyer_id;
	private Long seller_id;
	private Long product_id;
    private  String created_by;
    private Date created_dt;
    private String last_updated_by;
    private Date last_updated_dt;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getBuyer_idId() {
		return id;
	}
	public void setBuyer_idId(Long id) {
		this.id = id;
	}
	public Long getSeller_idId() {
		return id;
	}
	public void setSeller_idId(Long id) {
		this.id = id;
	}
	public Long getProduct_idId() {
		return id;
	}
	public void setProduct_idId(Long id) {
		this.id = id;
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
