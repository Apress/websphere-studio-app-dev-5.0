package apress.wsad.techlib;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * @version 	1.0
 * @author
 */
public class BookByPlatformController extends HttpServlet
{

	/**
	* @see javax.servlet.http.HttpServlet#void (javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	*/
	public void doDelete(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException
	{

	}

	/**
	* @see javax.servlet.http.HttpServlet#void (javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	*/
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException
	{
     performTask(req, resp);
	}

	/**
	* @see javax.servlet.http.HttpServlet#void (javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	*/
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException
	{
     performTask(req, resp);
	}

	/**
	* @see javax.servlet.GenericServlet#void ()
	*/
	public void init() throws ServletException
	{
		super.init();
	}


    public void performTask(HttpServletRequest request,
                         HttpServletResponse response)
                 throws ServletException, IOException
     {
      String nextPage;
            
      try
       {
       	HttpSession session = request.getSession(true); 
       	
         // Prepare invocation of the jsp module BookByPlatformOutputForm.jsp 
         nextPage = "/BookByPlatformOutputForm.jsp";
       }
      catch (Exception ex)
       {
         //If an exception is thrown, serve the error page
        nextPage = getInitParameter("error_page");
        }
        
      //Forward the request to the next page
      dispatch(request, response, nextPage);
   
   
     }


    public void dispatch(HttpServletRequest request,
                      HttpServletResponse response,
                      String nextPage)
                                    throws ServletException, IOException
     {
      RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);
      dispatch.forward(request, response);
     }


}
