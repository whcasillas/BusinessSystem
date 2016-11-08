package com.hisun.bean.menu;

import java.io.Serializable;

public class MenuBean implements Serializable{

	private String menu_id;
	private String parent_menu_id;
	private String menu_name;
	private String menu_url;
	private String depart_id;
	private String menu_level;
	
	public String getMenu_level() {
		return menu_level;
	}

	public void setMenu_level(String menu_level) {
		this.menu_level = menu_level;
	}

	public MenuBean(){}
	
	
	
	public MenuBean(String menu_id, String parent_menu_id, String menu_name,
			String menu_url, String depart_id, String menu_level) {
		super();
		this.menu_id = menu_id;
		this.parent_menu_id = parent_menu_id;
		this.menu_name = menu_name;
		this.menu_url = menu_url;
		this.depart_id = depart_id;
		this.menu_level = menu_level;
	}

	public String getMenu_id() {
		return menu_id;
	}
	public void setMenu_id(String menu_id) {
		this.menu_id = menu_id;
	}
	public String getParent_menu_id() {
		return parent_menu_id;
	}
	public void setParent_menu_id(String parent_menu_id) {
		this.parent_menu_id = parent_menu_id;
	}
	public String getMenu_name() {
		return menu_name;
	}
	public void setMenu_name(String menu_name) {
		this.menu_name = menu_name;
	}
	public String getMenu_url() {
		return menu_url;
	}
	public void setMenu_url(String menu_url) {
		this.menu_url = menu_url;
	}
	public String getDepart_id() {
		return depart_id;
	}
	public void setDepart_id(String depart_id) {
		this.depart_id = depart_id;
	}
	
	
}
