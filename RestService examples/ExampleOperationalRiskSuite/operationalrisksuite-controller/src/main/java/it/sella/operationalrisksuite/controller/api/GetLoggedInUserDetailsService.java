package it.sella.operationalrisksuite.controller.api;

import it.sella.operationalrisksuite.core.view.UserInfoView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.Provider;

@Path("/user")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Provider
public class GetLoggedInUserDetailsService {
  
  @Context 
  HttpServletRequest request;
  
  @GET
  @Path("/details")
  public UserInfoView getUserDetails() {
	System.out.println("Inside getUserDetails rest method");
	HttpSession httpSession = request.getSession();
	UserInfoView userInfoView = (UserInfoView) httpSession.getAttribute("userInfo");
	System.out.println("userInfoView :"+userInfoView);
	return userInfoView;
  }

}
