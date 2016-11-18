package apress.wsad.techlib;
/**
 * Bean implementation class for Enterprise Bean: Book_activity
 */
public abstract class TechLibBook_activityBean implements javax.ejb.EntityBean
{
	private javax.ejb.EntityContext myEntityCtx;
	/**
	 * setEntityContext
	 */
	public void setEntityContext(javax.ejb.EntityContext ctx)
	{
		myEntityCtx = ctx;
	}
	/**
	 * getEntityContext
	 */
	public javax.ejb.EntityContext getEntityContext()
	{
		return myEntityCtx;
	}
	/**
	 * unsetEntityContext
	 */
	public void unsetEntityContext()
	{
		myEntityCtx = null;
	}
	/**
	 * ejbCreate
	 */
	public apress.wsad.techlib.TechLibBook_activityKey ejbCreate(
		java.lang.String txn_date,
		java.lang.String txn_time)
		throws javax.ejb.CreateException
	{
		setTxn_date(txn_date);
		setTxn_time(txn_time);
		return null;
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(
		java.lang.String txn_date,
		java.lang.String txn_time)
		throws javax.ejb.CreateException
	{
	}
	/**
	 * ejbActivate
	 */
	public void ejbActivate()
	{
	}
	/**
	 * ejbLoad
	 */
	public void ejbLoad()
	{
	}
	/**
	 * ejbPassivate
	 */
	public void ejbPassivate()
	{
	}
	/**
	 * ejbRemove
	 */
	public void ejbRemove() throws javax.ejb.RemoveException
	{
	}
	/**
	 * ejbStore
	 */
	public void ejbStore()
	{
	}
	/**
	 * ejbCreate method for a CMP entity bean.
	 */
	public apress.wsad.techlib.TechLibBook_activityKey ejbCreate(
		java.lang.String txn_date,
		java.lang.String txn_time,
		java.lang.String txn_type,
		java.lang.String book_cat_num,
		java.lang.String company_name)
		throws javax.ejb.CreateException
	{
		setTxn_date(txn_date);
		setTxn_time(txn_time);
		setTxn_type(txn_type);
		setBook_cat_num(book_cat_num);
		setCompany_name(company_name);
		return null;
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(
		java.lang.String txn_date,
		java.lang.String txn_time,
		java.lang.String txn_type,
		java.lang.String book_cat_num,
		java.lang.String company_name)
		throws javax.ejb.CreateException
	{
	}
	/**
	 * Get accessor for persistent attribute: txn_date
	 */
	public abstract java.lang.String getTxn_date();
	/**
	 * Set accessor for persistent attribute: txn_date
	 */
	public abstract void setTxn_date(java.lang.String newTxn_date);
	/**
	 * Get accessor for persistent attribute: txn_time
	 */
	public abstract java.lang.String getTxn_time();
	/**
	 * Set accessor for persistent attribute: txn_time
	 */
	public abstract void setTxn_time(java.lang.String newTxn_time);
	/**
	 * Get accessor for persistent attribute: txn_type
	 */
	public abstract java.lang.String getTxn_type();
	/**
	 * Set accessor for persistent attribute: txn_type
	 */
	public abstract void setTxn_type(java.lang.String newTxn_type);
	/**
	 * Get accessor for persistent attribute: book_cat_num
	 */
	public abstract java.lang.String getBook_cat_num();
	/**
	 * Set accessor for persistent attribute: book_cat_num
	 */
	public abstract void setBook_cat_num(java.lang.String newBook_cat_num);
	/**
	 * Get accessor for persistent attribute: company_name
	 */
	public abstract java.lang.String getCompany_name();
	/**
	 * Set accessor for persistent attribute: company_name
	 */
	public abstract void setCompany_name(java.lang.String newCompany_name);
}
