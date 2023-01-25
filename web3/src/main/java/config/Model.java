package config;

import javax.servlet.http.HttpServletRequest;

public class Model {

	private HttpServletRequest request;
	
	public Model(HttpServletRequest request) {
		this.request = request;
	}
	

	public void addAttribute(String key, Object value) {
		request.setAttribute(key, value);
	}
}
