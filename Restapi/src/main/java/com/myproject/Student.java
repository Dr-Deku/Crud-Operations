package com.myproject;



import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Student")
public class Student {
	@Id
	@Column(name="STUDENT_NO")
	 int sid;
	@Column(name="STUDENT_NAME")
	 String sname;
	@Column(name="STUDENT_DOB")
	 Date sdob;
	@Column(name="STUDENT_DOJ")
	 Date sdoj;
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public Date getSdob() {
		return sdob;
	}
	public void setSdob(Date sdob) {
		this.sdob = sdob;
	}
	public Date getSdoj() {
		return sdoj;
	}
	public void setSdoj(Date sdoj) {
		this.sdoj = sdoj;
	}
	
	public Student() {
		
	}
	
	
	public Student(int sid,String sname,Date sdob,Date sdoj) {
		this.sid=sid;
		this.sname=sname;
		this.sdob=sdob;
		this.sdoj=sdoj;
	}
}
