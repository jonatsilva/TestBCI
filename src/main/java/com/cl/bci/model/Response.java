package com.cl.bci.model;

import java.io.Serializable;

public class Response implements Serializable {

	private static final long serialVersionUID = 7853171827678447570L;

	private int uuid;
	private String created;
	private String modified;
	private String ast_login;
	private String token;
	private String isactive;

	public int getUuid() {
		return uuid;
	}

	public void setUuid(int uuid) {
		this.uuid = uuid;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public String getModified() {
		return modified;
	}

	public void setModified(String modified) {
		this.modified = modified;
	}

	public String getAst_login() {
		return ast_login;
	}

	public void setAst_login(String ast_login) {
		this.ast_login = ast_login;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getIsactive() {
		return isactive;
	}

	public void setIsactive(String isactive) {
		this.isactive = isactive;
	}

}
