package apress.wsad.techlib;

import java.io.Serializable;
import java.lang.*;
import java.util.*;
import javax.ejb.*;
import javax.naming.*;
import java.rmi.*;
import javax.ejb.Handle.*;
import apress.wsad.techlib.TransportBean;


public class BookByPlatformHelper1 implements Serializable   
{
 // Attributes
 TransportBean[] transObjList; 
 String selectedPlatform;
 Vector bookVector = null;
 
 // Variables to keep LocalHome and Local interfaces to the TechLibFacade1 statefull session bean 
 TechLibFacade1LocalHome facade1LocalHome = null; 
 TechLibFacade1Local facade1Local  = null;    
 
 /**
  * Default Constructor
  */
 public BookByPlatformHelper1()
 {
  super();
      
 }



 // Method to get the LocalHome Interface of the TechLibFacade1 session bean.
 private TechLibFacade1LocalHome getFacade1LocalHome()
       throws NamingException
  {
  	
  try
   { 
     if (facade1LocalHome == null)
       {
         	
        InitialContext initContext = new InitialContext();
          
        Object objRef =
                initContext.lookup("java:comp/env/TechLibFacade1");
                
             facade1LocalHome = (TechLibFacade1LocalHome) objRef;       
             return facade1LocalHome;
            }
           else    
            {
             return facade1LocalHome;	
            }	
         }             
       catch (NamingException e)
         {
          System.out.println("Exception in getFacade1LocalHome method: " +
                                               e.getMessage());
          throw
            new NamingException("Exception in getFacade1LocalHome method: " +
                                               e.getMessage());
         } 
  
     	
  }	


 // Method to get the Local Interface of the TechLibFacade1 statefull session bean.
 private TechLibFacade1Local getFacade1Local()
       throws RemoteException, CreateException
   {               
    try
     { 
       // Create local reference for the first time and 	
       facade1Local = facade1LocalHome.create();
              	
       return facade1Local; 
       
      } // End of the try block
     
     catch(Exception e)
      {
       System.out.println("Exception in getFacade1Local method: " +
                                               e.getMessage());
     throw
         new EJBException("Exception in getFacade1Local method: " +
                                               e.getMessage());
      }
           
  } // End of getFacade1Remote method


 // Common processing logic 
 public void populateIndexedAttribute()
  {
     
  try
   {
    facade1LocalHome = getFacade1LocalHome();
  
    facade1Local = getFacade1Local(); 
    
    // First call the initSataeVariables
    facade1Local.initStateVariables();
    
    // Now, we can call the getBookForPlatform business method    
    bookVector = facade1Local.getBookForPlatform(selectedPlatform);
  
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
  catch (Exception re)
   {
     System.out.println("RemoteException in the populateIndexedAttribute method: " +
                                               re.getMessage());
     throw
         new EJBException("RemoteException in the populateIndexedAttribute method: " +
                                               re.getMessage());
   } 
    
   
 } // End of the populateIndexedAttribute method 
  
  

 /**
  * Gets the transObjList
  * @return Returns a TransportBean[]
  */
 public TransportBean[] getTransObjList()
  {
   return transObjList;
  }

 /**
  * Sets the transObjList
  * @param transObjList The transObjList to set
  */
 public void setTransObjList(TransportBean[] transObjList)
 {
  this.transObjList = transObjList;
 }

 /**
  * Gets the selectedPlatform
  * @return Returns a String
  */
 public String getSelectedPlatform()
  {
   return selectedPlatform;
  }
 
 /**
  * Sets the selectedPlatform
  * @param selectedPlatform The selectedPlatform to set
  */
 public void setSelectedPlatform(String selectedPlatform)
 {
  this.selectedPlatform = selectedPlatform;
 }


}