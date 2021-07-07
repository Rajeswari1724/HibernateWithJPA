package mappingProjectAnother;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import mappingprojectOneToOne.Employe;
@Data
@Entity
@Table(name="system_info")
public class System_info implements Serializable {
	
	@Id
	@Column
private int sid;
	@Column
private String sname;
	

	
	

}
