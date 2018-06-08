package com.cico.rest.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.cico.rest.model.UserInfoView;

public class AuthenticationFilter implements Filter {
  
  protected FilterConfig filterConfig;
  
  @Override
  public void init(final FilterConfig filterConfig) throws ServletException {
	this.filterConfig = filterConfig;
  }

  @Override
  public void destroy() {
	// TODO Auto-generated method stub
  }

  @Override
  public void doFilter(ServletRequest req, ServletResponse resp,
		FilterChain chain) throws IOException, ServletException {
	System.out.println("Inside AuthenticationFilter doFilter method");
	final HttpServletRequest hrequest = (HttpServletRequest) req;
	final HttpServletResponse hresponse = (HttpServletResponse) resp;
	final HttpSession httpSession = hrequest.getSession();
	
	try {
	  if (httpSession.getAttribute("user") == null) {
		System.out.println("User is not present in session");
		System.out.println( "Remote User:"+hrequest.getRemoteUser());	    
       
		UserInfoView userInfoView = new UserInfoView();		 
		userInfoView.setUserCode("GBS04543");
		userInfoView.setEmailAddress("surendar.d@sella.it");
		userInfoView.setClientIpAddress("10.54.54.48");
		userInfoView.setName("Surendar");
		
		System.out.println("userInfoView : "+userInfoView);	    
	    httpSession.setAttribute("userInfo", userInfoView);
	  }
	  chain.doFilter(hrequest, hresponse);
	} catch (final Exception ex) {
	  System.out.println(ex.getMessage());	  
	}
	
  }
  
  /* As of now the below method is not used
  private void forwardToNoAuthPage(final HttpServletRequest hrequest, final HttpServletResponse hresponse, final String jspPage) throws ServletException, IOException {
	logger.debug("Forwarding to ", jspPage);
	final RequestDispatcher dispatcher = hrequest.getRequestDispatcher(jspPage);
	dispatcher.forward(hrequest, hresponse);
  }
  */

}