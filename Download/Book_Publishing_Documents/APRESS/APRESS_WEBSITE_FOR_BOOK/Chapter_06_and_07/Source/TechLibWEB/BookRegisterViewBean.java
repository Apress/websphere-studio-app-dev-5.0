package apress.wsad.techlib;

import apress.wsad.techlib.BookRegisterHelper;


/**
*Description - BookRegister View Bean
* 
* An HTML View Bean wrappers your data so that you can capture the 
* output and make it HTML friendly
*/
public class BookRegisterViewBean
{
	//Original Java Bean
	protected apress.wsad.techlib.BookRegisterHelper bean;

	/*********************************************
	* Constructor
	*/
	public BookRegisterViewBean()
	{
		// obtain a reference to the bean or instantiate a
		// new instance here. Note that if instantiating a
		// new instance, be sure to create the properties
		// that will be modified from the JSP to avoid null
		// pointer exceptions.
		bean = new apress.wsad.techlib.BookRegisterHelper();
	}

	/*********************************************
	* Returns the raw bean
	*/
	public apress.wsad.techlib.BookRegisterHelper getBean()
	{
		return bean;
	}

	//Getters
	/*********************************************
	* Wrapper of the language getter
	*/
	public java.lang.String getLanguage()
	{
		java.lang.String ret = getBean().getLanguage();
		return ret;
	}
	/*********************************************
	* Wrapper of the catalogNumber getter
	*/
	public java.lang.String getCatalogNumber()
	{
		java.lang.String ret = getBean().getCatalogNumber();
		return ret;
	}
	/*********************************************
	* Wrapper of the author getter
	*/
	public java.lang.String getAuthor()
	{
		java.lang.String ret = getBean().getAuthor();
		return ret;
	}
	/*********************************************
	* Wrapper of the bookTitle getter
	*/
	public java.lang.String getBookTitle()
	{
		java.lang.String ret = getBean().getBookTitle();
		return ret;
	}
	/*********************************************
	* Wrapper of the location getter
	*/
	public java.lang.String getLocation()
	{
		java.lang.String ret = getBean().getLocation();
		return ret;
	}
	/*********************************************
	* Wrapper of the platform getter
	*/
	public java.lang.String getPlatform()
	{
		java.lang.String ret = getBean().getPlatform();
		return ret;
	}

	//Setters
	/*********************************************
	* Wrapper of the language setter
	*/
	public void setLanguage(java.lang.String language)
	{
		getBean().setLanguage(language);
	}
	/*********************************************
	* Wrapper of the catalogNumber setter
	*/
	public void setCatalogNumber(java.lang.String catalogNumber)
	{
		getBean().setCatalogNumber(catalogNumber);
	}
	/*********************************************
	* Wrapper of the author setter
	*/
	public void setAuthor(java.lang.String author)
	{
		getBean().setAuthor(author);
	}
	/*********************************************
	* Wrapper of the bookTitle setter
	*/
	public void setBookTitle(java.lang.String bookTitle)
	{
		getBean().setBookTitle(bookTitle);
	}
	/*********************************************
	* Wrapper of the location setter
	*/
	public void setLocation(java.lang.String location)
	{
		getBean().setLocation(location);
	}
	/*********************************************
	* Wrapper of the platform setter
	*/
	public void setPlatform(java.lang.String platform)
	{
		getBean().setPlatform(platform);
	}

	/**********************************************
	* Formats code so that is HTML Friendly
	* @param in The incoming String
	* @return The formated String
	*/
	protected String massageOutput(Object in)
	{
		String out = (in != null) ? in.toString() : "";
		//Place code here to format your output
		return out;
	}
}
