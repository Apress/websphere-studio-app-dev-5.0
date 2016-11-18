package apress.wsad.techlib;

import javax.ejb.*;
import javax.naming.*;
import javax.rmi.*;
import java.rmi.*;
import java.lang.*;
import java.util.*;
import apress.wsad.techlib.TransportBean;


public class TechLibFacade1Bean implements javax.ejb.SessionBean
{
	private javax.ejb.SessionContext mySessionCtx;
	
	// Variable to keep the Home Local refernce to TechLibBook_catalog object
	private TechLibBook_catalogLocalHome catalogLocalHome = null;
    
    // Variable to keep the Home Local refernce to TechLibBook_activity object
    private TechLibBook_activityLocalHome activityLocalHome = null; 

    // Helper method to get the LocalInterface of the Book_catalog entity bean.
 	private TechLibBook_catalogLocalHome getCatalogLocalHome()
 	 throws RemoteException
  	{
  	    
        try
         {
           if (catalogLocalHome == null)
            {
         	
             InitialContext initContext = new InitialContext();
          
             Object objRef =
                initContext.lookup("java:comp/env/Book_catalog");
                             
             catalogLocalHome = (TechLibBook_catalogLocalHome) objRef;       
          
             return (TechLibBook_catalogLocalHome) objRef;
              
            }
           else    
            {
             return catalogLocalHome;	
            }	
        
         }             
        
        catch (NamingException ne)
         {
          System.out.println("Error locating TechLibBook_catalogLocalHome: " + ne.getMessage());
                                               
          throw
            new RemoteException("Error locating TechLibBook_catalogLocalHome: " + ne.getMessage());
         } 
           	
   }	

  // Helper method to get the LocalInterface of the Book_activity entity bean.
  private TechLibBook_activityLocalHome getActivityLocalHome()
 	 throws RemoteException
  	{
        try
         {
           if (activityLocalHome == null)
            {
         	
             InitialContext initContext = new InitialContext();
          
             Object objRef =
                initContext.lookup("java:comp/env/Book_activity");
                
             activityLocalHome = (TechLibBook_activityLocalHome) objRef;       
          
             return (TechLibBook_activityLocalHome) objRef;
              
            }
           else    
            {
             return activityLocalHome;	
            }	
        
         }             
        
        catch (NamingException ne)
         {
          System.out.println("Error locating TechLibBook_activityLocalHome: " + ne.getMessage());
            throw new
               RemoteException("Error locating  TechLibBook_activityLocalHome: " + ne.getMessage());
         } 
   }	

 
 // Business helper method. Must be promoted to the local interface
  public void initStateVariables()
     throws FinderException
   {
    try
     {
      // Calculate catalogLocalHome and activityLocalHome variables
      getCatalogLocalHome();
      getActivityLocalHome();
     	
     
      } // End of try	 
     
     catch(Exception e)
      {
        System.out.println("Error executing findByPlatform WITHIN getBookByPlatform:" +
                                                                           e.getMessage());
                                               
        throw
          new EJBException("Error executing findByPlatform WITHIN getBookByPlatform:" +
                                                                           e.getMessage());
      }
            	
  }	  
  

 
  // Business method
  public Vector getBookForPlatform(String workPlatform)
     throws FinderException
   {
    Vector bookVector = new Vector();
  	
    TransportBean transObject;
    TechLibBook_catalogLocal bookCatalogLocal = null; 
    Collection         collBookRecords;
    try
     {
      // Calculate catalogLocalHome and activityLocalHome variables
           	
      collBookRecords =
            catalogLocalHome.findByPlatform(workPlatform);
      
      Iterator iterator = collBookRecords.iterator();
            
      while (iterator.hasNext())
       {
        bookCatalogLocal = 
            (TechLibBook_catalogLocal) iterator.next();
       
        transObject = new TransportBean();
        
        transObject.catalogNumber   = bookCatalogLocal.getCatalog_number();
        transObject.author          = bookCatalogLocal.getAuthor();
        transObject.bookTitle       = bookCatalogLocal.getBook_title();
        transObject.location        = bookCatalogLocal.getLocation();
        transObject.platform        = bookCatalogLocal.getPlatform();
        transObject.txnDate         = bookCatalogLocal.getLanguage();
              
        bookVector.addElement(transObject);
       } // End of while
     
      } // End of try	 
     
     catch(Exception e)
      {
        System.out.println("Error executing findByPlatform WITHIN getBookByPlatform:" +
                                                                           e.getMessage());
                                               
        throw
          new EJBException("Error executing findByPlatform WITHIN getBookByPlatform:" +
                                                                           e.getMessage());
      }
               
     return bookVector;
     	
  }	  
  

 // Business method
 public Vector getBookActivity(String workCatalogNumber)
    throws FinderException   
  {
    Vector activityVector = new Vector();
  	
    TransportBean transObject; // Receiving object from Book_activity method
    TechLibBook_activityLocal bookActivityLocal = null; 
    Collection         collActivityRecords;
    try
     {
       collActivityRecords =      
                activityLocalHome.findByBook(workCatalogNumber);	
      
      Iterator iterator = collActivityRecords.iterator(); 
            
      while (iterator.hasNext())
       {
        bookActivityLocal = 
            (TechLibBook_activityLocal) iterator.next();
       
        transObject = new TransportBean();
        
        transObject.txnDate      = bookActivityLocal.getTxn_date();
        transObject.txnType      = bookActivityLocal.getTxn_type();
        transObject.companyName  = bookActivityLocal.getCompany_name();
        activityVector.addElement(transObject);
       } // End of while
     
      } // End of try	 
     
    catch(Exception e)
     {
      System.out.println("Error executing findByPlatform WITHIN getBookByPlatform:" +
                                                                           e.getMessage());
      throw
        new EJBException("Error executing findByPlatform WITHIN getBookByPlatform:" +
                                                                           e.getMessage());
      }
    
   
     return activityVector;
     	
  }	  
  
  public javax.ejb.SessionContext getSessionContext()
   {
     return mySessionCtx;
   }
    public void setSessionContext(javax.ejb.SessionContext ctx)
	{
		mySessionCtx = ctx;
	}

    public void ejbCreate() throws javax.ejb.CreateException
	{
	}
    public void ejbActivate()
	{
	}
    public void ejbPassivate()
	{
	}
    public void ejbRemove()
	{
	}
}
