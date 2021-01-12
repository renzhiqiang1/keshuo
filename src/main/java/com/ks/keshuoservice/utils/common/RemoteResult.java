package com.ks.keshuoservice.utils.common;

import java.io.Serializable;

public class RemoteResult implements Serializable {
	private static final long serialVersionUID = 2588163462392220979L;
	public static final int NO_ERROR_CODE = -1;
	private boolean success;// 业务流是否正常
	private Object data;// 操作结果数据
	private int code;// 备用
	private String message;// 错误信息
	private String errorExportByte;//异常数据导出文件

	public RemoteResult(Object data) {
		this(true, -1, null, data);
	}

	public RemoteResult(Throwable t) {
		this(false, 200, t.getMessage(), null);
	}

	public RemoteResult(boolean success, int code, String message) {
		this(success, code, message, null);
	}

	public RemoteResult(boolean success, int code, String message, Object data) {
		this.success = success;
		this.code = code;
		this.message = message;
		this.data = data;
	}
	
	public RemoteResult(boolean success, int code, String message, Object data, String newErrExportByte) {
		this.success = success;
		this.code = code;
		this.message = message;
		this.data = data;
		this.errorExportByte=newErrExportByte;
	}

	public boolean isSuccess() {
		return this.success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public Object getData() {
		return this.data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public int getCode() {
		return this.code;
	}

	public String getErrorExportByte() {
		return errorExportByte;
	}

	public void setErrorExportByte(String errorExportByte) {
		this.errorExportByte = errorExportByte;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}