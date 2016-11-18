package apress.wsad.techlib;

import java.util.*;

/**
 * Local Home interface for Enterprise Bean: Book_activity
 */
public interface TechLibBook_activityLocalHome extends javax.ejb.EJBLocalHome
{
	/**
	 * Creates an instance from a key for Entity Bean: Book_activity
	 */
	public apress.wsad.techlib.TechLibBook_activityLocal create(
		java.lang.String txn_date,
		java.lang.String txn_time)
		throws javax.ejb.CreateException;
		
	/**
	 * Creates an instance from a key for Entity Bean: Book_activity
	 */
	public apress.wsad.techlib.TechLibBook_activityLocal create(
		java.lang.String txn_date,
		java.lang.String txn_time,
		java.lang.String txn_type,
		java.lang.String book_cat_num,
		java.lang.String company_name)
		throws javax.ejb.CreateException;	
	
	/**
	 * Finds an instance using a key for Entity Bean: Book_activity
	 */
	public apress.wsad.techlib.TechLibBook_activityLocal findByPrimaryKey(
		apress.wsad.techlib.TechLibBook_activityKey primaryKey)
		throws javax.ejb.FinderException;
	   
    public Collection findByBook(java.lang.String workBookCatNum)
        throws javax.ejb.FinderException;

    public java.util.Collection findByCompany(java.lang.String workCompanyName)
    	throws javax.ejb.FinderException;


}
