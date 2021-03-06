package com.lj.exam.dal.dataobject;

// auto generated imports

/**
 * A data object class directly models database table <tt>examine_room</tt>.
 *
 * This file is generated by <tt>financenet-dalgen</tt>, a DAL (Data Access Layer)
 * code generation utility specially developed for <tt>iwallet</tt> project.
 * 
 * PLEASE DO NOT MODIFY THIS FILE MANUALLY, or else your modification may
 * be OVERWRITTEN by someone else. To modify the file, you should go to 
 * directory <tt>(project-home)/biz/dal/src/conf/dalgen</tt>, and 
 * find the corresponding configuration file (<tt>tables/examine_room.xml</tt>). 
 * Modify the configuration file according to your needs, then run <tt>financenet-dalgen</tt> 
 * to generate this file.
 *
 */
public class ExamSiteDO {
    
    //========== properties ==========

	/**
	 * This property corresponds to db column <tt>id</tt>.
	 */
	private int id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * This property corresponds to db column <tt>Province</tt>.
	 */
	private String province;

	/**
	 * This property corresponds to db column <tt>City</tt>.
	 */
	private String city;

	/**
	 * This property corresponds to db column <tt>District</tt>.
	 */
	private String district;

	/**
	 * This property corresponds to db column <tt>ExamineSite_Name</tt>.
	 */
	private String examSiteName;

	/**
	 * This property corresponds to db column <tt>ExamineSite_Code</tt>.
	 */
	private String examSiteCode;

	private String examSiteSeat;
	
	public String getExamSiteSeat() {
		return examSiteSeat;
	}

	public void setExamSiteSeat(String examSiteSeat) {
		this.examSiteSeat = examSiteSeat;
	}

	/**
	 * This property corresponds to db column <tt>Invigilator_Name</tt>.
	 */
	private String invigilatorName;

	/**
	 * This property corresponds to db column <tt>Invigilator_Tel</tt>.
	 */
	private String invigilatorTel;
	
	private String examAddress;
	
	private String companyName;

    public String getExamAddress() {
		return examAddress;
	}

	public void setExamAddress(String examAddress) {
		this.examAddress = examAddress;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	/**
     * Getter method for property <tt>province</tt>.
     *
     * @return property value of province
     */
	public String getProvince() {
		return province;
	}
	
	/**
	 * Setter method for property <tt>province</tt>.
	 * 
	 * @param province value to be assigned to property province
     */
	public void setProvince(String province) {
		this.province = province;
	}

    /**
     * Getter method for property <tt>city</tt>.
     *
     * @return property value of city
     */
	public String getCity() {
		return city;
	}
	
	/**
	 * Setter method for property <tt>city</tt>.
	 * 
	 * @param city value to be assigned to property city
     */
	public void setCity(String city) {
		this.city = city;
	}

    /**
     * Getter method for property <tt>district</tt>.
     *
     * @return property value of district
     */
	public String getDistrict() {
		return district;
	}
	
	/**
	 * Setter method for property <tt>district</tt>.
	 * 
	 * @param district value to be assigned to property district
     */
	public void setDistrict(String district) {
		this.district = district;
	}

    /**
     * Getter method for property <tt>examineSiteName</tt>.
     *
     * @return property value of examineSiteName
     */
	public String getExamSiteName() {
		return examSiteName;
	}
	
	/**
	 * Setter method for property <tt>examineSiteName</tt>.
	 * 
	 * @param examineSiteName value to be assigned to property examineSiteName
     */
	public void setExamSiteName(String examSiteName) {
		this.examSiteName = examSiteName;
	}

    /**
     * Getter method for property <tt>examineSiteCode</tt>.
     *
     * @return property value of examineSiteCode
     */
	public String getExamSiteCode() {
		return examSiteCode;
	}
	
	/**
	 * Setter method for property <tt>examineSiteCode</tt>.
	 * 
	 * @param examineSiteCode value to be assigned to property examineSiteCode
     */
	public void setExamSiteCode(String examSiteCode) {
		this.examSiteCode = examSiteCode;
	}

    /**
     * Getter method for property <tt>invigilatorName</tt>.
     *
     * @return property value of invigilatorName
     */
	public String getInvigilatorName() {
		return invigilatorName;
	}
	
	/**
	 * Setter method for property <tt>invigilatorName</tt>.
	 * 
	 * @param invigilatorName value to be assigned to property invigilatorName
     */
	public void setInvigilatorName(String invigilatorName) {
		this.invigilatorName = invigilatorName;
	}

    /**
     * Getter method for property <tt>invigilatorTel</tt>.
     *
     * @return property value of invigilatorTel
     */
	public String getInvigilatorTel() {
		return invigilatorTel;
	}
	
	/**
	 * Setter method for property <tt>invigilatorTel</tt>.
	 * 
	 * @param invigilatorTel value to be assigned to property invigilatorTel
     */
	public void setInvigilatorTel(String invigilatorTel) {
		this.invigilatorTel = invigilatorTel;
	}
}
