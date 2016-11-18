package apress.wsad.techlib;
import javax.ejb.*;
import javax.naming.*;
import javax.rmi.*;
import java.rmi.*;
import java.lang.*;
import java.util.*;

public class TechLibFacadeBean implements javax.ejb.SessionBean
{
    private javax.ejb.SessionContext mySessionCtx;
	
    // Variable to keep the Home Local refernce to TechLibBook_catalog object
    private TechLibBook_catalogLocalHome catalogLocalHome = null;

    // Method to get the Home Interface of the Book_catalog entity bean.
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
          System.out.println("Error locating TechLibBook_catalogLocalHome: " +
                                               ne.getMessage());
          throw
            new RemoteException("Error locating TechLibBook_catalogLocalHome: " +
                                               ne.getMessage());
         } 
   }	
 
  // This business method must be promoted to the remote interface
  public Vector getBookForPlatform(String workPlatform)
     throws FinderException
   {
    Vector bookVector = new Vector();
    TransportBean transObject;
    TechLibBook_catalogLocal bookCatalogLocal = null; 
    Collection         collBookRecords;
        
    
    try
     {
      collBookRecords =
            getCatalogLocalHome().findByPlatform(workPlatform);
      
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
     catch(FinderException fe)
      {
        System.out.println("Error executing findByPlatform method: " + fe.getMessage());
                                               
        throw
          new EJBException("Error executing findByPlatform method: " + fe.getMessage());
      }
    
     catch(Exception e)
      {
        System.out.println("Error getting TechLibBook_catalogLocalHome from indByPlatform method:" +
                                                                             e.getMessage());
        throw
          new EJBException("Error getting TechLibBook_catalogLocalHome from findByPlatform method:" +
                                                                             e.getMessage());
      }
     return bookVector;
   }	  
  
    public javax.ejb.SessionContext getSessionContext()
	{
		return mySessionCtx;
	}

    public void setSessionContext(javax.ejb.SessionContext ctx)
	{
		mySessionCtx = ctx;
	}

	/**
	 * ejbCreate
	 */
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
