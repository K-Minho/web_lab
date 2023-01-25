package config;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

public class MessageConverter {
	
	public static void converter(String viewName, HttpServletResponse resp) throws Exception {
		resp.setHeader("Content-type", "text/html; charset=utf-8");
		PrintWriter pw = resp.getWriter();
		pw.println(viewName);
	}
}
