package com.hisun.bean.jinjishijian;


public class Jjsjzx {
	    private String jj_id;   
		private String sj_id;   
		private String sj_type;
		private String sj_title;
		private String tm_smp; 
		private int cb_num;  
	    private int cl_sts;
	    private String opt_name;
	    private String cl_smp;
	    
		public String getJj_id() {
			return jj_id;
		}
		public void setJj_id(String jj_id) {
			this.jj_id = jj_id;
		}
		public String getSj_id() {
			return sj_id;
		}
		public void setSj_id(String sj_id) {
			this.sj_id = sj_id;
		}
		public String getSj_type() {
			return sj_type;
		}
		public void setSj_type(String sj_type) {
			this.sj_type = sj_type;
		}
		public String getSj_title() {
			return sj_title;
		}
		public void setSj_title(String sj_title) {
			this.sj_title = sj_title;
		}
		public String getTm_smp() {
			return tm_smp;
		}
		public void setTm_smp(String tm_smp) {
			this.tm_smp = tm_smp;
		}
		public int getCb_num() {
			return cb_num;
		}
		public void setCb_num(int cb_num) {
			this.cb_num = cb_num;
		}
		public int getCl_sts() {
			return cl_sts;
		}
		public void setCl_sts(int cl_sts) {
			this.cl_sts = cl_sts;
		}
	
		public Jjsjzx() {
		
		}
		
		public String getOpt_name() {
			return opt_name;
		}
		public void setOpt_name(String opt_name) {
			this.opt_name = opt_name;
		}
		public String getCl_smp() {
			return cl_smp;
		}
		public void setCl_smp(String cl_smp) {
			this.cl_smp = cl_smp;
		}
		@Override
		public String toString() {
			return "Jjsjzx [jj_id=" + jj_id + ", sj_id=" + sj_id + ", sj_type="
					+ sj_type + ", sj_title=" + sj_title + ", tm_smp=" + tm_smp
					+ ", cb_num=" + cb_num + ", cl_sts=" + cl_sts
					+ ", opt_name=" + opt_name + ", cl_smp=" + cl_smp + "]";
		}
		public Jjsjzx(String jj_id, String sj_id, String sj_type,
				String sj_title, String tm_smp, int cb_num, int cl_sts,
				String opt_name, String cl_smp) {
			super();
			this.jj_id = jj_id;
			this.sj_id = sj_id;
			this.sj_type = sj_type;
			this.sj_title = sj_title;
			this.tm_smp = tm_smp;
			this.cb_num = cb_num;
			this.cl_sts = cl_sts;
			this.opt_name = opt_name;
			this.cl_smp = cl_smp;
		}
	    
		
	
		
		
		
}
