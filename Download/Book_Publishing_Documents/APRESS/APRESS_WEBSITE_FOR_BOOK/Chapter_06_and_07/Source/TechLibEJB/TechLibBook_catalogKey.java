package apress.wsad.techlib;
/**
 * Key class for Entity Bean: Book_catalog
 */
public class TechLibBook_catalogKey implements java.io.Serializable
{
	static final long serialVersionUID = 3206093459760846163L;
	/**
	 * Implementation field for persistent attribute: catalog_number
	 */
	public java.lang.String catalog_number;
	/**
	 * Creates an empty key for Entity Bean: Book_catalog
	 */
	public TechLibBook_catalogKey()
	{
	}
	/**
	 * Creates a key for Entity Bean: Book_catalog
	 */
	public TechLibBook_catalogKey(java.lang.String catalog_number)
	{
		this.catalog_number = catalog_number;
	}
	/**
	 * Returns true if both keys are equal.
	 */
	public boolean equals(java.lang.Object otherKey)
	{
		if (otherKey instanceof apress.wsad.techlib.TechLibBook_catalogKey)
		{
			apress.wsad.techlib.TechLibBook_catalogKey o =
				(apress.wsad.techlib.TechLibBook_catalogKey) otherKey;
			return ((this.catalog_number.equals(o.catalog_number)));
		}
		return false;
	}
	/**
	 * Returns the hash code for the key.
	 */
	public int hashCode()
	{
		return (catalog_number.hashCode());
	}
	/**
	 * Get accessor for persistent attribute: catalog_number
	 */
	public java.lang.String getCatalog_number()
	{
		return catalog_number;
	}
	/**
	 * Set accessor for persistent attribute: catalog_number
	 */
	public void setCatalog_number(java.lang.String newCatalog_number)
	{
		catalog_number = newCatalog_number;
	}
}
