package com.tyss.jpawithhibernate.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="movies")
public class Movies  implements Serializable{
	@Id
	@Column(name="mid")
 private int id;
	@Column(name = "mname")
 private String name;
	@Column
 private double ratings;
	@Column
 private String reviews;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public double getRatings() {
	return ratings;
}
public void setRatings(double ratings) {
	this.ratings = ratings;
}
public String getReviews() {
	return reviews;
}
public void setReviews(String reviews) {
	this.reviews = reviews;
	
	
}
@Override
public String toString() {
	return "Movies [id=" + id + ", name=" + name + ", ratings=" + ratings + ", reviews=" + reviews + ", getId()="
			+ getId() + ", getName()=" + getName() + ", getRatings()=" + getRatings() + ", getReviews()=" + getReviews()
			+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
}
 
}
