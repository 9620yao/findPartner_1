package com.yc.ssm.entity;

import java.io.Serializable;

/**
 * 个人信息
 * 
 * @author 李文文，苏利
 *
 */
public class Users implements Serializable {

	private static final long serialVersionUID = 1L;
	private String uid;
	private String ulid;
	private String nickname;
	private String age;
	private String birthday;
	private String photo;
	private String star;
	private String hobby;
	private String job;
	private String company;
	private String school;
	private String address;
	private String hometown;
	private String picture;
	private String astate;
	private Login login;

	public Users() {

	}

	public Users(String uid, String ulid, String nickname, String age, String birthday, String photo, String star,
			String hobby, String job, String company, String school, String address, String hometown, String picture,
			String astate, Login login) {
		this.uid = uid;
		this.ulid = ulid;
		this.nickname = nickname;
		this.age = age;
		this.birthday = birthday;
		this.photo = photo;
		this.star = star;
		this.hobby = hobby;
		this.job = job;
		this.company = company;
		this.school = school;
		this.address = address;
		this.hometown = hometown;
		this.picture = picture;
		this.astate = astate;
		this.login = login;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getUlid() {
		return ulid;
	}

	public void setUlid(String ulid) {
		this.ulid = ulid;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getStar() {
		return star;
	}

	public void setStar(String star) {
		this.star = star;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getHometown() {
		return hometown;
	}

	public void setHometown(String hometown) {
		this.hometown = hometown;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getAstate() {
		return astate;
	}

	public void setAstate(String astate) {
		this.astate = astate;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "\nUsers [uid=" + uid + ", ulid=" + ulid + ", nickname=" + nickname + ", age=" + age + ", birthday="
				+ birthday + ", photo=" + photo + ", star=" + star + ", hobby=" + hobby + ", job=" + job + ", company="
				+ company + ", school=" + school + ", address=" + address + ", hometown=" + hometown + ", picture="
				+ picture + ", astate=" + astate + ", login=" + login + "]";
	}

}
