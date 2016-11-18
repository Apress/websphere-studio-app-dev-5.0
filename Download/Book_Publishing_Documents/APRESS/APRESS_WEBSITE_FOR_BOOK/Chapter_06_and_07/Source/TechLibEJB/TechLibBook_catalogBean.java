package apress.wsad.techlib;

/**
 * Bean implementation class for Enterprise Bean: Book_catalog
 */
public abstract class TechLibBook_catalogBean implements javax.ejb.EntityBean
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
	public apress.wsad.techlib.TechLibBook_catalogKey ejbCreate(
		java.lang.String catalog_number)
		throws javax.ejb.CreateException
	{
		setCatalog_number(catalog_number);
		return null;
	}
	
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(java.lang.String catalog_number)
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
	public apress.wsad.techlib.TechLibBook_catalogKey ejbCreate(
		String catalog_number,
		String author,
		String book_title,
		String location,
		String platform,
		String language)
		throws javax.ejb.CreateException
	{
		setCatalog_number(catalog_number);
		setAuthor(author);
		setBook_title(book_title);
		setLocation(location);
		setPlatform(platform);
		setLanguage(language);
		return null;
	}
	
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(
		String catalog_number,
		String author,
		String book_title,
		String location,
		String platform,
		String language)
		throws javax.ejb.CreateException
	{
	}
	
	/**
	 * Get accessor for persistent attribute: catalog_number
	 */
	public abstract java.lang.String getCatalog_number();
	
	/**
	 * Set accessor for persistent attribute: catalog_number
	 */
	public abstract void setCatalog_number(java.lang.String newCatalog_number);
	
	/**
	 * Get accessor for persistent attribute: author
	 */
	public abstract java.lang.String getAuthor();
	
	/**
	 * Set accessor for persistent attribute: author
	 */
	public abstract void setAuthor(java.lang.String newAuthor);
	
	/**
	 * Get accessor for persistent attribute: book_title
	 */
	public abstract java.lang.String getBook_title();
	
	/**
	 * Set accessor for persistent attribute: book_title
	 */
	public abstract void setBook_title(java.lang.String newBook_title);
	
	/**
	 * Get accessor for persistent attribute: location
	 */
	public abstract java.lang.String getLocation();
	
	/**
	 * Set accessor for persistent attribute: location
	 */
	public abstract void setLocation(java.lang.String newLocation);

	/**
	 * Get accessor for persistent attribute: platform
	 */
	public abstract java.lang.String getPlatform();

	/**
	 * Set accessor for persistent attribute: platform
	 */
	public abstract void setPlatform(java.lang.String newPlatform);

	/**
	 * Get accessor for persistent attribute: language
	 */
	public abstract java.lang.String getLanguage();

	/**
	 * Set accessor for persistent attribute: language
	 */
	public abstract void setLanguage(java.lang.String newLanguage);
}
