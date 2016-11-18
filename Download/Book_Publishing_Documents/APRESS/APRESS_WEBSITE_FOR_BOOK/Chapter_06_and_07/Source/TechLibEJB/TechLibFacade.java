package apress.wsad.techlib;
import javax.ejb.FinderException;
import java.util.Vector;
/**
 * Remote interface for Enterprise Bean: TechLibFacade
 */
public interface TechLibFacade extends javax.ejb.EJBObject
{
	// This business method must be promoted to the remote interface
	public Vector getBookForPlatform(String workPlatform)
		throws FinderException, java.rmi.RemoteException;
}
