package apress.wsad.techlib;

import java.io.Serializable;

/**
 * @author c6023
 *
 * To change this generated comment edit the template variable "typecomment":
 * Window>Preferences>Java>Templates.
 * To enable and disable the creation of type comments go to
 * Window>Preferences>Java>Code Generation.
 */
public class BookRegisterHelper implements Serializable
{
  // Attributes
	private String catalogNumber;
	private String author;
	private String bookTitle;
	private String location;
	private String platform;
	private String language;
	
	/**
	 * Constructor for BookRegisterHelper.
	 */
	public BookRegisterHelper()
	{
		super();
	}

	/**
	 * Returns the author.
	 * @return String
	 */
	public String getAuthor()
	{
		return author;
	}

	/**
	 * Returns the bookTitle.
	 * @return String
	 */
	public String getBookTitle()
	{
		return bookTitle;
	}

		/**
		 * Returns the catalogNumber.
		 * @return String
		 */
		public String getCatalogNumber()
		{
			return catalogNumber;
		}

	/**
	 * Returns the language.
	 * @return String
	 */
	public String getLanguage()
	{
		return language;
	}

	/**
	 * Returns the location.
	 * @return String
	 */
	public String getLocation()
	{
		return location;
	}

	/**
	 * Returns the platform.
	 * @return String
	 */
	public String getPlatform()
	{
		return platform;
	}

	/**
	 * Sets the author.
	 * @param author The author to set
	 */
	public void setAuthor(String author)
	{
		this.author = author;
	}

	/**
	 * Sets the bookTitle.
	 * @param bookTitle The bookTitle to set
	 */
	public void setBookTitle(String bookTitle)
	{
		this.bookTitle = bookTitle;
	}

		/**
		 * Sets the catalogNumber.
		 * @param catalogNumber The catalogNumber to set
		 */
		public void setCatalogNumber(String catalogNumber)
		{
			this.catalogNumber = catalogNumber;
		}

	/**
	 * Sets the language.
	 * @param language The language to set
	 */
	public void setLanguage(String language)
	{
		this.language = language;
	}

	/**
	 * Sets the location.
	 * @param location The location to set
	 */
	public void setLocation(String location)
	{
		this.location = location;
	}

	/**
	 * Sets the platform.
	 * @param platform The platform to set
	 */
	public void setPlatform(String platform)
	{
		this.platform = platform;
	}

}

