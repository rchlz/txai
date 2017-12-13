package cn.sinapp.txai.domain;

public class ApiResult<T> {
	
	private int ret;
	
	private String msg;
	
	private T data;

	public int getRet() {
		return ret;
	}

	public void setRet(int ret) {
		this.ret = ret;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "ApiResult [ret=" + ret + ", msg=" + msg + ", data=" + data
				+ "]";
	}
	
	

}
