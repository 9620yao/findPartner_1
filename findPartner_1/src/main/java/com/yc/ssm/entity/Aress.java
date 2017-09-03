package com.yc.ssm.entity;

import java.io.Serializable;

/**
 * 存放地址信息
 * 
 * @author 姚秋林
 *
 */
public class Aress implements Serializable {

	private static final long serialVersionUID = 1L;
	private int asid;
	private String province;// 省
	private String city;// 市
	private String district;// 区

	public Aress() {
	}

	public Aress(String province, String city, String district) {
		this.province = province;
		this.city = city;
		this.district = district;
	}

	public int getAsid() {
		return asid;
	}

	public void setAsid(int asid) {
		this.asid = asid;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	@Override
	public String toString() {
		return "\nAress [asid=" + asid + ", province=" + province + ", city=" + city + ", district=" + district + "]";
	}

}
