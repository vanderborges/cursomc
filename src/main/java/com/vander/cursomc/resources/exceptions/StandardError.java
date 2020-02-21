package com.vander.cursomc.resources.exceptions;

import java.io.Serializable;

public class StandardError implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Integer status;
	private String msg;
	private Long timesTemp;
	
	public StandardError(Integer status, String msg, Long timesTemp) {
		super();
		this.status = status;
		this.msg = msg;
		this.timesTemp = timesTemp;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Long getTimesTemp() {
		return timesTemp;
	}

	public void setTimesTemp(Long timesTemp) {
		this.timesTemp = timesTemp;
	}
	
	
	

}
