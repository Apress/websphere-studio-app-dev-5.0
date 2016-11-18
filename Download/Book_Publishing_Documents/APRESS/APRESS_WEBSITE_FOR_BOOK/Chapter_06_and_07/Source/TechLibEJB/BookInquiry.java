package apress.wsad.techlib;

import java.util.Vector;
/**
 * Remote interface for Enterprise Bean: BookInquiry
 */
public interface BookInquiry extends javax.ejb.EJBObject
{
	public Vector bookActivityByCompany(String companyName)
		throws java.rmi.RemoteException;
}
