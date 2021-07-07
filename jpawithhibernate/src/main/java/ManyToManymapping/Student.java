package ManyToManymapping;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString.Exclude;

@Data
@Entity
@Table(name="student_info")
public class Student implements Serializable{
	
	@Column
	@Id
	private int sid;
	
	@Column
	private String sname;
	
	@Exclude
	@JoinTable(name="coures_student_info", joinColumns=@JoinColumn(name="sid"),inverseJoinColumns= @JoinColumn(name="cid"))//why separate table doubt
	@ManyToMany(cascade=CascadeType.ALL)
	private List<Course> course;

}
