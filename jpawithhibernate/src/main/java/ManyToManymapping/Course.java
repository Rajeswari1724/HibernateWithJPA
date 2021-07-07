package ManyToManymapping;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString.Exclude;

@Data
@Entity
@Table(name="course_info")
public class Course implements Serializable {
	
	@Column
	@Id
	private int cid;
	
	@Column
	private String cname;
	
	@Exclude
	@ManyToMany(cascade=CascadeType.ALL, mappedBy="course")
	private List<Student> student;
	
	
}
