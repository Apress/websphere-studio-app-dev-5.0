package apress.wsad.techlib;

import java.util.*;

/**
 * Local Home interface for Enterprise Bean: Book_catalog
 */
public interface TechLibBook_catalogLocalHome extends javax.ejb.EJBLocalHome
{
	/**
	 * Creates an instance from a key for Entity Bean: Book_catalog
	 */
	public TechLibBook_catalogLocal create(String catalog_number)
		throws javax.ejb.CreateException;
		
	/**
	 * Creates an instance from a key for Entity Bean: Book_catalog
	 */
	public apress.wsad.techlib.TechLibBook_catalogLocal create(
		                                      String catalog_number,
		                                      String author,
		                                      String book_title,
		                                      String location,
		                                      String platform,
		                                      String language
		)
	 throws javax.ejb.CreateException;	
		
	/**
	 * Finds an instance using a key for Entity Bean: Book_catalog
	 */
	public TechLibBook_catalogLocal findByPrimaryKey(
		                      TechLibBook_catalogKey primaryKey)
		throws javax.ejb.FinderException;
	
    public java.util.Collection findByPlatform(String workPlatform)
 	    throws javax.ejb.FinderException;

    public Collection findAll()
        throws javax.ejb.FinderException;

}
