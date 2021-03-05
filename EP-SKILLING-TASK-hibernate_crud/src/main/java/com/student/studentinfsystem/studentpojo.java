package com.student.studentinfsystem;

import javax.persistence.*;
@Entity
@Table
public class studentpojo 
{
	@Id
	private int sregno;
	@Column
	private String name;
	@Column
	private String dob;
	@Column
	private String email;
	@Column
	private String address;
	@Column
	private String course;
	public int getSregno() {
		return sregno;
	}
	public void setSregno(int sregno) {
		this.sregno = sregno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	@Override
	public String toString() {
		return "studentpojo [sregno=" + sregno + ", name=" + name + ", dob=" + dob + ", email=" + email + ", address="
				+ address + ", course=" + course + "]";
	}
	

}
