package mappingprojectOneToOne;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import mappingProjectAnother.System_info;

@Data
@Entity
@Table(name="employe_info")
public class Employe implements Serializable {
	
	@Id
	@Column
private int mid;
	
	@Column
private String mname;
	
	@OneToOne(cascade = CascadeType.ALL)
private System_info system_info;

		

}
