package apress.wsad.techlib;

/**
 * Key class for Entity Bean: BookInquiry
 */
public class BookInquiryKey implements java.io.Serializable
{
	static final long serialVersionUID = 3206093459760846163L;
	
	// Primary key
 	public String catalogNumber;
	
	/**
	 * Empty constructor is need by the Container
	 */
	public BookInquiryKey()
	{
	}
	
	/**
	 * Additional constructor. Sets the catalogNumber variable.
	 */
	public BookInquiryKey(String catalogNumber)
     {
      this.catalogNumber = catalogNumber;
     }

    /**
	 * getCatalogNumber
	 */
	public String getCatalogNumber()
     {
       return catalogNumber;
     }

    /**
	 * getCatalogNumber
	 */
	public void setCatalogNumber(String newCatalogNumber)
     {
       //this.catalogNumber = catalogNumber;
       // changed 10-15-03
       this.catalogNumber = newCatalogNumber;
     }	
	
	
	/**
	 * Returns true if both keys are equal.
	 */
	public boolean equals(java.lang.Object otherKey)
	{
		if (otherKey instanceof apress.wsad.techlib.BookInquiryKey)
		{
			apress.wsad.techlib.BookInquiryKey o =
				(apress.wsad.techlib.BookInquiryKey) otherKey;
			//return (super.equals(otherKey));
			//changed 10-15-03 to
			return((this.catalogNumber.equals(o.catalogNumber)));
		}
		return false;
	}
	
	/**
	 * Returns the hash code for the key.
	 */
	public int hashCode()
	{
		//return (super.hashCode());
		return (catalogNumber.hashCode());
	}
}

