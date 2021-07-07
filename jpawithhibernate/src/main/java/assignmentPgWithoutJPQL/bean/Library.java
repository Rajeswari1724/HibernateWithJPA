package assignmentPgWithoutJPQL.bean;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.*;

@Entity
@Table(name="library_info")
public class Library{
	
	@Id
	@Column
	private int bid;
	
	@Column
	private String bname;
	
	@Column
	private String bauthor;
	
	@Column
	private double price;
	
	public int getBid() {
		return bid;
	}

	
	public void setBid(int bid) {
		this.bid = bid;
	}

	
	public String getBname() {
		return bname;
	}

	
	public void setBname(String bname) {
		this.bname = bname;
	}

	
	public String getBauthor() {
		return bauthor;
	}

	
	public void setBauthor(String bauthor) {
		this.bauthor = bauthor;
	}

	
	public double getPrice() {
		return price;
	}

	
	public void setPrice(double price) {
		this.price = price;
	}
	
	
	

}
