Listing 7-11. BookByPlatformHelperX.java
package sams.wsad.techlib;
import java.io.Serializable;
import java.lang.*;
import java.util.*;
import javax.ejb.*;
import javax.naming.*;
import javax.rmi.*;
import java.rmi.*;
import javax.ejb.Handle.*;
import apress.wsad.techlib.TransportBean;

public class BookByPlatformHelperX implements Serializable
{
 // Attributes
 TransportBean[] transObjList; 
 String selectedPlatform;
 Vector bookVector = null;
 
 // Variable that keeps the home interface reference to Facade1 session bean 
 
 transient TechLibFacade1 facade1Remote  = null;    
 private   Handle remoteHandle = null;
 public BookByPlatformHelper1()
 {
  super();
 }

 // Method to get the Home Interface of the TechLibFacade1 session bean.
 private TechLibFacade1Home getFacade1Home()
  {
  	 TechLibFacade1Home facade1Home = null; 
     
     try
      {
       InitialContext ic = new InitialContext();
      
       Object objRef =
           ic.lookup("ejb/TechLibFacade1");
               
       facade1Home =
          (TechLibFacade1Home)
                javax.rmi.PortableRemoteObject.narrow
                         (objRef, TechLibFacade1Home.class); 
      }
     catch (NamingException ne)
      {
       System.out.println("Error locating TechLibFacade1Home: " +
                                               ne.getMessage());
                                               
       throw
         new EJBException("Error locating TechLibFacade1Home: " +
                                               ne.getMessage());
      } 
   return facade1Home; 
 }	

 // Method to get the Remote Interface of the TechLibFacade1 session bean.
 private TechLibFacade1 getFacade1Remote()
       throws RemoteException, CreateException
   {               
    try
     { 
      if (remoteHandle == null)
       {
        // Create remote handle for the first time 
		
		// Get the Home Interface
		facade1Home = getFacade1Home();
		
		if (facade1Home != 0)
		  {
		    facade1Remote = facade1Home.create();
            remoteHandle = facade1Remote.getHandle();   
		  }
         else
		  {
		  	throw
               new EJBException("facade1Home is null.");
		  }
       }	
      else
       {
         // Rectreate remote reference from handle
         facade1Remote = (TechLibFacade1) remoteHandle.getEJBObject();
       }	
       	
       return facade1Remote; 
       
      } // End of the try block
     
     catch(RemoteException re)
      {
       System.out.println("Error executing facade1.create() method: " +
                                               re.getMessage());
     throw
         new RemoteException("Error executing facade1.create() method: " +
                                               re.getMessage());
      }
      
     catch(CreateException cr)
      {
        System.out.println("Error executing facade1.create() method: " +
                                               cr.getMessage());
     throw
         new CreateException("Error executing facade1.create() method: " +
    	                                           cr.getMessage());
      }
       	 
        
  } // End of getFacade1Remote method





 // Business method 
 public void populateIndexedAttribute()
  {
  try
   {
   
    facade1Remote = getFacade1Remote(); 
    
    // First call the initSataeVariables
    facade1Remote.initStateVariables();
    
    // Now, we can call the getBookForPlatform business method    
    bookVector = facade1Remote.getBookForPlatform(selectedPlatform);
       
    if (bookVector == null)
     {
      transObjList = new TransportBean[1]; 
      
      transObjList[0] = new TransportBean();
      
      transObjList[0].setCatalogNumber("");
      transObjList[0].setBookTitle("");
      transObjList[0].setAuthor("");
      transObjList[0].setLocation("");
     }	
  else
     {
      // Convert bookVector to an array of TransportBean objects
      int workSize = bookVector.size(); 
      transObjList = new TransportBean[bookVector.size()]; 
      bookVector.copyInto(transObjList);
     }
  
   }
  catch (RemoteException re)
   {
     System.out.println("Error within populateIndexedAttribute() method: " +
                                               re.getMessage());
     throw
         new EJBException("Error within populateIndexedAttribute() metho: " +
                                               re.getMessage());
   } 
    
  catch (CreateException ce)
   {
     System.out.println("Error executing getFacade1Remote() method: " +
                                               ce.getMessage());
     throw
         new EJBException("Error executing getFacade1Remote() metho: " +
                                               ce.getMessage());
   }  
  
  } // End of the populateIndexedAttribute method 

public TransportBean[] getTransObjList()
  {
   return transObjList;
  }

public void setTransObjList(TransportBean[] transObjList)
 {
  this.transObjList = transObjList;
 }

public String getSelectedPlatform()
  {
   return selectedPlatform;
  }
 
public void setSelectedPlatform(String selectedPlatform)
 {
  this.selectedPlatform = selectedPlatform;
 }

}
