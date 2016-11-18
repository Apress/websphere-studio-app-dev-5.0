package apress.wsad.techlib;

import java.rmi.*;
import javax.ejb.*;
import javax.naming.*;
import javax.rmi.*;
import java.rmi.*;
import java.util.*;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;


/**
*Description - BookRegister Front Controller
* 
* The Controller is the initial point of contact for handling a request.  
* Place in this class any services you would like to do on every request
* (Logging, Dubuging, Authentication...)
*/

   

public class BookRegisterController extends HttpServlet implements Serializable
{
	
	// Variable to keep the Book_catalog Home Interface
  	TechLibBook_catalogLocalHome catalogLocalHome;
  	TechLibBook_catalogLocal catalogLocal;
	InitialContext initContext; 
	
	
	
	/**************************************************************
	* Initializes the servlet
	* @param config The servlets configuration information
	*/
	public void init(ServletConfig config)
	        throws ServletException, EJBException
	{
		super.init(config);
		
		//Place code here to be done when the servlet is initialized
	  try
   	   { 	
		 initContext = new InitialContext();
   
         // caling the local reference of the Book_catalog entity bean 
    	 catalogLocalHome =
           (TechLibBook_catalogLocalHome) initContext.lookup("java:comp/env/Book_catalog");
       } 
  	  catch(Exception e)
   	   {
   		  System.out.println("Error locating Book_catalog LocalHome interface" + e.getMessage());
    
    	  throw new EJBException("Error registering a new book");  	
   		}	 
     
	}

	/***************************************************************
	* Destroy the Servlet
	*/
	public void destroy()
	{
		//Place code here to be done when the servlet is shutdown
	}

	/***************************************************************
	* This method is run once for each request.
	* @param request The incoming request information
	* @param response The outgoing response information
	*/
	public void performServices(HttpServletRequest request,
		                         HttpServletResponse response)
		              throws EJBException           
	{
		//Place any code here that you would like to run on every request
		//Logging, Authentication, Debugging...
		
		
  		String catalogNumber =  request.getParameter("catalogNumber");
  		String author        =  request.getParameter("author");
  		String bookTitle     =  request.getParameter("bookTitle");
  		String location      =  request.getParameter("location");
  		String platform      =  request.getParameter("platform");
  		String language      =  request.getParameter("language");
  
   
 		try
   		 { 
    		
   			catalogLocal =
      		catalogLocalHome.create(catalogNumber,
      		                        author,
      		                        bookTitle,
      		                        location,
      		                        platform,
      		                        language);
    
		    // If we are here. successfule result												            
  
  		 } 
  		catch(Exception e)
   		{
   		  System.out.println("Error locating ejb/Book_catalog Home interface" + e.getMessage());
    
    	  throw new EJBException("Error registering a new book");  	
   		}	
   
   
  }

	/***************************************************************
	* Process both HTTP GET and HTTP POST methods
	* @param request The incoming request information
	* @param response The outgoing response information
	*/
	public void performTask(
		HttpServletRequest request,
		HttpServletResponse response)
		throws ServletException, IOException
	{
		String nextPage;
		try
		{
			//Perform any specialized sevices
			performServices(request, response);

			//Get the web page associated with the command in the request
			nextPage = getInitParameter(request.getParameter("command"));

		}
		catch (Exception ex)
		{
			//If an exception is thrown serve the error page
			nextPage = getInitParameter("error_page");
		}

		//Forward the request to the next page
		dispatch(request, response, nextPage);
	}

	/***************************************************************
	* Process incoming requests for a HTTP GET method
	* @param request The incoming request information
	* @param response The outgoing response information
	*/
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException
	{
		performTask(request, response);
	}

	/***************************************************************
	* Process incoming requests for a HTTP POST method
	* @param request The incoming request information
	* @param response The outgoing response information
	*/
	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException
	{
		performTask(request, response);
	}

	/****************************************************************
	* Dispatches to the next page
	* @param request The incoming request information
	* @param response The outgoing response information
	* @param nextPage The page to dispatch to 
	*/
	public void dispatch(
		HttpServletRequest request,
		HttpServletResponse response,
		String nextPage)
		throws ServletException, IOException
	{
		RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);
		dispatch.forward(request, response);
	}
}
