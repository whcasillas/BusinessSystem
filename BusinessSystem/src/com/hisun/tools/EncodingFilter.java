package com.hisun.tools;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

public class EncodingFilter implements Filter  {
	public void destroy() {     
		
	}       
	/**      * Select and set (if specified) the character encoding to be used to      * interpret request parameters for this request.      */    
	public void doFilter(ServletRequest request, ServletResponse response,  FilterChain chain) throws IOException, ServletException {         
		request.setCharacterEncoding("gbk");      
		response.setCharacterEncoding("gbk");
		response.setContentType("text/html;charset=gbk");
		chain.doFilter(request, response);     
	}       
	 
	
	public void init(FilterConfig filterConfig) throws ServletException {     
		
	} 
}
