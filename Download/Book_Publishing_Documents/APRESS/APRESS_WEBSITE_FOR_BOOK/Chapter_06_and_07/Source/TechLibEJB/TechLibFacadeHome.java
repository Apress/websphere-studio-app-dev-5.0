package apress.wsad.techlib;
/**
 * Home interface for Enterprise Bean: TechLibFacade
 */
public interface TechLibFacadeHome extends javax.ejb.EJBHome
{
	/**
	 * Creates a default instance of Session Bean: TechLibFacade
	 */
	public apress.wsad.techlib.TechLibFacade create()
		throws javax.ejb.CreateException, java.rmi.RemoteException;
}
