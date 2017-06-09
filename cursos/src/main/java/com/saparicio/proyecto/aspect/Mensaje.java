package com.saparicio.proyecto.aspect;

import java.io.Serializable;

public class Mensaje implements Serializable {

	public static final String MSG_TYPE_SUCCESS="alert alert-success alert-dismissible";
	public static final String MSG_TYPE_INFO="alert alert-info alert-dismissible";
	public static final String MSG_TYPE_WARNING="alert alert-warning alert-dismissible";
	public static final String MSG_TYPE_DANGER="alert alert-danger alert-dismissible";
   
	private static final long serialVersionUID = 5079236020946434768L;
	
	String msg;  // literal del mensaje
	String type; // tipo de mensaje
	int  code; // codigo http
	
	
	
	public Mensaje(final String msg) {
		super();
		this.msg = msg;
		this.type = MSG_TYPE_SUCCESS;
	}
	
	
	public Mensaje(final String msg,final String type) {
		super();
		this.type = type;
		this.msg=msg;
	}
	


	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}

	

	@Override
	public String toString() {
		return "Mensaje [msg=" + msg + ", type=" + type + ", code=" + code + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + code;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mensaje other = (Mensaje) obj;
		if (code != other.code)
			return false;
		return true;
	}
	
	
	
}
