package com.lj.exam.model;

public class ExamSite {
	
		private int id;
		
		private String province;

		private String city;

		private String district;

		private String examSiteName;

		private String examSiteCode;

		private String examSiteSeat;
		
		public String getExamSiteSeat() {
			return examSiteSeat;
		}

		public void setExamSiteSeat(String examSiteSeat) {
			this.examSiteSeat = examSiteSeat;
		}

		private String invigilatorName;

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
		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
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

		public String getExamSiteName() {
			return examSiteName;
		}

		public void setExamSiteName(String examSiteName) {
			this.examSiteName = examSiteName;
		}

		public String getExamSiteCode() {
			return examSiteCode;
		}

		public void setExamSiteCode(String examSiteCode) {
			this.examSiteCode = examSiteCode;
		}

		public String getInvigilatorName() {
			return invigilatorName;
		}

		public void setInvigilatorName(String invigilatorName) {
			this.invigilatorName = invigilatorName;
		}

		public String getInvigilatorTel() {
			return invigilatorTel;
		}

		public void setInvigilatorTel(String invigilatorTel) {
			this.invigilatorTel = invigilatorTel;
		}
	
}
