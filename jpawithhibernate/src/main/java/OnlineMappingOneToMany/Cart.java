package OnlineMappingOneToMany;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString.Exclude;;
@Data
@Entity
@Table(name = "cart_info")
class Cart implements Serializable {
	@Id
	@Column
   private int cid;
	
@Column
 private String cname;

@Exclude
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "cart")
	 private List<Item> items;
   
   
}
