package mappingManytoOne;

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
@Table(name="car_info")
public class Cars {
	@Id
	@Column
private int cid;
	@Column
private String cname;
	@Exclude
	@JoinColumn(name="pid")
	@ManyToOne(cascade = CascadeType.ALL)
	private Person person;


}
