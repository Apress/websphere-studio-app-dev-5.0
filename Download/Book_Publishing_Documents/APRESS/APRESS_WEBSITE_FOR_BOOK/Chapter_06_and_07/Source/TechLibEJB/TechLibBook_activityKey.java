package apress.wsad.techlib;
/**
 * Key class for Entity Bean: Book_activity
 */
public class TechLibBook_activityKey implements java.io.Serializable
{
	static final long serialVersionUID = 3206093459760846163L;
	/**
	 * Implementation field for persistent attribute: txn_date
	 */
	public java.lang.String txn_date;
	/**
	 * Implementation field for persistent attribute: txn_time
	 */
	public java.lang.String txn_time;
	/**
	 * Creates an empty key for Entity Bean: Book_activity
	 */
	public TechLibBook_activityKey()
	{
	}
	/**
	 * Creates a key for Entity Bean: Book_activity
	 */
	public TechLibBook_activityKey(
		java.lang.String txn_date,
		java.lang.String txn_time)
	{
		this.txn_date = txn_date;
		this.txn_time = txn_time;
	}
	/**
	 * Returns true if both keys are equal.
	 */
	public boolean equals(java.lang.Object otherKey)
	{
		if (otherKey instanceof apress.wsad.techlib.TechLibBook_activityKey)
		{
			apress.wsad.techlib.TechLibBook_activityKey o =
				(apress.wsad.techlib.TechLibBook_activityKey) otherKey;
			return (
				(this.txn_date.equals(o.txn_date)) && (this.txn_time.equals(o.txn_time)));
		}
		return false;
	}
	/**
	 * Returns the hash code for the key.
	 */
	public int hashCode()
	{
		return (txn_date.hashCode() + txn_time.hashCode());
	}
	/**
	 * Get accessor for persistent attribute: txn_date
	 */
	public java.lang.String getTxn_date()
	{
		return txn_date;
	}
	/**
	 * Set accessor for persistent attribute: txn_date
	 */
	public void setTxn_date(java.lang.String newTxn_date)
	{
		txn_date = newTxn_date;
	}
	/**
	 * Get accessor for persistent attribute: txn_time
	 */
	public java.lang.String getTxn_time()
	{
		return txn_time;
	}
	/**
	 * Set accessor for persistent attribute: txn_time
	 */
	public void setTxn_time(java.lang.String newTxn_time)
	{
		txn_time = newTxn_time;
	}
}
