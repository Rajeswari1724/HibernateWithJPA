package mappingManytoOne;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString.Exclude;
@Data
@Entity
@Table(name = "person_info")
public class Person {
	@Id
	@Column
	private int pid;
	@Column
	private String pname;
	@Exclude
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "person")
	private List<Cars> car;

}
