package backend.model;

import java.io.Serializable;
import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseModel implements Serializable{

	private static final long serialVersionUID = 1L;

		@Column(name="created_at")
	    private ZonedDateTime createdAt;
	    
	    @Column(name="updated_at")
	    private ZonedDateTime updatedAt;
	    
	    @Column(name="is_deleted")
	    private Boolean isDeleted = false;
	    
	   
	    @PrePersist
	    private void prePersist() {
	        if (createdAt == null) {
	        	createdAt = ZonedDateTime.now();
	        }
	        if (updatedAt == null) {
	        	updatedAt = ZonedDateTime.now();
	        }
	    }

	    @PreUpdate
	    public void preUpdate() {
	        if (updatedAt == null) {
	        	updatedAt = ZonedDateTime.now();
	        }
	    }
}
