package com.tyss.jpawithhibernate.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="employee")
public class Employee implements Serializable {
@Id 
@Column
private int eid;
@Column
private String ename;
@Column
private double esal;
@Column
private String eloc;
public int getEid() {
	return eid;
}
public void setEid(int eid) {
	this.eid = eid;
}
public String getEname() {
	return ename;
}
public void setEname(String ename) {
	this.ename = ename;
}
public double getEsal() {
	return esal;
}
public void setEsal(double esal) {
	this.esal = esal;
}
public String getEloc() {
	return eloc;
}
public void setEloc(String eloc) {
	this.eloc = eloc;
}
@Override
public String toString() {
	return "Employee [eid=" + eid + ", ename=" + ename + ", esal=" + esal + ", eloc=" + eloc + ", getEid()=" + getEid()
			+ ", getEname()=" + getEname() + ", getEsal()=" + getEsal() + ", getEloc()=" + getEloc() + ", getClass()="
			+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
}

}
