package apress.wsad.techlib;

import javax.ejb.FinderException;
import java.util.Vector;

/**
 * Local interface for Enterprise Bean: TechLibFacade1
 */
public interface TechLibFacade1Local extends javax.ejb.EJBLocalObject
{
	// Business method
	public Vector getBookForPlatform(String workPlatform)
	 throws FinderException;
	
	// Business method
	public Vector getBookActivity(String workCatalogNumber)
	     throws FinderException;

	// Business helper method. Must be promoted to the local interface
	public void initStateVariables() throws FinderException;
}
