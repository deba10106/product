package backend.model;

import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "products")
@NoArgsConstructor
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	private String description;
    private String category;
    private Integer price;
    private String status;
    private ZonedDateTime expiryDateTime;
    
    @Column(name="created_by")
    private String createdBy;
    
    @Column(name="created_dt")
    private ZonedDateTime createdDate;
    
    @Column(name="last_updated_by")
    private String lastUpdatedBy;
    
    @Column(name="last_updated_dt")
    private ZonedDateTime lastUpdatedDate;
    
    @PrePersist
    private void prePersist() {
        if (createdDate == null) {
        	createdDate = ZonedDateTime.now();
        }
        if (lastUpdatedDate == null) {
        	lastUpdatedDate = ZonedDateTime.now();
        }
    }

    @PreUpdate
    public void preUpdate() {
        if (lastUpdatedDate == null) {
        	lastUpdatedDate = ZonedDateTime.now();
        }
    }
	
}
