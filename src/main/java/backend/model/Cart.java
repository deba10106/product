package backend.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
@Table(name = "Carts")
public class Cart extends BaseModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private long userId;
	
	@ManyToMany(mappedBy="carts", cascade = CascadeType.ALL)
	private Set <Product> products = new HashSet<>();
	
	public void removeProduct(Product product) {
		this.products.remove(product);
		product.getCarts().remove(this);
	}
}
