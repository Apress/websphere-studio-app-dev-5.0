package apress.wsad.techlib;

/**
 * Home interface for Enterprise Bean: BookInquiry
 */
public interface BookInquiryHome extends javax.ejb.EJBHome
{
	/**
	 * Creates an instance from a key for Entity Bean: BookInquiry
	 */
	public BookInquiry create()
		throws javax.ejb.CreateException, java.rmi.RemoteException;
	
	/**
     * Second create method
     *   */
    public BookInquiry create(String catalogNumber,
                               String author,
                               String bookTitle,
                               String location,
                               String platform,
                               String language
                              )
   throws javax.ejb.CreateException,  java.rmi.RemoteException;
 
	
	/**
	 * Finds an instance using a key for Entity Bean: BookInquiry
	 */
	public BookInquiry findByPrimaryKey(BookInquiryKey primaryKey)
		throws javax.ejb.FinderException, java.rmi.RemoteException;
}


