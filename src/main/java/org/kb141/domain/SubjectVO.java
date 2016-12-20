package org.kb141.domain;

// copyright ju young
public class SubjectVO {
	
		private Integer subno;
		private String subname;
		private String subgrade;
		
		
		public Integer getSubno() {
			return subno;
		}
		public void setSubno(Integer subno) {
			this.subno = subno;
		}
		public String getSubname() {
			return subname;
		}
		public void setSubname(String subname) {
			this.subname = subname;
		}
		public String getSubgrade() {
			return subgrade;
		}
		public void setSubgrade(String subgrade) {
			this.subgrade = subgrade;
		}
		@Override
		public String toString() {
			return "SubjectVO [subno=" + subno + ", subname=" + subname + ", subgrade=" + subgrade + "]";
		}
		
		
		
	
	

}
