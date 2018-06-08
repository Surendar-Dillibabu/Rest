package com.cico.rest.services;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.Provider;
import com.cico.rest.model.CicoEvents;
import com.cico.rest.model.EventProcess;
import com.cico.rest.model.EventType;
import com.cico.rest.model.IssuePriority;
import com.cico.rest.model.UserInfoView;
import com.sun.jersey.spi.inject.Inject;

@Path("/event")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Provider
public class CicoEventServiceImpl {
  
  @Inject
  private CicoEventServiceDAO cicoEventServiceDAO;	
  
  @Context 
  HttpServletRequest request;  
  
  @GET
  @Path("/getProcessList")
  public List<EventProcess> getProcessList() {
    return cicoEventServiceDAO.getProcessListFromFile();	
  }
  
  @GET
  @Path("/getEventTypeList")
  public List<EventType> getEventTypeList() {	
    return cicoEventServiceDAO.getEventTypeListFromFile();	
  }
  
  @GET
  @Path("/getIssuePriorityList")
  public List<IssuePriority> getIssuePriorityList() {	
    return cicoEventServiceDAO.getIssuePrioityListFromFile();	
  }
  
  @POST
  @Path("/addEvent")
  public String addCicoEvent(CicoEvents cicoEvents){	
	return cicoEventServiceDAO.addCicoEventInFile(cicoEvents);
  }
  
  @GET
  @Path("/getAllEvents")
  public List<CicoEvents> getAllCicoEvents() {	
    return cicoEventServiceDAO.getAllCicoEventFromFile();	
  }
  
  @GET
  @Path("/{id}/getEvent")
  public CicoEvents getCicoEventById(@PathParam("id") int eventId){	
	return cicoEventServiceDAO.getCicoEventByIdFromFile(eventId);
  }

  @POST
  @Path("/modifyEvent")
  public String modifyCicoEvent(CicoEvents cicoEvents) {		
	return cicoEventServiceDAO.modifyCicoEvent(cicoEvents);
  }
  
  @GET
  @Path("/userInfo")
  public UserInfoView getUserDetails() {
	HttpSession session = request.getSession();
	UserInfoView userInfoView = (UserInfoView) session.getAttribute("userInfo");
	System.out.println("userInfoView :"+userInfoView);
	return userInfoView;	
  }
  
}
