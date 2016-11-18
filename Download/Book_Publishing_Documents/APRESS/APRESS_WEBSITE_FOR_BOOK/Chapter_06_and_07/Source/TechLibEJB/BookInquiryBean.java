package apress.wsad.techlib;

import javax.ejb.*;
import java.rmi.*;
import java.sql.*;
import java.lang.*;
import java.util.*;
import javax.naming.*;
import java.sql.Connection;
import javax.sql.DataSource;

/**
 * Bean implementation class for Enterprise Bean: BookInquiry
 */
public class BookInquiryBean implements javax.ejb.EntityBean
{
	private javax.ejb.EntityContext myEntityCtx;

  public String catalogNumber;
  public String author;
  public String bookTitle;
  public String location;
  public String platform;
  public String language;
  
  private ResultSet result = null;

 
    /**
	 * ejbCreate
	 */
	public BookInquiryKey ejbCreate()
		throws javax.ejb.CreateException
	{
		return null;
	}

	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate() throws javax.ejb.CreateException
	{
	}

  
 /**
  * ejbCreate
  */
 public BookInquiryKey ejbCreate(String catalogNumber,
                                  String author,
                                  String bookTitle,
                                  String location,
                                  String platform,
                                  String language
                                 )
  throws javax.ejb.CreateException
 {
  
  Connection dbCon = null;
  PreparedStatement prepStm = null;
  
  if (catalogNumber == null)
   {
    throw new javax.ejb.CreateException ("Invalid catalogNumber parameter");   	
   	
   }	
  
  this.catalogNumber = catalogNumber;
  this.author = author;
  this.bookTitle = bookTitle;
  this.location = location;
  this.platform = platform;
  this.language = language;
  
  try
  	 {
  	   	 	
      dbCon = this.getDBConnection();
  	
      prepStm = dbCon.prepareStatement("insert into LIB.BOOK_CATALOG " +
                                       "(CATALOG_NUMBER, AUTHOR, BOOK_TITLE, LOCATION, PLATFORM, LANGUAGE) " +
  	                                   "values (?,?,?,?,?,?)");
  	  
  	  prepStm.setString(1, catalogNumber);
  	  prepStm.setString(2, author);
  	  prepStm.setString(3, bookTitle);
  	  prepStm.setString(4, location);
  	  prepStm.setString(5, platform);
  	  prepStm.setString(6, language); 
  	
  	  if (prepStm.executeUpdate() != 1)
  	   {
  	     throw new EJBException ("Faild to add Catalog record to database - Create method");
  	   }
  	   
  	   return new BookInquiryKey(catalogNumber);
  	   	  
  	 }                               // End of the try statement
  	catch(SQLException sq)
  	 {
  	   System.out.println("SQL Error. " + sq);
  	   throw new EJBException("SQL call failed " + sq);
  	    	 	
  	 }	
  	
  	  	
  	finally
  	 {
  	   try
  	   {
  	     if (result != null) 
  	       result.close();
  	      	 	
  	     if (prepStm != null) 
  	       prepStm.close();
  	      	
  	     if (dbCon != null) 
  	       dbCon.close(); 	
        }	
  	   catch (SQLException se)
  	    {
  	   	 se.printStackTrace();
  	    }	
    	  	
  	 } // End of the finally statement 	
  	 
  
  //return new BookInquiryKey(catalogNumber);
 }

 
 /**
  * ejbPostCreate
  */
 public void ejbPostCreate(String catalogNumber,
                            String author,
                            String bookTitle,
                            String location,
                            String platform,
                            String language
                           )
  throws javax.ejb.CreateException
 {

 }
 

 /**
  * ejbFindByPrimaryKey
  */
  public BookInquiryKey ejbFindByPrimaryKey(BookInquiryKey primaryKey)
		throws javax.ejb.FinderException
	{
	
	 Connection dbCon = null;
    
     PreparedStatement prepStm = null;
     	  	
  	 catalogNumber = primaryKey.getCatalogNumber();
    
     
    	
  	 try
  	  {
  	 	
  	  	
       dbCon = this.getDBConnection();
  	
       prepStm = dbCon.prepareStatement("select CATALOG_NUMBER,AUTHOR,BOOK_TITLE,LOCATION,PLATFORM,LANGUAGE " +
  	                                    "from LIB.BOOK_CATALOG " +
  	                                    "where CATALOG_NUMBER=?");
  	                                    
  	  
  	   prepStm.setString(1, catalogNumber); 
  	  
  	   result = prepStm.executeQuery();
  	 
      // Does the book exists
      if (result.next())
       {
  	    author = result.getString("AUTHOR");
  	    bookTitle = result.getString("BOOK_TITLE");
  	    location = result.getString("LOCATION");
  	    platform = result.getString("PLATFORM");
        language = result.getString("LANGUAGE"); 
        
        System.out.println("Author = " + author);
        System.out.println("Book_TITLE = " + bookTitle);
        System.out.println("Location = " + location);
        System.out.println("Platform = " + platform);
        System.out.println("Language = " + language); 
                
  	   }	
 	
  	 }	 
 	catch(SQLException sql)
  	 {
  	   System.out.println("SQL Error. " + sql);
  	   
  	  try
  	   {
  	    if (prepStm != null) 
  	      prepStm.close();
  	      	
  	    if (dbCon != null) 
  	      dbCon.close(); 	
       }	
      catch (SQLException se)
       {
       // Ignore this exceptin
  	   }	
  	    	   
  	   throw new EJBException("SQL call failed " + sql);
  	    	 	
  	 }	
  	
  	
  	finally
  	 {
  	   try
  	   {
  	     if (result != null) 
  	       result.close();
  	      	 	
  	     if (prepStm != null) 
  	       prepStm.close();
  	      	
  	     if (dbCon != null) 
  	       dbCon.close(); 	
        }	
  	   catch (SQLException se)
  	    {
  	   	 se.printStackTrace();
  	    }	
    	  	
  	 } // End of the finally statement 	
    	        
        //10-15-03 trying to comment out first line, use 2nd
        //return new BookInquiryKey(catalogNumber);      	
    	return primaryKey; 
		//return null;
	}


	
	/**
	 * ejbLoad
	 */
	public void ejbLoad()
	{
	  Connection dbCon = null;
    PreparedStatement prepStm = null;
    
   // modifying post-class session on 10-15-03 -- by SMB-C
   // String catalogNumber = (String)myEntityCtx.getPrimaryKey(); 
    BookInquiryKey bik = (BookInquiryKey)myEntityCtx.getPrimaryKey(); 
  	
  	try
  	 {
  	   	 	
      dbCon = this.getDBConnection();
  	
      prepStm = dbCon.prepareStatement("select AUTHOR, BOOK_TITLE, LOCATION, PLATFORM, LANGUAGE " +
  	                                   "from LIB.BOOK_CATALOG " +
  	                                   "where CATALOG_NUMBER = ?");
  	
  	  // 10-15-03  goes this mod above ...
  	  //prepStm.setString(1, catalogNumber);
  	  prepStm.setString(1, bik.getCatalogNumber());
  	  
  	  
  	  result = prepStm.executeQuery();
  	  
  	  if (result.next())
  	   {
  	   	 author    = result.getString("AUTHOR");
  	   	 bookTitle = result.getString("BOOK_TITLE"); 
  	     location  = result.getString("LOCATION");
  	     platform  = result.getString("PLATFORM");
  	     language  = result.getString("LANGUAGE");
  	   } 
  	  else
  	   {
  	    throw new EJBException ("Faild ejbLoad processing");
  	   }
  	     
   	  
  	 }                               // End of the try statement
  	catch(SQLException sq)
  	 {
  	   System.out.println("SQL Error. " + sq);
  	   throw new EJBException("SQL call failed " + sq);
  	    	 	
  	 }	
  	
  	finally
  	 {
  	   try
  	   {
  	     if (result != null) 
  	       result.close();
  	      	 	
  	     if (prepStm != null) 
  	       prepStm.close();
  	      	
  	     if (dbCon != null) 
  	       dbCon.close(); 	
        }	
  	   catch (SQLException se)
  	    {
  	   	 se.printStackTrace();
  	    }	
    	  	
  	 } // End of the finally statement 	
  	 

	}

	

	/**
	 * ejbRemove
	 */
	public void ejbRemove() throws javax.ejb.RemoveException
	{
	 Connection dbCon = null;
    PreparedStatement prepStm = null;
    
    String catalogNumber = (String)myEntityCtx.getPrimaryKey(); 
  	
  	try
  	 {
  	   	 	
      dbCon = this.getDBConnection();
  	
      prepStm = dbCon.prepareStatement("delete from LIB.BOOK_CATALOG where CATALOG_NUMBER = ?");
  	                                  
  	  
  	  prepStm.setString(1, catalogNumber);
  	    	  
  	  if (prepStm.executeUpdate() != 1)
  	   {
  	   	 
  	    throw new EJBException ("Faild ejbRemove processing");
  	   }
  	     
   	  
  	 }                               // End of the try statement
  	catch(SQLException sq)
  	 {
  	   System.out.println("SQL Error. " + sq);
  	   throw new EJBException("SQL call failed " + sq);
  	    	 	
  	 }	
  	
  	finally
  	 {
  	   try
  	   {
  	     if (result != null) 
  	       result.close();
  	      	 	
  	     if (prepStm != null) 
  	       prepStm.close();
  	      	
  	     if (dbCon != null) 
  	       dbCon.close(); 	
        }	
  	   catch (SQLException se)
  	    {
  	   	 se.printStackTrace();
  	    }	
    	  	
  	 } // End of the finally statement 	
  

	}

	/**
	 * ejbStore
	 */
	public void ejbStore()
	{
	 Connection dbCon = null;
    PreparedStatement prepStm = null;
    
  	
  	try
  	 {
  	 	
      dbCon = this.getDBConnection();
  	
      prepStm = dbCon.prepareStatement("update LIB.BOOK_CATALOG set AUTHOR = ?, BOOK_TITLE = ?, LOCATION = ?, PLATFORM = ?, LANGUAGE = ?" +
  	                                   "where CATALOG_NUMBER = ?");
  	
  	  
  	  prepStm.setString(1, author); 
  	  prepStm.setString(2, bookTitle);
  	  prepStm.setString(3, location);
  	  prepStm.setString(4, platform);
  	  prepStm.setString(5, language);
  	  prepStm.setString(6, catalogNumber);
  	  
  	  if (prepStm.executeUpdate() != 1)
  	   {
  	     throw new EJBException ("Faild ejbStore processing");
  	   }
  	     
   	  
  	 }                               // End of the try statement
  	catch(SQLException sq)
  	 {
  	   System.out.println("SQL Error. " + sq);
  	   throw new EJBException("SQL call failed " + sq);
  	    	 	
  	 }	
  	
  	finally
  	 {
  	   try
  	   {
  	     if (result != null) 
  	       result.close();
  	      	 	
  	     if (prepStm != null) 
  	       prepStm.close();
  	      	
  	     if (dbCon != null) 
  	       dbCon.close(); 	
        }	
  	   catch (SQLException se)
  	    {
  	   	 se.printStackTrace();
  	    }	
    	  	
  	 } // End of the finally statement 	
  	 

	
	}

	/**
	 * getEntityContext
	 */
	public javax.ejb.EntityContext getEntityContext()
	{
		return myEntityCtx;
	}

	/**
	 * setEntityContext
	 */
	public void setEntityContext(javax.ejb.EntityContext ctx)
	{
		myEntityCtx = ctx;
	}

	/**
	 * unsetEntityContext
	 */
	public void unsetEntityContext()
	{
		myEntityCtx = null;
	}

	
	
public Vector bookActivityByCompany(String companyName)
   {
    	 
  	 Connection dbCon = null;
    
     PreparedStatement prepStm = null;
     Vector vector = new Vector();  
  	
    	
  	try
  	 {
  	 	
  	  	
      dbCon = this.getDBConnection();
  	
      prepStm = dbCon.prepareStatement("select BOOK_TITLE, TXN_DATE, TXN_TYPE, COMPANY_NAME " +
  	                                    "from LIB.BOOK_CATALOG, LIB.BOOK_ACTIVITY " +
  	                                    "where COMPANY_NAME=? and CATALOG_NUMBER=BOOK_CAT_NUM");
  	
  	  
  	  prepStm.setString(1, companyName); 
  	  
  	  result = prepStm.executeQuery();
  	 
  	  while (result.next())
  	   {
  	     TransportBean transObject = new TransportBean();
  	      
  	     transObject.bookTitle = 	result.getString("BOOK_TITLE");
  	     transObject.txnDate =    	result.getString("TXN_DATE");
  	     transObject.txnType =   	result.getString("TXN_TYPE"); 	    
  	     transObject.companyName =  result.getString("COMPANY_NAME");
  	      	     
  	     vector.addElement(transObject);
  	    }
  	  
  	  return vector;
  	  
  	 }                               // End of the try statement
  	catch(SQLException sql)
  	 {
  	   System.out.println("SQL Error. " + sql);
  	   throw new EJBException("SQL call failed " + sql);
  	    	 	
  	 }	
  	
  	finally
  	 {
  	   try
  	   {
  	     if (result != null) 
  	       result.close();
  	      	 	
  	     if (prepStm != null) 
  	       prepStm.close();
  	      	
  	     if (dbCon != null) 
  	       dbCon.close(); 	
        }	
  	   catch (SQLException se)
  	    {
  	   	 se.printStackTrace();
  	    }	
    	  	
  	 } // End of the finally statement 	
  	 
  } // End of the method

    
    /**
	 * ejbActivate
	 */
	public void ejbActivate()
	{
	}


    /**
	 * ejbPassivate
	 */
	public void ejbPassivate()
	{
	}

 /**
  * getDBConnection
  */
 private Connection getDBConnection() throws SQLException
  {
   
   try
    {
     InitialContext jndiContext = new InitialContext();
     //changing to use the commented line 10/15/03
     // then, changed back
     //DataSource dataSource = (DataSource)jndiContext.lookup("java:comp/env/jdbc/TECHBOOK");
    DataSource dataSource = (DataSource)jndiContext.lookup("jdbc/TECHBOOK");
      
     return dataSource.getConnection(); 
      
    }
   catch(NamingException ne)
    {
      System.out.println("Error locating jdbc/TECHBOOK: " +  ne.getMessage());
                                               
       throw new EJBException(ne);
    }
        
  }
 




}