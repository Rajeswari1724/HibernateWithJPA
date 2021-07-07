package OnlineMappingOneToMany;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

import lombok.Data;
import lombok.ToString.Exclude;
@Data
@Entity
@Table(name="item_info")
public class Item implements Serializable {
	@Id
	@Column
 private int iid;
	@Column
 private String iname;
	
	@Exclude
	@JoinColumn (name = "cid")
	@ManyToOne(cascade = CascadeType.ALL)
	 private Cart cart;
	
 
}
